package com.example.courseWork.controllers;

import com.example.courseWork.service.SearchByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchByNameService searchByNameService;

    @PostMapping("searchByName")
    public String searchByName(@RequestParam String name, Model model){
        List<Object> result = searchByNameService.findResult(name);
        model.addAttribute("product", result);
        return "search";
    }
}
