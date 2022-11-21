package com.isw.kayodeproject;

import com.isw.kayodeproject.entity.User;
import com.isw.kayodeproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class KayodeProjectApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(KayodeProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setEmail("kay@gmail.com");
//        user.setOccupation("engineer");
//        user.setName("kayodexo");
//        user.setPassword("realest");
//        userRepository.save(user);
//
}


//    @Bean
//    public PasswordEncoder PasswordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence rawPassword) {
//                return null;
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return false;
//            }
//
//            @Override
//            public boolean upgradeEncoding(String encodedPassword) {
//                return PasswordEncoder.super.upgradeEncoding(encodedPassword);
//            }
//        };
//    }
}
