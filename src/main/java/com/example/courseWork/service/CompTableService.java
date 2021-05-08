package com.example.courseWork.service;

import com.example.courseWork.models.CompTable;
import com.example.courseWork.models.Phone;

import java.util.List;
import java.util.Optional;

public interface CompTableService {
    public List<CompTable> getAllCompTables();
    public Optional<CompTable> getCompTable(Long id);
    //    public void addCompTable(Phone phone);
    public CompTable addCompTable(CompTable compTable);
    public void removeCompTable(Long id);
    public List<CompTable> findBySegmentName(String name);
}
