package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Class {
    
    @Id
    private String name;
    private String instructor;
    @ElementCollection
    @CollectionTable(name ="user")
    @OneToMany
    @JoinColumn(name="user_id")
    private List<Integer> users = new ArrayList<Integer>();

    // Constructor
    public Class(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
    }

    public Class() {
        this.name = null;
        this.instructor = null;
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

