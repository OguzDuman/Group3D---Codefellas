package com.example.pandemikent.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUARANTINE")
public class Quarantine {
	
	//Properties
	@Id
	@Column(name = "patient_id")
	private String patientID;
		
	@Column(name = "countdown_end")
	private Boolean didCountdownEnd;
		
	@Column(name = "days_left")
	private int daysLeft;

	//Constructors
	public Quarantine() {
        this.daysLeft = -1;
        this.didCountdownEnd = false;
        this.patientID= null;
	}
		
	public Quarantine(int daysLeft, Boolean didCountdownEnd, String patientID) {
		this.daysLeft = daysLeft;
		this.didCountdownEnd = didCountdownEnd;
		this.patientID = patientID;
	}

	//Gets & Sets
	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public Boolean getDidCountdownEnd() {
		return didCountdownEnd;
	}

	public void setCountdownEnd(Boolean didCountdownEnd) {
		this.didCountdownEnd = didCountdownEnd;
	}

	public String getPatientId() {
		return patientID;
	}

	public void setPatientId(String patientId) {
		this.patientID = patientId;
	}
}