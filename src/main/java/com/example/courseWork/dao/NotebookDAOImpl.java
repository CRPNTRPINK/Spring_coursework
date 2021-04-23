package com.example.courseWork.dao;

import com.example.courseWork.models.Notebook;
import com.example.courseWork.repo.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NotebookDAOImpl implements NotebookDAO{

    @Autowired
    private NotebookRepository notebookRepository;

    @Override
    public List<Notebook> getAllNotebooks() {
        List<Notebook> allNotebooks = notebookRepository.findAll();
        return allNotebooks;
    }

    @Override
    public Optional<Notebook> getNotebook(Long id) {
        Optional<Notebook> notebook = notebookRepository.findById(id);
        return notebook;
    }

    @Override
    public void saveNotebook(Notebook notebook) {
        notebookRepository.save(notebook);
    }

    @Override
    public void removeNotebook(Long id) {
        notebookRepository.deleteById(id);
    }
}
