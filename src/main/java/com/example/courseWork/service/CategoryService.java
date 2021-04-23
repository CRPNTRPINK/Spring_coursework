package com.example.courseWork.service;

import com.example.courseWork.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> getAllCategories();
    public void addCategory(Category category);
    public Optional<Category> getCategory(Long id);
    public void removeCategory(long id);
    public boolean existsCategory(Long id);
}
