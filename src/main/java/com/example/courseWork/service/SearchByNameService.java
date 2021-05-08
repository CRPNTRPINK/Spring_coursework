package com.example.courseWork.service;

import com.example.courseWork.models.CompTable;
import com.example.courseWork.models.Notebook;
import com.example.courseWork.models.Phone;
import com.example.courseWork.repo.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.ListUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SearchByNameService {

    @Autowired
    PhoneService phoneService;

    @Autowired
    NotebookService notebookService;

    @Autowired
    CompTableService compTableService;

    @Transactional
    public List<Object> findResult(String name){
        List<Phone> phones = phoneService.findBySegmentName(name);
        List<Notebook> notebooks = notebookService.findBySegmentName(name);
        List<CompTable> compTables = compTableService.findBySegmentName(name);
        List<Object> resultList = new ArrayList<>();
        resultList.addAll(phones);
        resultList.addAll(notebooks);
        resultList.addAll(compTables);
        return resultList;
    }
}
