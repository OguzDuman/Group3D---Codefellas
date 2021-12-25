package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "MAKEUPEXAM")
public class MakeUpExam {
	
	//Properties
	@Id
	@Column(name = "class_id")
	private String classId;
		
	@Column(name = "exam_date")
	private Date examDate;

    // @Column(name = "student_ids")
	// @ElementCollection
	// private List<String> studentIDs;

    @Column(name = "reason")
	@ElementCollection
	private List<String> reason; //what is reason tho
		

	//Constructors
	public MakeUpExam() {
        this.classId = null;
        this.examDate = new Date();
        // this.studentIDs = new ArrayList<String>();
        this.reason = new ArrayList<String>();
	}
		
	public MakeUpExam(int year, int month, int date, int hrs, int min, String examID, ArrayList<String> studentIDs, ArrayList<String> reason) {
		this.examDate = new Date(year, month, date, hrs, min);
        this.classId = examID;
        // this.studentIDs = studentIDs;
        this.reason = reason;
	}

	//Gets & Sets
	public String getExamID() {
		return classId;
	}

	public void setExamID(String examID) {
		this.classId = examID;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

    // public List<String> getStudentIDs() {
	// 	return studentIDs;
	// }

	// public void setStudentIDs(ArrayList<String> studentIDs) {
	// 	this.studentIDs = studentIDs;
	// }

    public List<String> getReason() {
		return reason;
	}

	public void setReason(ArrayList<String> reason) {
		this.reason = reason;
	}
}