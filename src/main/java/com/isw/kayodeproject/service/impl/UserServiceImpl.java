package com.isw.kayodeproject.service.impl;

//import com.isw.kayodeproject.config2.SecurityConfig;
import com.isw.kayodeproject.dto.RegistrationDto;
import com.isw.kayodeproject.entity.Role;
import com.isw.kayodeproject.entity.User;
//import com.isw.kayodeproject.enums.UserRole;
import com.isw.kayodeproject.repository.RoleRepository;
import com.isw.kayodeproject.repository.UserRepository;
import com.isw.kayodeproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncode;

        private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository
                           ,PasswordEncoder passwordEncoder
                            ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getName());
//        user.setRole(String.valueOf(UserRole.ADMIN));
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
//        user.setPassword(registrationDto.getPassword());


//        Optional<User> byName = findByName(user.getName());


//        convert date string coming from the form to date object
        String dobString = registrationDto.getDob();
//        Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(dobString);
        Date dob = java.sql.Date.valueOf(dobString);
        user.setDob(dob);

//        user.setDob(registrationDto.getDob());
        user.setOccupation(registrationDto.getOccupation());

        // use spring security to encrypt the password


        Role role = roleRepository.findByName("USER");

        System.out.println("The role object is " + role.toString());
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
