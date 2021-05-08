package com.example.courseWork.controllers;


import com.example.courseWork.models.Category;
import com.example.courseWork.models.Manufacturer;
import com.example.courseWork.models.Phone;
import com.example.courseWork.service.CategoryService;
import com.example.courseWork.service.ManufacturerService;
import com.example.courseWork.service.PhoneService;
import com.example.courseWork.service.SearchByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class MyController {

    @Autowired
    private CategoryService categoryService;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/")
    public String getAllCategories(Model model) {
        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute("category", allCategories);
        return "home";
    }

    @GetMapping("/addCategory")
    public String addCategory(@ModelAttribute("category") Category category){
        return "category-add";
    }

    @PostMapping("/addCategory")
    public String saveCategory(@ModelAttribute("category") @Valid Category category,
                               BindingResult bindingResult, @RequestParam MultipartFile file) throws Exception{
        if (bindingResult.hasErrors()){
            return "category-add";
        }

        if (file.getOriginalFilename().length() != 0){
            File uploadFolder = new File(uploadPath);
            if (!uploadFolder.exists()){
                uploadFolder.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            category.setFilename(resultFileName);
        }else {
            Category categoryFileName = categoryService.getCategory(category.getId()).orElseThrow();
            category.setFilename(categoryFileName.getFilename());
        }
        categoryService.addCategory(category);
        return "redirect:/";
    }

    @GetMapping("updateCategory/{id}")
    public String updateCategory(@PathVariable long id, Model model){
        Category category = categoryService.getCategory(id).orElseThrow();
        model.addAttribute("category", category);
        return "category-add";
    }

    @GetMapping("removeCategory/{id}")
    public String removeCategory(@PathVariable long id){
        categoryService.removeCategory(id);
        return "redirect:/";
    }

    @GetMapping("manufacturer")
    public String getAllManufacturer(Model model){
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        model.addAttribute("manufacturer", manufacturers);
        return "manufacturer";
    }

    @GetMapping("addManufacturer")
    public String addManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer){
        return "manufacturer-add";
    }

    @PostMapping("addManufacturer")
    public String saveManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer){
        manufacturerService.addManufacturer(manufacturer);
        return "redirect:/manufacturer";
    }

    @GetMapping("updateManufacturer/{id}")
    public String updateManufacturer(@PathVariable Long id, Model model){
        Manufacturer manufacturer = manufacturerService.getManufacturer(id).orElseThrow();
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturer-add";
    }

    @GetMapping("deleteManufacturer/{id}")
    public String deleteManufacturer(@PathVariable Long id){
        manufacturerService.removeManufacturer(id);
        return "redirect:/manufacturer";
    }
}