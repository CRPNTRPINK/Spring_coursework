package com.example.courseWork.dao;

import com.example.courseWork.models.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerDAO {
    public List<Manufacturer> getAllManufacturer();
    public void saveManufacturer(Manufacturer manufacturer);
    public Optional<Manufacturer> getManufacturer(Long id);
    public void removeManufacturer(long id);
    public boolean existsManufacturer(Long id);
}
