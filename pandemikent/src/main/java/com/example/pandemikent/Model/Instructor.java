package com.example.pandemikent.Model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
@DiscriminatorValue("Instructor")
public class Instructor extends UserProfile{
    @ElementCollection
    @CollectionTable(name ="history")
    private List<String> history = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name ="class_instructor")
    private List<String> classes = new ArrayList<>();

    public Instructor(String username, int id, String email) {
        super(username, id, email, true);
    }

    public Instructor() {
    }

    @Override
    public String toString() {
        return super.toString() + "Instructor [history=" + history + ", sections=" + classes + "]";
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> sections) {
        this.classes = sections;
    }
}

