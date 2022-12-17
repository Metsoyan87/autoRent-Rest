package com.example.autorentrest.service;

import com.example.autorentrest.dto.EditUserDto;
import com.example.autorentrest.model.User;
import com.example.autorentrest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public List<User> getAllUser() {
         return userRepository.findAll();
    }
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findUserById(int Id) {
        return userRepository
                .findById(Id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
    public User save(User user) throws MessagingException {
        if (user == null) {
            throw new RuntimeException("User can't be null");
        }
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        if (userRepository.findById(id).isEmpty()) {
            log.info("user dos not exist");
            throw new RuntimeException("User can not a found");
        }
        userRepository.deleteById(id);

    }
    public void editUser(int id, EditUserDto dto) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalStateException("User not found");
        }
        User user = optional.get();
        edit(user, dto);
    }
    private ResponseEntity<User> edit(User user, @NotNull EditUserDto dto) {

        String email = dto.getEmail();
        String password = dto.getPassword();
        String phoneNumber = dto.getPhone();
        String card = dto.getCard();
        String driverLicense = dto.getDriverLicense();

        if (StringUtils.hasText(email)) {
            user.setEmail(email);
        }
        if (StringUtils.hasText(password)) {
            user.setPassword(passwordEncoder.encode(password));
        }
        if (StringUtils.hasText(phoneNumber)) {
            user.setPhoneNumber(phoneNumber);
        }
        if (StringUtils.hasText(card)) {
            user.setCard(card);
        }
        if (StringUtils.hasText(driverLicense)) {
            user.setDriverLicense(driverLicense);
        }
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}