package com.example.pandemikent.Model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAKEUPSESSION")
public class MakeUpSession {
	
	//Properties
	@Id
	@Column(name = "session_id")
	private String sessionID;
		
	@Column(name = "session_date")
	private Date sessionDate;
		

	//Constructors
	public MakeUpSession() {
        this.sessionID = null;
        this.sessionDate = new Date();
	}
		
	public MakeUpSession(int year, int month, int date, int hrs, int min, String sessionID) {
		this.sessionDate = new Date(year, month, date, hrs, min);
        this.sessionID = sessionID;
	}

	//Gets & Sets
	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public Date getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}
}