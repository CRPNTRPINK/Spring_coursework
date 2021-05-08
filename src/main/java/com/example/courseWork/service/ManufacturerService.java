package com.example.courseWork.service;

import com.example.courseWork.models.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    public List<Manufacturer> getAllManufacturer();
    public void addManufacturer(Manufacturer manufacturer);
    public Optional<Manufacturer> getManufacturer(Long id);
    public void removeManufacturer(Long id);
    public boolean existsManufacturer(Long id);
}
