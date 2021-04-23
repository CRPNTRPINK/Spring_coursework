package com.example.courseWork.dao;

import com.example.courseWork.models.Notebook;
import com.example.courseWork.models.Phone;

import java.util.List;
import java.util.Optional;

public interface NotebookDAO {
    public List<Notebook> getAllNotebooks();
    public Optional<Notebook> getNotebook(Long id);
    public void saveNotebook(Notebook notebook);
    public void removeNotebook(Long id);
}
