package com.isw.kayodeproject.service.impl;

import com.isw.kayodeproject.dto.RegistrationDto;
import com.isw.kayodeproject.entity.Role;
import com.isw.kayodeproject.entity.Users;
import com.isw.kayodeproject.repository.RoleRepository;
import com.isw.kayodeproject.repository.UserRepository;
import com.isw.kayodeproject.service.UserService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository
//                           ,PasswordEncoder passwordEncoder
                            ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        Users user = new Users();
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());

        // use spring security to encrypt the password


//        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
