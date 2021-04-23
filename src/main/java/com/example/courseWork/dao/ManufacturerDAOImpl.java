package com.example.courseWork.dao;

import com.example.courseWork.models.Manufacturer;
import com.example.courseWork.repo.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO{

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getAllManufacturer() {
        List<Manufacturer> allManufacturer = manufacturerRepository.findAll();
        return allManufacturer;
    }

    @Override
    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public Optional<Manufacturer> getManufacturer(Long id) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(id);
        return manufacturer;
    }

    @Override
    public void removeManufacturer(long id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public boolean existsManufacturer(Long id) {
        boolean manufacturer = manufacturerRepository.existsById(id);
        return manufacturer;
    }
}
