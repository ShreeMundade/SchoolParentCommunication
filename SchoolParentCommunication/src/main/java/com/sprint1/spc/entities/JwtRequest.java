package com.sprint1.spc.entities;

public class JwtRequest {
	
	private  String emailId;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public JwtRequest(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
