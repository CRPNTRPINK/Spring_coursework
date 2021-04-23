package com.example.courseWork.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private List<Phone> phones;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private List<Notebook> notebooks;

    public void addPhoneToManufacturer(Phone phone){
        if (phones == null){
            phones = new ArrayList<>();
        }
        phones.add(phone);
        phone.setManufacturer(this);
    }

    public void addNotebookToManufacturer(Notebook notebook){
        if (notebooks == null){
            notebooks = new ArrayList<>();
        }
        notebooks.add(notebook);
        notebook.setManufacturer(this);
    }

    public Manufacturer() {
    }

    public Manufacturer(String name) {
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
