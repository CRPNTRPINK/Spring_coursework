package com.example.courseWork.service;

import com.example.courseWork.repo.CategoryRepository;
import com.example.courseWork.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Optional<Category> getCategory(Long id){
        return categoryRepository.findById(id);
    }

    @Override
    @Transactional
    public void removeCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public boolean existsCategory(Long id) {
        return categoryRepository.existsById(id);
    }

}
