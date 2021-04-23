package com.example.courseWork.controllers;

import com.example.courseWork.models.Role;
import com.example.courseWork.models.User;
import com.example.courseWork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class Registration {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null) {
            model.addAttribute("msg", "Пользователь существует");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.addUser(user);
        return "redirect:/login";
    }
}
