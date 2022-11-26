package com.isw.kayodeproject.controller;

import com.isw.kayodeproject.dto.PostDto;
import com.isw.kayodeproject.dto.UsersDto;
import com.isw.kayodeproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String users(Model model){
        // the attributes for this hasn't been mapped

        List<UsersDto> users = null;
        users = userService.findAllUsers();

        model.addAttribute("users", users);
        return "/admin/users";
    }

    @GetMapping("/admin/users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return "redirect:/admin/users";
    }

}
