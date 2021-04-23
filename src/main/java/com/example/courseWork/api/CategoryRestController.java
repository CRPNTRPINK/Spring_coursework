package com.example.courseWork.api;

import com.example.courseWork.exception_handling.NoSuchException;
import com.example.courseWork.models.Category;
import com.example.courseWork.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/category", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAllCategory(){
        List<Category> allCategory = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCategory(@PathVariable long id){
        Optional<Category> category = categoryService.getCategory(id);
        if (category.isEmpty()){
            throw new NoSuchException("There is no category with ID = " + id + " in database");
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> setCategory(@RequestBody @Valid Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        categoryService.addCategory(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    public ResponseEntity<Category> updateCategory(@RequestBody @Valid Category category){
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        categoryService.addCategory(category);
        return new ResponseEntity<>(category, HttpStatus.UPGRADE_REQUIRED);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Category> removeCategory(@PathVariable Long id){
        if (id == null) {
            throw new NoSuchException("No id");
        }
        if (!categoryService.existsCategory(id)){
            throw new NoSuchException("There is no category with ID = " + id + " in database");
        }
        categoryService.removeCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
