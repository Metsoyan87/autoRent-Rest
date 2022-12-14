package com.example.autorentrest.service;

import com.example.autorentrest.dto.EditUserDto;
import com.example.autorentrest.dto.UserResponseDto;
import com.example.autorentrest.mapper.UserMapper;
import com.example.autorentrest.model.User;
import com.example.autorentrest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public List<User> getAllUser() {
        List<User> all = userRepository.findAll();
        return all;
    }

    public User findUserById(int Id) {
        return userRepository
                .findById(Id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public void save(User user) {
        if (user == null) {
            throw new RuntimeException("User can't be null");
        }
        userRepository.save(user);
    }

    public void deleteById(int id) {
        if (userRepository.findById(id).isEmpty()) {
            log.info("user dos not exist");
            throw new RuntimeException("User can not a found");
        }
        userRepository.deleteById(id);

    }



    public ResponseEntity<UserResponseDto> update(EditUserDto editUserDto, int id) {

        Optional<User> user = userRepository.findById(id);
        User byId = user.get();
        if (editUserDto.getEmail() != null) {
            byId.setEmail(editUserDto.getEmail());
        }
        if (editUserDto.getPhoneNumber() != null) {
            byId.setName(editUserDto.getPhoneNumber());
        }
        if (editUserDto.getPassword() != null) {
            byId.setName(editUserDto.getPassword());
        }
        if (editUserDto.getDriverLicense() != null) {
            byId.setName(editUserDto.getDriverLicense());
        }
        if (editUserDto.getCard() != null) {
            byId.setName(editUserDto.getCard());
        }
        if (editUserDto.getImage() != null) {
            byId.setName(editUserDto.getImage());
        }
        userRepository.save(byId);
        UserResponseDto userResponseDto = userMapper.map(byId, UserResponseDto.class);
        return ResponseEntity.ok(userResponseDto);
    }

}
