package com.example.courseWork.service;

import com.example.courseWork.models.Manufacturer;
import com.example.courseWork.repo.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    @Transactional
    public List<Manufacturer> getAllManufacturer() {
        return manufacturerRepository.findAll();
    }

    @Override
    @Transactional
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    @Override
    @Transactional
    public Optional<Manufacturer> getManufacturer(Long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    @Transactional
    public void removeManufacturer(Long id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public boolean existsManufacturer(Long id) {
        return manufacturerRepository.existsById(id);
    }
}
