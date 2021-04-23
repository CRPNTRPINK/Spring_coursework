package com.example.courseWork.dao;

import com.example.courseWork.models.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneDAO {
    public List<Phone> getAllPhones();
    public Optional<Phone> getPhone(Long id);
    public void savePhone(Phone phone);
    public void removePhone(Long id);
}
