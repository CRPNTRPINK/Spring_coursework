package com.example.courseWork.repo;

import com.example.courseWork.models.CompTable;
import com.example.courseWork.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompTableRepository extends JpaRepository<CompTable, Long> {
    @Query(value = " SELECT c FROM CompTable c WHERE LOWER(c.name) LIKE CONCAT('%', LOWER(?1), '%') ")
    List<CompTable> findByNameSegment(String name);
}
