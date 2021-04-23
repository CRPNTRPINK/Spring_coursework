package com.example.courseWork.dao;

import com.example.courseWork.models.Phone;
import com.example.courseWork.repo.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class PhoneDAOImpl implements PhoneDAO{

    @Autowired
    private PhoneRepository phoneRepository;


    @Override
    public List<Phone> getAllPhones() {
        List<Phone> allPhones = phoneRepository.findAll();
        return allPhones;
    }

    @Override
    public Optional<Phone> getPhone(Long id) {
        Optional<Phone> phone = phoneRepository.findById(id);
        return phone;
    }

    @Override
    public void savePhone(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void removePhone(Long id) {
        phoneRepository.deleteById(id);
    }
}