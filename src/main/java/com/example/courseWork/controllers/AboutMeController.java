package com.example.courseWork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutMeController {
    @GetMapping("/aboutMe")
    public String aboutMe(Model model){
        model.addAttribute("firstName", "Ислам");
        model.addAttribute("lastName", "Агиев");
        model.addAttribute("group", "ПИ19-1");
        return "about-me";
    }
}
