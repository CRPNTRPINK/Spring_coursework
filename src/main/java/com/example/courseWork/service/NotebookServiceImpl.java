package com.example.courseWork.service;

import com.example.courseWork.dao.NotebookDAO;
import com.example.courseWork.models.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookServiceImpl implements NotebookService{

    @Autowired
    NotebookDAO notebookDAO;

    @Override
    public List<Notebook> getAllNotebooks() {
        return  notebookDAO.getAllNotebooks();
    }

    @Override
    public Optional<Notebook> getNotebook(Long id) {
        return notebookDAO.getNotebook(id);
    }

    @Override
    public void addNotebook(Notebook notebook) {
        notebookDAO.saveNotebook(notebook);
    }

    @Override
    public void removeNotebook(Long id) {
        notebookDAO.removeNotebook(id);
    }
}
