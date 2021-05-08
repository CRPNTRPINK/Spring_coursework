package com.example.courseWork.service;

import com.example.courseWork.models.Notebook;
import com.example.courseWork.repo.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookServiceImpl implements NotebookService{

    @Autowired
    NotebookRepository notebookRepository;

    @Override
    @Transactional
    public List<Notebook> getAllNotebooks() {
        return  notebookRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Notebook> getNotebook(Long id) {
        return notebookRepository.findById(id);
    }

    @Override
    @Transactional
    public void addNotebook(Notebook notebook) {
        notebookRepository.save(notebook);
    }

    @Override
    @Transactional
    public void removeNotebook(Long id) {
        notebookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Notebook> findBySegmentName(String name) {
        return notebookRepository.findByNameSegment(name);
    }
}
