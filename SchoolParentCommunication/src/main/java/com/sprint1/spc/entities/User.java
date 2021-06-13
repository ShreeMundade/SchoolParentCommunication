package com.sprint1.spc.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "User_SPC")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

	@Id
	@SequenceGenerator(name = "UserIdGeneration", initialValue = 1, allocationSize = 999)
    @GeneratedValue(generator = "UserIdGeneration")
	@ApiModelProperty(value = "Id - auto generated")
	private long id;

	@NotNull(message = "name must not be null.")
	@Size(min = 5, max = 15, message = "name must be between {min} and {max} characters.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "name can contain only alphanumeric characters.")
	@ApiModelProperty(value = "Description about name.")
	private String name;
	
	@NotNull(message = "Password must not be null.")
	@Size(min = 5, max = 15, message = "Password must be between {min} and {max} characters.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password can contain only alphanumeric characters.")
	@ApiModelProperty(value = "Password.")
	private String password;

	@NotNull(message = "Phone number must not be null.")
	@Size(min = 10, max = 10, message = "Phone number must be {max} digits.")
	@Pattern(regexp = "^\\+([0-9\\-]?){9,11}[0-9]$", message = "Phone number can contain only Numeric characters.")
	private long phoneNumber;
	
	@Email
	@NotNull(message = "Email must not be null.")
	@Email(message = "Email not formated correctly.")
	private String emailId;
	
	private boolean loggedIn;

	@Enumerated(EnumType.STRING)
	private Role role;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public User(long id, String name, String password, long phoneNumber, String emailId, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.role = role;
	}

	public User(String name, String password, long phoneNumber, String emailId, Role role) {
		super();
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.role = role;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", emailId=" + emailId + ", loggedIn=" + loggedIn + ", role=" + role + "]";
	}
}