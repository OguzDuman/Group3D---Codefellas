package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="class")
public class Class {
    
    @Id
    @Column
    private String name = null;
    @Column
    private String instructor = null;
    @ElementCollection
    @CollectionTable(name ="users")
    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "Class")
    // @JoinColumn(name="users", updatable = true)
    private List<Integer> users;

    // Constructor
    public Class(String name, String instructor, List<Integer> users) {
        this.name = name;
        this.instructor = instructor;
        this.users = users;
    }

    // Constructor
    public Class() {
        this.name = null;
        this.instructor = null;
        this.users = new ArrayList<>();
    }

    // Functions
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void addUser(Integer user) {
        users.add(user);
    }

    public List<Integer> getUsers() {
        return users;
    }
}   

