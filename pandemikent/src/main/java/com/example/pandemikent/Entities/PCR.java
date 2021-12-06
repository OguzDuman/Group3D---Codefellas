package com.example.pandemikent.Entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PCR")
public class PCR {

	// Properties 
	@Id
	@Column(name = "pcr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqpcr")
	@SequenceGenerator(name = "seqpcr", sequenceName = "PCR_SEQ", allocationSize = 1)
	private Long pcrId;
	
	@Column(name = "patient_id", nullable = false)
	private String patientId;
	
	@Column(name = "pcr_date")
	private Date pcrDate;
	
	@Column(name = "result")
	private Boolean result;

	// Constructors
	public PCR() {
	}

	public PCR(Long pcrId, String patientId, Date pcrDate, boolean result) {
		this.pcrId = pcrId;
		this.patientId = patientId;
		this.pcrDate = pcrDate;
		this.result = result;
	}

	// Getters and Setters
	public Long getPcrId() {
		return pcrId;
	}

	public void setPcrId(Long pcrId) {
		this.pcrId = pcrId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public Date getPcrDate() {
		return pcrDate;
	}

	public void setPcrDate(Date pcrDate) {
		this.pcrDate = pcrDate;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
