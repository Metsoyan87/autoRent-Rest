package com.example.autorentrest.dto;

import com.example.autorentrest.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
    private String driverLicense;
    private String card;
    private boolean isEnable;
    private Role role;
    private String picUrl;
    private String verifyToken;

}
