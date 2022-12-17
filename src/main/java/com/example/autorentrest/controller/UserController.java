package com.example.autorentrest.controller;

import com.example.autorentrest.dto.CreateUserDto;
import com.example.autorentrest.dto.EditUserDto;
import com.example.autorentrest.dto.UserAuthDto;
import com.example.autorentrest.dto.UserAuthResponseDto;
import com.example.autorentrest.mapper.UserMapper;
import com.example.autorentrest.model.Role;
import com.example.autorentrest.model.User;
import com.example.autorentrest.service.UserService;
import com.example.autorentrest.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;


    @GetMapping("/users")
    public List<User> getUsers() {
        log.info("called by {controller users }");
        return userService.getAllUser();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id) {
        log.info("called by {controller get users }");
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        log.info("called by id {controller users }");
        Optional<User> byId = Optional.ofNullable(userService.findUserById(id));
        return byId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody CreateUserDto createUserDto) throws MessagingException {
        Optional<User> existingUser = userService.findByEmail(createUserDto.getEmail());
        log.info("called register {controller users }");
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        User user = userMapper.map(createUserDto);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userMapper.map(userService.save(user)));

    }
    @PostMapping("/user/auth")
    public ResponseEntity<?> auth(@RequestBody UserAuthDto userAuthDto) {
        Optional<User> byEmail = userService.findByEmail(userAuthDto.getEmail());
        log.info("called auth {controller users }");
        if (byEmail.isPresent()) {
            User user = byEmail.get();
            if (passwordEncoder.matches(userAuthDto.getPassword(), user.getPassword())) {
                return ResponseEntity.ok(UserAuthResponseDto.builder()
                        .token(jwtTokenUtil.generateToken(user.getEmail()))
                        .user(userMapper.map(user))
                        .build()
                );
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/users/edit/{id}")
    public EditUserDto updateUser(@PathVariable int id,
                                  @RequestBody EditUserDto editUserDto) {
        userService.editUser(id, editUserDto);
        log.info("called by update {controller users }");
        return editUserDto;
    }
}
