package com.sprint1.spc.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {

	public UserNotFoundException(String str)
	{
		super(str);
	}
}