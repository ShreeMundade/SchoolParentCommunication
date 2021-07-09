package com.sprint1.spc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Subject")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Subject {

	@Id
	@SequenceGenerator(name = "SubjectIdGeneration",sequenceName = "subjectSequence", initialValue = 10000, allocationSize = 1)
    @GeneratedValue(generator = "SubjectIdGeneration")
	private long subjectId;
	private String subjectTitle;

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public Subject(long subjectId, String subjectTitle) {
		super();
		this.subjectId = subjectId;
		this.subjectTitle = subjectTitle;
	}

	public Subject(long subjectId) {
		super();
		this.subjectId = subjectId;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(String subjectTitle) {
		super();
		this.subjectTitle = subjectTitle;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectTitle=" + subjectTitle + "]";
	}
}