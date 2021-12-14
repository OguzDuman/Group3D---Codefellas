package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
@DiscriminatorValue("Student")
public class Student extends UserProfile {
    
    public Student(String username, int id, String email) {
        super(username, id, email);
    }

    @ElementCollection
    @CollectionTable(name ="classList")
    private List<String> classes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name ="history")
    private List<String> history = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name ="closeContacts")
    private List<String> closeContacts = new ArrayList<>();

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<String> classes) {
        this.classes = classes;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

    public Student() {
    }
}
