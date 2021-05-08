package com.example.courseWork.controllers;

import com.example.courseWork.models.Category;
import com.example.courseWork.models.Manufacturer;
import com.example.courseWork.models.Phone;
import com.example.courseWork.service.CategoryService;
import com.example.courseWork.service.ManufacturerService;
import com.example.courseWork.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class PhoneController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    PhoneService phoneService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ManufacturerService manufacturerService;


    @GetMapping("/phone")
    public String getAllPhones(Model model, @RequestParam(required = false) Long manufacturer){
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        List<Phone> phones = phoneService.getAllPhones();
        if (manufacturer != null){
            phones= phones.stream().filter(m -> m.getManufacturer().getId().equals(manufacturer)).collect(Collectors.toList());
        }
        model.addAttribute("product", phones);
        model.addAttribute("manufacturer", manufacturers);
        return "phone/phone";
    }

    @GetMapping("/addPhone")
    public String addPhone(@ModelAttribute("phone") Phone phone, Model model){
        List<Category> category = categoryService.getAllCategories();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        model.addAttribute("category", category);
        model.addAttribute("manufacturer", manufacturers);
        return "phone/phone-add";
    }

    @PostMapping("/addPhone")
    public String savePhone(@ModelAttribute("phone") Phone phone,  @RequestParam Long category_id, @RequestParam Long manufacturer_id,
                            @RequestParam MultipartFile file) throws Exception{

        if (file.getOriginalFilename().length() != 0){
            File uploadFolder = new File(uploadPath);
            if (!uploadFolder.exists()){
                uploadFolder.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            phone.setFilename(resultFileName);
        } else {
            Phone phoneFileName = phoneService.getPhone(phone.getId()).orElseThrow();
            phone.setFilename(phoneFileName.getFilename());
        }

        Category category = categoryService.getCategory(category_id).orElseThrow();
        phone.setCategory(category);

        Manufacturer manufacturer = manufacturerService.getManufacturer(manufacturer_id).orElseThrow();
        phone.setManufacturer(manufacturer);
        phoneService.addPhone(phone);
        return "redirect:/phone";
    }

    @GetMapping("/updatePhone/{id}")
    public String updatePhone(@PathVariable Long id, Model model){
        Phone phone = phoneService.getPhone(id).orElseThrow();
        List<Category> category = categoryService.getAllCategories();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        model.addAttribute("category", category);
        model.addAttribute("manufacturer", manufacturers);
        model.addAttribute("phone", phone);
        return "phone/phone-add";
    }

    @GetMapping("/phoneInformation/{id}")
    public String phoneInfo(@PathVariable Long id, Model model){
        Phone phone = phoneService.getPhone(id).orElseThrow();
        phone.setView(phone.getView() + 1);
        phoneService.addPhone(phone);
        model.addAttribute("product", phone);
        return "phone/phone-info";
    }

    @GetMapping("/removePhone/{id}")
    public String removePhone(@PathVariable Long id){
        phoneService.removePhone(id);
        return "redirect:/phone";
    }
}
