package com.example.webfluxpostgresql.utils;

import com.example.webfluxpostgresql.dto.UserDto;
import com.example.webfluxpostgresql.entity.User;

public class UserUtils {
    public static User toUser(UserDto userDto) {
        return new User(userDto.getFirstName(), userDto.getLastName());
    }
}
