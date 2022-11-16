package com.isw.kayodeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class KayodeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KayodeProjectApplication.class, args);
    }


    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return null;
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return false;
            }

            @Override
            public boolean upgradeEncoding(String encodedPassword) {
                return PasswordEncoder.super.upgradeEncoding(encodedPassword);
            }
        };
    }
}
