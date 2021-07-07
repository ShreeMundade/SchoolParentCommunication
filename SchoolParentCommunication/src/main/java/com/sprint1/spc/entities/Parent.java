package com.sprint1.spc.entities;

import java.util.*;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Parent")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Parent extends User {

//	@Access(AccessType.PROPERTY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonBackReference(value="students")
	private Set<Student> students;

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Parent(long id, String name, String password, String phoneNumber, String emailId, Role role,
			Set<Student> students) {
		super(id, name, password, phoneNumber, emailId, role);
		this.students = students;
	}

	public Parent(long id, String name, String password, String phoneNumber, String emailId, Role role) {
		super(id, name, password, phoneNumber, emailId, role);

	}

	public Parent(String name, String password, String phoneNumber, String emailId, Role role) {
		super(name, password, phoneNumber, emailId, role);

	}

	public Parent(String name, String password) {
		super(name, password);

	}

	public Parent() {
		super();

	}

	@Override
	public String toString() {
		return "Parent [students=" + students + "]";
	}
	

}