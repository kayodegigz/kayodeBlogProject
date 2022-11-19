package com.isw.kayodeproject.service;

import com.isw.kayodeproject.dto.RegistrationDto;
import com.isw.kayodeproject.entity.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}