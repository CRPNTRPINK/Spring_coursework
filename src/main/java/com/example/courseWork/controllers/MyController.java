package com.example.courseWork.controllers;


import com.example.courseWork.models.Category;
import com.example.courseWork.models.Phone;
import com.example.courseWork.service.CategoryService;
import com.example.courseWork.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PhoneService phoneService;
    @GetMapping("/")
    public String getAllCategories(Model model) {
        List<Category> allCategories = categoryService.getAllCategories();
        List<Phone> allPhones = phoneService.getAllPhones();
        model.addAttribute("category", allCategories);
        model.addAttribute("phone", allPhones);
        return "home";
    }

    @GetMapping("/addCategory")
    public String addCategory(@ModelAttribute("category") Category category){
        return "category-add";
    }

    @PostMapping("/addCategory")
    public String saveCategory(@ModelAttribute("category") @Valid Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "category-add";
        }
        categoryService.addCategory(category);
        return "redirect:/";
    }

    @GetMapping("updateCategory/{id}")
    public String updateCategory(@PathVariable long id, Model model){
        Category category = categoryService.getCategory(id).orElseThrow();
        model.addAttribute("category", category);
        return "category-update";
    }

    @GetMapping("removeCategory/{id}")
    public String removeCategory(@PathVariable long id){
        categoryService.removeCategory(id);
        return "redirect:/";
    }
}