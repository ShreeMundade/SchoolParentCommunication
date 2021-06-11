package com.sprint1.spc.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Student_Class")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentClass {
	
	@Id
	private long classId;
	private String description;
	private int grade;
	private char division;
	
	@OneToMany
	private Set<Student> student;
	
	@OneToOne
	private Teacher classTeacher;
	
	@ManyToMany
	private List<Teacher> subjectTeacher;

	public StudentClass(long classId, String description, int grade, char division, Set<Student> student,
			Teacher classTeacher, List<Teacher> subjectTeacher) {
		super();
		this.classId = classId;
		this.description = description;
		this.grade = grade;
		this.division = division;
		this.student = student;
		this.classTeacher = classTeacher;
		this.subjectTeacher = subjectTeacher;
	}

	public StudentClass(String description, int grade, char division, Set<Student> student, Teacher classTeacher,
			List<Teacher> subjectTeacher) {
		super();
		this.description = description;
		this.grade = grade;
		this.division = division;
		this.student = student;
		this.classTeacher = classTeacher;
		this.subjectTeacher = subjectTeacher;
	}
	
	public StudentClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public char getDivision() {
		return division;
	}

	public void setDivision(char division) {
		this.division = division;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public Teacher getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}

	public List<Teacher> getSubjectTeacher() {
		return subjectTeacher;
	}

	public void setSubjectTeacher(List<Teacher> subjectTeacher) {
		this.subjectTeacher = subjectTeacher;
	}

	@Override
	public String toString() {
		return "StudentClass [classId=" + classId + ", description=" + description + ", grade=" + grade + ", division="
				+ division + ", student=" + student + ", classTeacher=" + classTeacher + ", subjectTeacher="
				+ subjectTeacher + "]";
	}
}