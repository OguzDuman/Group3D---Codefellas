package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name = "CLASS")
public class Class {

	// Properties
	@Id
	@Column(name = "class_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqclass")
	@SequenceGenerator(name = "seqclass", sequenceName = "CLASS_SEQ", allocationSize = 1)
	private Long classId;

	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToMany()
    @JoinTable(
        name = "STUDENT", 
        joinColumns = { @JoinColumn(name = "classId") }, 
        inverseJoinColumns = { @JoinColumn(name = "studentId") }
    )
	private List<Student> students = new ArrayList<>();
	
	//@Enumerated(value = EnumType.STRING)   --- this was not worki`ngff
	@ElementCollection
	@CollectionTable(name = "time_slots")
	private List<TimeSlot> timeSlots = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "section_id")
	private List<Section> sections;
	
	@OneToMany
	@JoinColumn(name = "attendance_id")
	private List<Attendance> attendances;
	
	@OneToOne
	@JoinColumn(name = "make_up_exam_id")
	private MakeUpExam makeUpExam;

	// Constructors
	public Class() {
	}

	public Class(Long classId, String name, List<Student> students, List<TimeSlot> timeSlots, List<Section> sections,
			List<Attendance> attendances, MakeUpExam makeUpExam) {
		this.classId = classId;
		this.name = name;
		this.students = students;
		this.timeSlots = timeSlots;
		this.sections = sections;
		this.attendances = attendances;
		this.makeUpExam = makeUpExam;
	}

	// Getters and Setters
	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public MakeUpExam getMakeUpExam() {
		return makeUpExam;
	}

	public void setMakeUpExam(MakeUpExam makeUpExam) {
		this.makeUpExam = makeUpExam;
	}	
}
