package com.example.pandemikent.Model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS")
public class Class {

	// Properties
	@Id
	@Column(name = "class_name", nullable = false)
	private String name;
	
	@ManyToMany()
    @JoinTable(
        name = "STUDENT", 
        joinColumns = { @JoinColumn(name = "classId") }, 
        inverseJoinColumns = { @JoinColumn(name = "studentId") }
    )
	private List<Student> students;
	
	@ElementCollection(targetClass = TimeSlot.class)
	@Enumerated(value = EnumType.STRING)
	private List<TimeSlot> timeSlots;
	
	@OneToMany
	@JoinColumn(name = "section_id")
	private List<Section> sections;
	
	@OneToOne
	@JoinColumn(name = "attendance_ids")
	private Attendance attendance;
	
	@OneToOne
	@JoinColumn(name = "make_up_exam_id")
	private MakeUpExam makeUpExam;

	// Constructors
	public Class() {
	}

	public Class(String name, List<Student> students, List<TimeSlot> timeSlots, List<Section> sections,
			Attendance attendance, MakeUpExam makeUpExam) {
		this.name = name;
		this.students = students;
		this.timeSlots = timeSlots;
		this.sections = sections;
		this.attendance = attendance;
		this.makeUpExam = makeUpExam;
	}

	// Getters and Setters
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

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public MakeUpExam getMakeUpExam() {
		return makeUpExam;
	}

	public void setMakeUpExam(MakeUpExam makeUpExam) {
		this.makeUpExam = makeUpExam;
	}	
}
