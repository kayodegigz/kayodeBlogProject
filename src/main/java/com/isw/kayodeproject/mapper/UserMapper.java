package com.isw.kayodeproject.mapper;

import com.isw.kayodeproject.dto.UsersDto;
import com.isw.kayodeproject.entity.User;

public class UserMapper {

    public static UsersDto mapToUserDto(User user) {
        return UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .occupation(user.getOccupation())
                .dob(user.getDob())
                .build();
    }

    public static User mapToUser(UsersDto usersDto) {
        return User.builder()
                .id(usersDto.getId())
                .name(usersDto.getName())
                .email(usersDto.getEmail())
                .occupation(usersDto.getOccupation())
                .dob(usersDto.getDob())
                .build();
    }
}
