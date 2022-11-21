package com.isw.kayodeproject.service;

import com.isw.kayodeproject.dto.RegistrationDto;
import com.isw.kayodeproject.entity.User;

import java.text.ParseException;
import java.util.Optional;

public interface UserService {
    void saveUser(RegistrationDto registrationDto) throws ParseException;

    User findByEmail(String email);

    User findByName(String name);
}