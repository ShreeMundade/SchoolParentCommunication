package com.sprint1.spc.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends User {

	public Admin(long id, String name, String password, String phoneNumber, String emailId, Role role) {
		super(id, name, password, phoneNumber, emailId, role);

	}

	public Admin(String name, String password, String phoneNumber, String emailId, Role role) {
		super(name, password, phoneNumber, emailId, role);

	}

	public Admin(String name, String password) {
		super(name, password);

	}

	public Admin() {
		super();

	}

}