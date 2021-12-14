package com.example.pandemikent.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HES_CODE")
public class HESCode {

	// Properties
	@Id
	@Column(name = "hes_code_id")
	private Long hesCodeId;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "patient_id", nullable = false)
	private String patientId;

	// Constructors
	public HESCode() {
	}

	// Getters and Setters
	public HESCode(Long hesCodeId, String code, String patientId) {
		this.hesCodeId = hesCodeId;
		this.code = code;
		this.patientId = patientId;
	}

	public Long getHesCodeId() {
		return hesCodeId;
	}

	public void setHesCodeId(Long hesCodeId) {
		this.hesCodeId = hesCodeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
}
