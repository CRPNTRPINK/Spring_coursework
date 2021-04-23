package com.example.courseWork.service;

import com.example.courseWork.dao.ManufacturerDAO;
import com.example.courseWork.models.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{

    @Autowired
    private ManufacturerDAO manufacturerDAO;

    @Override
    @Transactional
    public List<Manufacturer> getAllManufacturer() {
        return manufacturerDAO.getAllManufacturer();
    }

    @Override
    @Transactional
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturerDAO.saveManufacturer(manufacturer);
    }

    @Override
    @Transactional
    public Optional<Manufacturer> getManufacturer(Long id) {
        return manufacturerDAO.getManufacturer(id);
    }

    @Override
    @Transactional
    public void removeManufacturer(long id) {
        manufacturerDAO.removeManufacturer(id);
    }

    @Override
    @Transactional
    public boolean existsManufacturer(Long id) {
        return manufacturerDAO.existsManufacturer(id);
    }
}
