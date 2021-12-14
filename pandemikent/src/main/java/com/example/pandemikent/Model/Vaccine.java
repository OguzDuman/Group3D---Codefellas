package com.example.pandemikent.Model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VACCINE")
public class Vaccine {
	
	// Properties
	@Id
	@Column(name = "vaccine_id")
	private Long vaccineId;
	
	@Column(name = "vaccine_date")
	private Date vaccineDate;
	
	@Column(name = "patient_id")
	private String patientId;
	
	@Enumerated
	@Column(name = "type")
	private VaccineType type;
	
	@Column(name = "successful")
	private Boolean successful;
	
	@Column(name = "dose_num")
	private Integer doseNum;

	// Constructors
	public Vaccine() {
	}

	public Vaccine(Long vaccineId, Date vaccineDate, String patientId, VaccineType type, Boolean successful,
			Integer doseNum) {
		this.vaccineId = vaccineId;
		this.vaccineDate = vaccineDate;
		this.patientId = patientId;
		this.type = type;
		this.successful = successful;
		this.doseNum = doseNum;
	}

	// Getters and Setters
	public Long getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Long vaccineId) {
		this.vaccineId = vaccineId;
	}

	public Date getVaccineDate() {
		return vaccineDate;
	}

	public void setVaccineDate(Date vaccineDate) {
		this.vaccineDate = vaccineDate;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public VaccineType getType() {
		return type;
	}

	public void setType(VaccineType type) {
		this.type = type;
	}

	public Boolean getSuccessful() {
		return successful;
	}

	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}

	public Integer getDoseNum() {
		return doseNum;
	}

	public void setDoseNum(Integer doseNum) {
		this.doseNum = doseNum;
	}
}
