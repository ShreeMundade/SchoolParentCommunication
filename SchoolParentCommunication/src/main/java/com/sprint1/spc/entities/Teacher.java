package com.sprint1.spc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Teacher")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Teacher extends User {

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonBackReference
	private List<Subject> subjects;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonBackReference
	private List<StudentClass> studentClasses;

	@ManyToMany
	@JoinTable(name = "Teacher_Exam", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
	//@JsonBackReference
	private List<Exam> exams;

	//POJO for Teacher class.
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<StudentClass> getStudentClasses() {
		return studentClasses;
	}

	public void setStudentClasses(List<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Teacher(long id, String username, String password, String phoneNumber, String emailId, Role role,
			List<Subject> subjects, List<StudentClass> studentClasses, List<Exam> exams) {
		super(id, username, password, phoneNumber, emailId, role);
		this.subjects = subjects;
		this.studentClasses = studentClasses;
		this.exams = exams;
	}
	

	public Teacher(long id, String name, String password, String phoneNumber, String emailId, Role role,
			List<Exam> exams) {
		super(id, name, password, phoneNumber, emailId, role);
		this.exams = exams;
	}

	public Teacher(long id, String username, String password, String phoneNumber, String emailId, Role role) {
		super(id, username, password, phoneNumber, emailId, role);
	}

	public Teacher(String username, String password, String phoneNumber, String emailId, Role role) {
		super(username, password, phoneNumber, emailId, role);
	}

	public Teacher(String username, String password) {
		super(username, password);
	}

	public Teacher() {
		super();
	}

	@Override
	public String toString() {
		return "Teacher [subjects=" + subjects + ", studentClasses=" + studentClasses + ", exams=" + exams + "]";
	}
}