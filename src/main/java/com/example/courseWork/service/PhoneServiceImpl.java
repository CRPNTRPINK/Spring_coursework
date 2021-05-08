package com.example.courseWork.service;

import com.example.courseWork.models.Phone;
import com.example.courseWork.repo.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class PhoneServiceImpl implements PhoneService{


    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    @Transactional
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Phone> getPhone(Long id) {
        return phoneRepository.findById(id);
    }

    @Override
    @Transactional
    public Phone addPhone(Phone phone) {
        return phoneRepository.save(phone);
    }
    @Override
    @Transactional
    public void removePhone(Long id) {
        phoneRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Phone> findBySegmentName(String name) {
        return phoneRepository.findByNameSegment(name);
    }

    @Override
    public List<Phone> findByManufacturerId(Long id){
        return phoneRepository.findByIdManufacturer(id);
    }


}
