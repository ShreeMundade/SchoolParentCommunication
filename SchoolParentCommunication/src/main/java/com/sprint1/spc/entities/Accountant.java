package com.sprint1.spc.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Accountant")
public class Accountant extends User {

	public Accountant(long id, String username, String password, String phoneNumber, String emailId, Role role) {
		super(id, username, password, phoneNumber, emailId, role);

	}

	public Accountant(String username, String password, String phoneNumber, String emailId, Role role) {
		super(username, password, phoneNumber, emailId, role);

	}

	public Accountant(String username, String password) {
		super(username, password);

	}

	public Accountant() {
		super();

	}

	@Override
	public String toString() {
		return "Accountant [getId()=" + getId() + ", getUsername()=" + getName() + ", getPassword()=" + getPassword()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getEmailId()=" + getEmailId() + ", getRole()="
				+ getRole() + ", isLoggedIn()=" + isLoggedIn() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}