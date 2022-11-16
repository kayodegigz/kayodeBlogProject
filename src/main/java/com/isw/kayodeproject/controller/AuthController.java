package com.isw.kayodeproject.controller;

import com.isw.kayodeproject.dto.RegistrationDto;
import com.isw.kayodeproject.entity.Users;
import com.isw.kayodeproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle login page request
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    // handler method to handle user registration request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // this object contains the registration form data
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "/admin/posts";
//        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                           Model model){
        Users existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() !=null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already a user with same email id");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "/admin/posts";
//            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }
}