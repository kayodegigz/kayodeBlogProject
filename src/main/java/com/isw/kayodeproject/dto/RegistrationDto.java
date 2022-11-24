package com.isw.kayodeproject.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private Long id;

    @NotEmpty
    private String name;

    

    @NotEmpty
    private String occupation;

    @NotEmpty(message = "Email should not be empty or null")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotEmpty(message = "Please confirm the password you typed above")
    private String confirmPassword;

    @NotEmpty(message = "Please Enter your date of birth")
    private String dob;

    private String role;
}