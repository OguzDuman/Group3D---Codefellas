package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
@DiscriminatorValue("Student")
public class Student extends UserProfile {
    // The identifies in the super class will automatically be used 
    // as an identifier here
    // @Id
    // @Column(name="username")
    // private String username;
    // @Column(name="id")
    // private int id;
    // @Column(name="email")
    // private String email;
    
    @ElementCollection
    @CollectionTable(name ="classList")
    private List<String> classes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name ="history")
    private List<String> history = new ArrayList<>();

    // public Student(String username, int id, String email) {
    //     this.username = username;
    //     this.id = id;
    //     this.email = email;
    // }

    // public String getUsername() {
    //     return username;
    // }

    // public void setUsername(String username) {
    //     this.username = username;
    // }

    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

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
