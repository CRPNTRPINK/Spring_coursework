package com.example.courseWork.repo;

import com.example.courseWork.models.Notebook;
import com.example.courseWork.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotebookRepository extends JpaRepository<Notebook, Long> {
    @Query(value = " SELECT n FROM Notebook n WHERE LOWER(n.name) LIKE CONCAT('%', LOWER(?1), '%') ")
    List<Notebook> findByNameSegment(String name);
}
