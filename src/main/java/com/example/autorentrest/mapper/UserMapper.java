package com.example.autorentrest.mapper;
import com.example.autorentrest.dto.CreateUserDto;
import com.example.autorentrest.dto.UserDto;
import com.example.autorentrest.model.User;
import org.mapstruct.Mapper;




@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(CreateUserDto createUserDto);
    UserDto map(User user);



}
