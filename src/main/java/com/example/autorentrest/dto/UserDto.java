package com.example.autorentrest.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
    private String driverLicense;
    private String card;
    private String picUrl;


}


