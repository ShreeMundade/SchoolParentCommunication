package com.sprint1.spc.exception;

public class TeacherNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public TeacherNotFoundException(String str) {
		super(str);
	}
	public TeacherNotFoundException() {
	}
}