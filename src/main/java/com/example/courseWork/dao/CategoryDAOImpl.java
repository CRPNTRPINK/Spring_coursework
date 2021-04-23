package com.example.courseWork.dao;

import com.example.courseWork.models.Category;
import com.example.courseWork.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        List<Category> AllCategory = categoryRepository.findAll();
        return AllCategory;
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        Optional<Category> category= categoryRepository.findById(id);
        return category;
    }

    @Override
    public void removeCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean existsCategory(Long id) {
        boolean category = categoryRepository.existsById(id);
        return category;
    }
}
