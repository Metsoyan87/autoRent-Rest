package com.example.autorentrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String driver;
    private String picUrl;
    private String cart;

}
