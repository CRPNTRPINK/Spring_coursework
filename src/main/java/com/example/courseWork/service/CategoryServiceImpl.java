package com.example.courseWork.service;

import com.example.courseWork.dao.CategoryDAO;
import com.example.courseWork.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @org.springframework.transaction.annotation.Transactional
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    @Transactional
    public void addCategory(Category category) {
        categoryDAO.saveCategory(category);
    }

    @Override
    @Transactional
    public Optional<Category> getCategory(Long id){
        return categoryDAO.getCategory(id);
    }

    @Override
    @Transactional
    public void removeCategory(long id) {
        categoryDAO.removeCategory(id);
    }

    @Override
    @Transactional
    public boolean existsCategory(Long id) {
        return categoryDAO.existsCategory(id);
    }

}
