package com.example.autorentrest.dto;

import com.example.autorentrest.model.Role;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;



@Data
public class EditUserDto {


    private String email;
    private String phoneNumber;
    private String password;
    private String driverLicense;
    private String card;
    private String image;

}
