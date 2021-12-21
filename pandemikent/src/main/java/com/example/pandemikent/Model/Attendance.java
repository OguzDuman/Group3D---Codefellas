package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ATTENDANCE")
public class Attendance {
	
	//Properties
	@Id
	@Column(name = "attendance_id")
	private String attendanceID;
		
	@Column(name = "attendance_date")
	private Date attendanceDate;
		
	@Column(name = "student_ids")
	@ElementCollection
	private List<String> studentIDs;

	@Column(name = "attendence")
	@ElementCollection
	private List<Boolean> present;

    @Column(name = "reason")
	@ElementCollection
	private List<String> reason; //what is reason tho

	//Constructors
	public Attendance() {
        this.attendanceID = null;
        this.attendanceDate = new Date();
        this.studentIDs = new ArrayList<String>();
        this.reason = new ArrayList<String>();
	}
		
	public Attendance(int year, int month, int date, int hrs, int min, String attendanceID, ArrayList<String> studentIDs, ArrayList<String> reason) {
		this.attendanceDate = new Date(year, month, date, hrs, min);
        this.attendanceID = attendanceID;
        this.studentIDs = studentIDs;
        this.reason = reason;
	}

	//Gets & Sets
	public String getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(String attendanceID) {
		this.attendanceID = attendanceID;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public List<String> getStudentIDs() {
		return studentIDs;
	}

	public void setStudentIDs(ArrayList<String> studentIDs) {
		this.studentIDs = studentIDs;
	}

    public List<String> getReason() {
		return reason;
	}

	public void setReason(ArrayList<String> reason) {
		this.reason = reason;
	}
}