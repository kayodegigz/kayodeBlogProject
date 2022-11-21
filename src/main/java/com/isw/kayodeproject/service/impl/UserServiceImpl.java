package com.isw.kayodeproject.service.impl;

import com.isw.kayodeproject.dto.RegistrationDto;
import com.isw.kayodeproject.entity.Role;
import com.isw.kayodeproject.entity.User;
import com.isw.kayodeproject.repository.RoleRepository;
import com.isw.kayodeproject.repository.UserRepository;
import com.isw.kayodeproject.service.UserService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

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
    public void saveUser(RegistrationDto registrationDto) throws ParseException {
        User user = new User();
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());

//        convert date string coming from the form to date object
        String dobString = registrationDto.getDob();
//        Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(dobString);
        Date dob = java.sql.Date.valueOf(dobString);
        user.setDob(dob);

//        user.setDob(registrationDto.getDob());
        user.setOccupation(registrationDto.getOccupation());

        // use spring security to encrypt the password

//        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
