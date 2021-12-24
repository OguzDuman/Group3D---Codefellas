package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "classesz")
public class Class {

	// Properties
	@Id
	@Column(name = "class_name", nullable = false)
	private String name;
	
	@ElementCollection
	@CollectionTable(name = "reg_students")
	private List<String> students = new ArrayList<>();
	

	// @ElementCollection(targetClass = TimeSlot.class)
	// @Enumerated(value = EnumType.STRING)   --- this was not worki`ngffnumerated(value = EnumType.STRING)
	// private List<TimeSlot> timeSlots;

	@ElementCollection
	@CollectionTable(name = "time_slots")
	private List<TimeSlot> timeSlots = new ArrayList<>();

	
    // @Cascade(CascadeType.SAVE_UPDATE) CS2
	// @OneToMany
	@CollectionTable(name = "section_id")
	@ElementCollection
	private List<String> sections = new ArrayList<>();;
	
	// @OneToOne
	// @JoinColumn(name = "attendance_id")
	// private Attendance attendance;
	
	@Cascade(CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "make_up_exam_id")
	private MakeUpExam makeUpExam;

	// Constructors
	public Class() {
		
	}

	// public Class(String name, List<Student> students, List<TimeSlot> timeSlots, List<Section> sections,
	// 		Attendance attendance, MakeUpExam makeUpExam) {
	// 	this.name = name;
	// 	this.students = students;
	// 	this.timeSlots = timeSlots;
	// 	this.sections = sections;
	// 	this.attendance = attendance;
	// 	this.makeUpExam = makeUpExam;
	// }
	
	// testing without attendance
	public Class(String name, List<String> students, List<TimeSlot> timeSlots, List<String> sections,
			 MakeUpExam makeUpExam) {
		this.name = name;
		this.students = students;
		this.timeSlots = timeSlots;
		this.sections = sections;
		this.makeUpExam = makeUpExam;
	}
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getStudents() {
		return students;
	}

	public void setStudents(List<String> students) {
		this.students = students;
	}

	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}

	public List<String> getSections() {
		return sections;
	}

	public void setSections(List<String> sections) {
		this.sections = sections;
	}



	public MakeUpExam getMakeUpExam() {
		return makeUpExam;
	}

	public void setMakeUpExam(MakeUpExam makeUpExam) {
		this.makeUpExam = makeUpExam;
	}	 

	public String toString() {
		return"sections = " +sections + "name = " + name;
	}
}	// public Attendance getAttendance() {
	// 	return attendance;
	// }

	// public void setAttendance(Attendance attendance) {
	// 	this.attendance = attendance;
	// }
