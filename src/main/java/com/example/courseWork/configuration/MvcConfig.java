package com.example.courseWork.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file://" + uploadPath + "/");
    }

}



//results = []
//category = new XMLHttpRequest()
//category.open('GET', 'http://localhost:8080/api/category')
//category.onload = function() {
//s = category.responseText
//json = JSON.parse(s)
//for (let [i, category] of json.entries()){
//results.push({[category.name]: 0})
//console.log(category);
//for (let phone of category.phones){
//results[i][category.name] += phone.view
//console.log(phone)
//}
//for (let notebook of category.notebooks){
//console.log(notebook)
//}
//for (let table of category.compTables){
//console.log(table)
//}
//}
//};
//category.send();
