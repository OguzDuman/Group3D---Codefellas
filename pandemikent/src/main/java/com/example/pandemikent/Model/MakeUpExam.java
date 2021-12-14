package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "MAKEUPEXAM")
public class MakeUpExam {
	
	//Properties
	@Id
	@Column(name = "exam_id")
	private String examID;
		
	@Column(name = "exam_date")
	private Date examDate;

    @Column(name = "student_ids")
	@ElementCollection
	private ArrayList<String> studentIDs;

    @Column(name = "reason")
	@ElementCollection
	private ArrayList<String> reason; //what is reason tho
		

	//Constructors
	public MakeUpExam() {
        this.examID = null;
        this.examDate = new Date();
        this.studentIDs = new ArrayList<String>();
        this.reason = new ArrayList<String>();
	}
		
	public MakeUpExam(int year, int month, int date, int hrs, int min, String examID, ArrayList<String> studentIDs, ArrayList<String> reason) {
		this.examDate = new Date(year, month, date, hrs, min);
        this.examID = examID;
        this.studentIDs = studentIDs;
        this.reason = reason;
	}

	//Gets & Sets
	public String getExamID() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

    public ArrayList<String> getStudentIDs() {
		return studentIDs;
	}

	public void setStudentIDs(ArrayList<String> studentIDs) {
		this.studentIDs = studentIDs;
	}

    public ArrayList<String> getReason() {
		return reason;
	}

	public void setReason(ArrayList<String> reason) {
		this.reason = reason;
	}
}