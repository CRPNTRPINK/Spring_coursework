package com.example.courseWork.controllers;

import com.example.courseWork.models.Role;
import com.example.courseWork.models.User;
import com.example.courseWork.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class Registration {

    @Autowired
    UserService userService;


    @GetMapping("/account")
    public String getAllAccounts(Model model){
        List<User> accounts = userService.getAllUsers();
        model.addAttribute("account", accounts);
        return "user/user";
    }

    @GetMapping("/addAccount")
    public String addAccount(@ModelAttribute("account") User user, Model model){
        model.addAttribute("role", Role.values());
        return "user/user-add";
    }

    @PostMapping("/addAccount")
    public String saveAccount(@ModelAttribute("account") User user, Model model, @RequestParam String role){
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && user.getId() != foundUser.getId()) {
            model.addAttribute("msg", "Пользователь существует");
            return "user/user-add";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.valueOf(role)));
        userService.addUser(user);
        return "redirect:/account";
    }

    @GetMapping("/updateAccount/{username}")
    public String updateUser(@PathVariable String username, Model model){
        User user = userService.findByUsername(username);
        model.addAttribute("account", user);
        model.addAttribute("role", Role.values());
        return "user/user-add";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/account";
    }

    @GetMapping("/activeAccount/{username}")
    public String activeAccount(@PathVariable String username){
        User user = userService.findByUsername(username);
        if (user.isActive()){
            user.setActive(false);
        }
        else {
            user.setActive(true);
        }
        userService.saveFoundUser(user);
        return "redirect:/account";
    }
}
