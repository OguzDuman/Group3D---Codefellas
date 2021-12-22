package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SECTION")
public class Section {
	
	// Properties
	@Id
	@Column(name = "section_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	@SequenceGenerator(name = "seq_section", sequenceName = "SECTION_SEQ", allocationSize = 1)
	private Long sectionId;

	@Column(name = "section_number", nullable = false)
	private String sectionNumber;
	
	@ManyToMany()
    @JoinTable(
        name = "STUDENTS", 
        joinColumns = { @JoinColumn(name = "sectionId") }, 
        inverseJoinColumns = { @JoinColumn(name = "studentId") }
    )
	private List<Student> students = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "make_up_session_id")
	private List<MakeUpSession> makeUpSessions;
	
	@OneToOne
	@JoinColumn(name = "username")
	private Instructor instructor;
	
	@OneToMany
	@JoinColumn(name = "attendances_id")
	private List<Attendance> attendances;

	// Constructors
	public Section() {
	}

	public Section(Long sectionId, String sectionNumber, List<Student> students, List<MakeUpSession> makeUpSessions, Instructor instructor, List<Attendance> attendances) {
		this.sectionId = sectionId;
		this.sectionNumber = sectionNumber;
		this.students = students;
		this.makeUpSessions = makeUpSessions;
		this.instructor = instructor;
		this.attendances = attendances;
	}

	// Getters and Setters
	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(String sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<MakeUpSession> getMakeUpSessions() {
		return makeUpSessions;
	}

	public void setMakeUpSessions(List<MakeUpSession> makeUpSessions) {
		this.makeUpSessions = makeUpSessions;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}
	
}
