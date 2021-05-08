package com.example.courseWork.controllers;

import com.example.courseWork.models.Category;
import com.example.courseWork.models.Manufacturer;
import com.example.courseWork.models.Notebook;
import com.example.courseWork.models.Phone;
import com.example.courseWork.service.CategoryService;
import com.example.courseWork.service.ManufacturerService;
import com.example.courseWork.service.NotebookService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class NotebookController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    NotebookService notebookService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ManufacturerService manufacturerService;

    @GetMapping("/notebook")
    public String getAllNotebooks(Model model, @RequestParam(required = false) Long manufacturer) {
        List<Notebook> notebooks = notebookService.getAllNotebooks();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();

        if (manufacturer != null){
            notebooks = notebooks.stream().filter(m -> m.getManufacturer().getId().equals(manufacturer)).collect(Collectors.toList());
        }
        model.addAttribute("product", notebooks);
        model.addAttribute("manufacturer", manufacturers);
        return "notebook/notebook";
    }

    @GetMapping("/addNotebook")
    public String addNotebook(@ModelAttribute("notebook") Notebook notebook, Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        model.addAttribute("category", categories);
        model.addAttribute("manufacturer", manufacturers);
        return "notebook/notebook-add";
    }

    @PostMapping("/addNotebook")
    public String saveNotebook(@ModelAttribute("notebook") Notebook notebook, @RequestParam Long category_id, @RequestParam Long manufacturer_id,
                               @RequestParam MultipartFile file) throws Exception {

        if (file.getOriginalFilename().length() != 0) {
            File uploadFolder = new File(uploadPath);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            notebook.setFilename(resultFileName);
        } else {
            Notebook notebookFileName = notebookService.getNotebook(notebook.getId()).orElseThrow();
            notebook.setFilename(notebookFileName.getFilename());
        }

        Category category = categoryService.getCategory(category_id).orElseThrow();
        notebook.setCategory(category);

        Manufacturer manufacturer = manufacturerService.getManufacturer(manufacturer_id).orElseThrow();
        notebook.setManufacturer(manufacturer);
        notebookService.addNotebook(notebook);
        return "redirect:/notebook";
    }

    @GetMapping("/updateNotebook/{id}")
    public String updateNotebook(@PathVariable Long id, Model model) {
        Notebook notebook = notebookService.getNotebook(id).orElseThrow();
        List<Category> category = categoryService.getAllCategories();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturer();
        model.addAttribute("category", category);
        model.addAttribute("manufacturer", manufacturers);
        model.addAttribute("notebook", notebook);
        return "notebook/notebook-add";
    }

    @GetMapping("/notebookInformation/{id}")
    public String notebookInfo(@PathVariable Long id, Model model){
        Notebook notebook = notebookService.getNotebook(id).orElseThrow();
        notebook.setView(notebook.getView() + 1);
        notebookService.addNotebook(notebook);
        model.addAttribute("product", notebook);
        return "notebook/notebook-info";
    }

    @GetMapping("/removeNotebook/{id}")
    public String removeNotebook(@PathVariable Long id){
        notebookService.removeNotebook(id);
        return "redirect:/notebook";
    }
}
