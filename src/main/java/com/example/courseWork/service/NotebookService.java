package com.example.courseWork.service;

import com.example.courseWork.models.Notebook;

import java.util.List;
import java.util.Optional;

public interface NotebookService {
    public List<Notebook> getAllNotebooks();
    public Optional<Notebook> getNotebook(Long id);
    public void addNotebook(Notebook notebook);
    public void removeNotebook(Long id);
}
