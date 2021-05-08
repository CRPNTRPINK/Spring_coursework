package com.example.courseWork.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 10, message = "size error")
    @Column(name="name")
    private String name;

    @Column(name = "filename")
    private String filename;

    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Phone> phones;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Notebook> notebooks;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<CompTable> compTables;


    public void addPhoneToCategory(Phone phone){
        if (phones == null){
            phones = new ArrayList<>();
        }
        phone.setCategory(this);
        phones.add(phone);
    }

    public void addNotebookToCategory(Notebook notebook){
        if (notebooks == null){
            notebooks = new ArrayList<>();
        }
        notebooks.add(notebook);
        notebook.setCategory(this);
    }

    public void addCompTableToCategory(CompTable compTable){
        if (compTables == null){
            compTables = new ArrayList<>();
        }
        compTables.add(compTable);
        compTable.setCategory(this);
    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public List<Notebook> getNotebooks() {
        return notebooks;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<CompTable> getCompTables() {
        return compTables;
    }
}
