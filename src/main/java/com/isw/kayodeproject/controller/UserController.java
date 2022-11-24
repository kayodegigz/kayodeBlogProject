//package com.isw.kayodeproject.controller;
//
//import com.isw.kayodeproject.entity.User;
//import com.isw.kayodeproject.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.security.Principal;
//
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepo;
//
//    public UserController(UserRepository userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @ModelAttribute
//    private void userDetails(Model m, Principal p) {
//        String email = p.getName();
//        User user = userRepo.findByEmail(email);
//
//        m.addAttribute("user", user);
//
//    }
////
//    @GetMapping("/")
//    public String userHome() {
//        return "/users/loginSuccess";
//    }
//}
