package com.example.autorentrest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String driverLicense;
    private String card;
    private MultipartFile image;
}
