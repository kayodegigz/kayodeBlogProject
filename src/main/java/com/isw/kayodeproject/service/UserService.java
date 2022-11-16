package com.isw.kayodeproject.service;

import com.isw.kayodeproject.dto.RegistrationDto;
import com.isw.kayodeproject.entity.Users;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    Users findByEmail(String email);
}