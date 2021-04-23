package com.example.courseWork.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 10, message = "size error")
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Phone> phones;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Notebook> notebooks;

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

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
