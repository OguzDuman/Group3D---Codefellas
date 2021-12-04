package com.example.pandemikent.Model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Section {
    // Fields
    @Id
    private String num;
    private ArrayList<String> studentIds;

    // Constructors
    public Section(String num, ArrayList<String> studentIds) {
        this.num = num;
        this.studentIds = studentIds;
    }

    public Section() {
        num = "";
        studentIds = new ArrayList<String>();
    }   
    
    // Functions
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public ArrayList<String> getStudentIds() {
        return studentIds;
    }
    public void setStudentIds(ArrayList<String> studentIds) {
        this.studentIds = studentIds;
    }
    
}
