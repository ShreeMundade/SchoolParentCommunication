package com.sprint1.spc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Student")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Student extends User {

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "Student_Exam", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
	//@JsonBackReference(value = "list_exam")
	private List<Exam> exam;

	@ElementCollection
	//@JsonBackReference(value = "Student_attendance")
	private List<Attendance> attendance;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "StudentClass")
	//@JsonBackReference(value="Student_class")
	private StudentClass studentClass;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonBackReference(value="Student_fee")
	private Fee fee;

	public List<Exam> getExam() {
		return exam;
	}

	public void setExam(List<Exam> exam) {
		this.exam = exam;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	
	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public Student(long id, String name, String password, String phoneNumber, String emailId, Role role, List<Exam> exam,
			List<Attendance> attendance,  StudentClass studentClass, Fee fee) {
		super(id, name, password, phoneNumber, emailId, role);
		this.exam = exam;
		this.attendance = attendance;
		
		this.studentClass = studentClass;
		this.fee = fee;
	}

	public Student(long id, String name, String password, String phoneNumber, String emailId, Role role) {
		super(id, name, password, phoneNumber, emailId, role);

	}

	public Student(String name, String password, String phoneNumber, String emailId, Role role) {
		super(name, password, phoneNumber, emailId, role);

	}

	public Student(String name, String password) {
		super(name, password);

	}

	public Student() {
		super();

	}

	@Override
	public String toString() {
		return "Student [exam=" + exam + ", attendance=" + attendance + ", studentClass=" + studentClass + ", fee="
				+ fee + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendance == null) ? 0 : attendance.hashCode());
		result = prime * result + ((exam == null) ? 0 : exam.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode());
		result = prime * result + ((studentClass == null) ? 0 : studentClass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (attendance == null) {
			if (other.attendance != null)
				return false;
		} else if (!attendance.equals(other.attendance))
			return false;
		if (exam == null) {
			if (other.exam != null)
				return false;
		} else if (!exam.equals(other.exam))
			return false;
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (!fee.equals(other.fee))
			return false;
		if (studentClass == null) {
			if (other.studentClass != null)
				return false;
		} else if (!studentClass.equals(other.studentClass))
			return false;
		return true;
	}

	
	

}