package com.example.courseWork.service;

import com.example.courseWork.models.CompTable;
import com.example.courseWork.repo.CompTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompTableServiceImpl implements CompTableService{

    @Autowired
    CompTableRepository compTableRepository;
    @Override
    public List<CompTable> getAllCompTables() {
        return compTableRepository.findAll();
    }

    @Override
    public Optional<CompTable> getCompTable(Long id) {
        return compTableRepository.findById(id);
    }

    @Override
    public CompTable addCompTable(CompTable compTable) {

        return compTableRepository.save(compTable);
    }

    @Override
    public void removeCompTable(Long id) {
        compTableRepository.deleteById(id);
    }

    @Override
    public List<CompTable> findBySegmentName(String name) {
        return compTableRepository.findByNameSegment(name);
    }
}
