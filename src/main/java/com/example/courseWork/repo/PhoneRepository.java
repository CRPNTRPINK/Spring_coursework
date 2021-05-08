package com.example.courseWork.repo;

import com.example.courseWork.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    @Query(value = " SELECT p FROM Phone p WHERE LOWER(p.name) LIKE  CONCAT('%', LOWER(?1), '%') ")
    List<Phone> findByNameSegment(String name);
    @Query(value = "SELECT p FROM Phone p WHERE p.manufacturer = ?1")
    List<Phone> findByIdManufacturer(Long id);
}
