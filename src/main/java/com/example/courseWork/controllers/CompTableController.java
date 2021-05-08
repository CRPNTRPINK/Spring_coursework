package com.example.courseWork.controllers;

import com.example.courseWork.models.Category;
import com.example.courseWork.models.CompTable;
import com.example.courseWork.models.Manufacturer;
import com.example.courseWork.models.Phone;
import com.example.courseWork.service.CategoryService;
import com.example.courseWork.service.CompTableService;
import com.example.courseWork.service.ManufacturerService;
import com.example.courseWork.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class CompTableController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    CompTableService compTableService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ManufacturerService manufacturerService;

    @GetMapping("/compTable")
    public String getAllCompTables(Model model, @RequestParam(required = false) Long manufacturer){
        List<CompTable> compTables = compTableService.getAllCompTables();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        if (manufacturer != null){
            compTables= compTables.stream().filter(m -> m.getManufacturer().getId().equals(manufacturer)).collect(Collectors.toList());
        }
        model.addAttribute("product", compTables);
        model.addAttribute("manufacturer", manufacturers);
        return "compTable/compTable";
    }

    @GetMapping("/addCompTable")
    public String addCompTable(@ModelAttribute("compTable") CompTable compTable, Model model){
        List<Category> category = categoryService.getAllCategories();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        model.addAttribute("category", category);
        model.addAttribute("manufacturer", manufacturers);
        return "compTable/compTable-add";
    }

    @PostMapping("/addCompTable") // остановился тут
    public String saveCompTable(@ModelAttribute("compTable") CompTable compTable, @RequestParam Long category_id, @RequestParam Long manufacturer_id,
                            @RequestParam MultipartFile file) throws Exception{

        if (file.getOriginalFilename().length() != 0){
            File uploadFolder = new File(uploadPath);
            if (!uploadFolder.exists()){
                uploadFolder.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            compTable.setFilename(resultFileName);
        } else {
            CompTable compTableFileName = compTableService.getCompTable(compTable.getId()).orElseThrow();
            compTable.setFilename(compTableFileName.getFilename());
        }

        Category category = categoryService.getCategory(category_id).orElseThrow();
        compTable.setCategory(category);

        Manufacturer manufacturer = manufacturerService.getManufacturer(manufacturer_id).orElseThrow();
        compTable.setManufacturer(manufacturer);
        compTableService.addCompTable(compTable);
        return "redirect:/compTable";
    }

    @GetMapping("/updateCompTable/{id}")
    public String updateCompTable(@PathVariable Long id, Model model){
        CompTable compTable = compTableService.getCompTable(id).orElseThrow();
        List<Category> category = categoryService.getAllCategories();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        model.addAttribute("category", category);
        model.addAttribute("manufacturer", manufacturers);
        model.addAttribute("compTable", compTable);
        return "compTable/compTable-add";
    }

    @GetMapping("/compTableInformation/{id}")
    public String compTableInfo(@PathVariable Long id, Model model){
        CompTable compTable = compTableService.getCompTable(id).orElseThrow();
        compTable.setView(compTable.getView() + 1);
        compTableService.addCompTable(compTable);
        model.addAttribute("product", compTable);
        return "compTable/compTable-info";
    }

    @GetMapping("/removeCompTable/{id}")
    public String removeCompTable(@PathVariable Long id){
        compTableService.removeCompTable(id);
        return "redirect:/compTable";
    }
}
