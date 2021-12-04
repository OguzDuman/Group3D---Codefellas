package com.example.pandemikent.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int examId;
    private String reason;
    private String date;

    // Constructors
    public Exam( String reason, String date) {
        this.reason = reason;
        this.date = date;
    }

    public Exam() {

        this.reason = null;
        this.date = null;
    }

    @Override
    public String toString() {
        return "Exam [date=" + date + ", examId=" + examId + ", reason=" + reason + "]";
    }

    // Accessers And Mutators
    public int getExamId() {
        return examId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }   
}
