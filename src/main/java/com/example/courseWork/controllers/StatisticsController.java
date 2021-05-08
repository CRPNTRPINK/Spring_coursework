package com.example.courseWork.controllers;


import com.example.courseWork.models.Category;
import com.example.courseWork.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class StatisticsController{

    @Autowired
    CategoryService categoryService;

    @GetMapping("/statistics")
    public String getStatistics(Model model){

        List<Category> category = categoryService.getAllCategories();
        model.addAttribute("category", category);
        return "statistics";
    }
}
