package com.example.autorentrest.mapper;


import com.example.autorentrest.dto.CreateUserDto;
import com.example.autorentrest.dto.SaveUserRequest;
import com.example.autorentrest.dto.UserDto;
import com.example.autorentrest.dto.UserResponseDto;
import com.example.autorentrest.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

        @Mapping(target = "role", defaultValue = "USER")
    User map(UserDto userDto);
    UserDto map(User user);




    UserResponseDto map(User byId, List<UserResponseDto> userResponseDtoClass);

    UserResponseDto map(User byId, Class<UserResponseDto> userResponseDtoClass);
}
