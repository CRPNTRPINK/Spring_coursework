package com.example.courseWork.dao;

import com.example.courseWork.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDAO {
    public List<Category> getAllCategories();
    public void saveCategory(Category category);
    public Optional<Category> getCategory(Long id);
    public void removeCategory(long id);
    public boolean existsCategory(Long id);
}
