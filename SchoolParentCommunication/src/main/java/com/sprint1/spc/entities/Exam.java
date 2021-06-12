package com.sprint1.spc.entities;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Exam")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Exam {

	@Id
	@SequenceGenerator(name = "ExamIdGeneration", initialValue = 3001, allocationSize = 1000)
	@GeneratedValue(generator = "ExamIdGeneration")
	private long examId;
	private LocalDate dateOfExam;
	private double maximumMarks;

	@ManyToOne
	//@JsonIgnore
	private Teacher conductedBy;

	@Embedded
	private ExamAttempt examAttempt;

	@ManyToOne
	//@JsonBackReference
	private Subject subject;

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public LocalDate getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(LocalDate dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

	public double getMaximumMarks() {
		return maximumMarks;
	}

	public void setMaximumMarks(double maximumMarks) {
		this.maximumMarks = maximumMarks;
	}

	public Teacher getConductedBy() {
		return conductedBy;
	}

	public void setConductedBy(Teacher conductedBy) {
		this.conductedBy = conductedBy;
	}

	public ExamAttempt getExamAttempt() {
		return examAttempt;
	}

	public void setExamAttempt(ExamAttempt examAttempt) {
		this.examAttempt = examAttempt;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Exam(LocalDate dateOfExam, double maximumMarks, ExamAttempt examAttempt, Subject subject) {
		super();
		this.dateOfExam = dateOfExam;
		this.maximumMarks = maximumMarks;
		this.examAttempt = examAttempt;
		this.subject = subject;
	}

	public Exam(LocalDate dateOfExam, double maximumMarks, Teacher conductedBy, Subject subject) {
		super();
		this.dateOfExam = dateOfExam;
		this.maximumMarks = maximumMarks;
		this.conductedBy = conductedBy;
		this.subject = subject;
	}

	public Exam(LocalDate dateOfExam, double maximumMarks) {
		super();
		this.dateOfExam = dateOfExam;
		this.maximumMarks = maximumMarks;
	}

	public Exam(long examId, LocalDate dateOfExam, double maximumMarks, Teacher conductedBy, ExamAttempt examAttempt,
			Subject subject) {
		super();
		this.examId = examId;
		this.dateOfExam = dateOfExam;
		this.maximumMarks = maximumMarks;
		this.conductedBy = conductedBy;
		this.examAttempt = examAttempt;
		this.subject = subject;
	}

	public Exam(LocalDate dateOfExam, double maximumMarks, Teacher conductedBy, ExamAttempt examAttempt,
			Subject subject) {
		super();
		this.dateOfExam = dateOfExam;
		this.maximumMarks = maximumMarks;
		this.conductedBy = conductedBy;
		this.examAttempt = examAttempt;
		this.subject = subject;
	}

	public Exam(long examId, LocalDate dateOfExam, double maximumMarks, ExamAttempt examAttempt, Subject subject) {
		super();
		this.examId = examId;
		this.dateOfExam = dateOfExam;
		this.maximumMarks = maximumMarks;
		this.examAttempt = examAttempt;
		this.subject = subject;
	}

	public Exam() {
		super();

	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", dateOfExam=" + dateOfExam + ", maximumMarks=" + maximumMarks
				+ ", conductedBy=" + conductedBy + ", examAttempt=" + examAttempt + ", subject=" + subject + "]";
	}
}