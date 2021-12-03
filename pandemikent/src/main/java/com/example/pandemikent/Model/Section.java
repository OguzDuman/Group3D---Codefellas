package com.example.pandemikent.Model;

import java.util.ArrayList;


public class Section {
    // Fields

    private int num;
    private ArrayList<String> studentIds;

    // Constructors
    public Section(int num, ArrayList<String> studentIds) {
        this.num = num;
        this.studentIds = studentIds;
    }

    public Section() {
        num = 0;
        studentIds = new ArrayList<String>();
    }   
    
    // Functions
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public ArrayList<String> getStudentIds() {
        return studentIds;
    }
    public void setStudentIds(ArrayList<String> studentIds) {
        this.studentIds = studentIds;
    }
    
}
