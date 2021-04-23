package com.example.courseWork.service;

import com.example.courseWork.dao.CategoryDAO;
import com.example.courseWork.dao.PhoneDAO;
import com.example.courseWork.models.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class PhoneServiceImpl implements PhoneService{

    @Autowired
    private PhoneDAO phoneDAO;

    @Autowired CategoryService categoryService;


    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Phone> getAllPhones() {
        return phoneDAO.getAllPhones();
    }

    @Override
    @Transactional
    public Optional<Phone> getPhone(Long id) {
        return phoneDAO.getPhone(id);
    }

    @Override
    @Transactional
    public void addPhone(Phone phone) {
        phoneDAO.savePhone(phone);
    }

    @Override
    @Transactional
    public void removePhone(Long id) {
        phoneDAO.removePhone(id);
    }



}
