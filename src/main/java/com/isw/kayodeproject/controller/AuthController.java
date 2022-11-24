package com.isw.kayodeproject.controller;

import com.isw.kayodeproject.dto.RegistrationDto;
import com.isw.kayodeproject.entity.User;
import com.isw.kayodeproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Optional;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle login page request
    @GetMapping("/login")
    public String loginPage(){


//        return "login";
        return "/users/login";
    }

    @GetMapping("/admin/login")
    public String adminLoginPage(){


//        return "login";
        return "/admin/login";
    }


    @GetMapping("/user/")
    public String loginSuccess(Model model) {
        return "/users/loginSuccess";
    }
    // handler method to handle user registration request
    @GetMapping("/user/register")
    public String showRegistrationForm(Model model){
        // this object contains the registration form data
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "/users/register";
//        return "register";
    }

    @GetMapping("/admin/register")
    public String showAdminRegistrationForm(Model model){
        // this object contains the registration form data
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "/admin/register";
//        return "register";
    }


    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                           Model model) throws ParseException {
        // @Valid annotation applies the validation constraints that have been set on the registrationDto class
        // BindingResult is to display errors on the frontend

        User existingUser = userService.findByEmail(user.getEmail());
        System.out.println("This is the existing user " + existingUser);
//        if(existingUser != null && existingUser.getEmail() !=null && !existingUser.getEmail().isEmpty()){
//            result.rejectValue("email", null, "There is already a user with this same email, please use another");
//        }

        if(existingUser != null) {
            result.rejectValue("email", null, "There is already a user with this same email, please use another");
        }

        User existingUserName = userService.findByName(user.getName());
        if(existingUserName != null){
            result.rejectValue("name", null, "This username is taken already, please try another!");
        }



//        if(existingUserName != null){
//            result.rejectValue("name", null, "This username is taken already, please try another!");
//        }
//
        if((user.getPassword().length()< 7)) {
            result.rejectValue("password", null, "The password should be more than 7 characters long");
        }
//
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", null, "Passwords do not match");
        }
//
//        if (user.getDob() == null) {
//            result.rejectValue("dob", null, "Please enter your date of birth");
//        }
//
//        if (user.getDob() == null) {
//            result.rejectValue("occupation", null, "Please enter your occupation");
//        }

//        System.out.println("I got here");

        // if there are form related validation errors, they are handled here
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "/users/register";

//            return "register";
        }
        userService.saveUser(user);
//        System.out.println("I got here too");
        return "redirect:/register?success";
    }

    @PostMapping("/admin/register/save")
    public String registerAdmin(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                           Model model) throws ParseException {
        User existingUser = userService.findByEmail(user.getEmail());
        System.out.println("This is the existing user " + existingUser);

        if(existingUser != null) {
            result.rejectValue("email", null, "There is already a user with this same email, please use another");
        }

        User existingUserName = userService.findByName(user.getName());
        if(existingUserName != null){
            result.rejectValue("name", null, "This username is taken already, please try another!");
        }

        if((user.getPassword().length()< 7)) {
            result.rejectValue("password", null, "The password should be more than 7 characters long");
        }
//
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", null, "Passwords do not match");
        }

        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "/admin/register";

        }
        userService.saveAdmin(user);
        return "redirect:/admin/register?success";
    }
}