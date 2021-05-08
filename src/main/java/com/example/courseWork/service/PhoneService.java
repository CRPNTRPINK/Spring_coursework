package com.example.courseWork.service;

import com.example.courseWork.models.Phone;

import java.util.List;
import java.util.Optional;


public interface PhoneService {

    public List<Phone> getAllPhones();
    public Optional<Phone> getPhone(Long id);
//    public void addPhone(Phone phone);
    public Phone addPhone(Phone phone);
    public void removePhone(Long id);
    public List<Phone> findBySegmentName(String name);
    public List<Phone> findByManufacturerId(Long id);
}
