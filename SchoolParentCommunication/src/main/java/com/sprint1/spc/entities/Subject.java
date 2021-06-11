package com.sprint1.spc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Subject")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Subject {

	@Id
	private int subjectId;
	private String subjectTitle;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public Subject(int subjectId, String subjectTitle) {
		super();
		this.subjectId = subjectId;
		this.subjectTitle = subjectTitle;
	}

	public Subject(String subjectTitle) {
		super();
		this.subjectTitle = subjectTitle;
	}

	public Subject() {
		super();
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectTitle=" + subjectTitle + "]";
	}
}