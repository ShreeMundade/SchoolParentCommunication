package com.sprint1.spc.exception;

@SuppressWarnings("serial")
public class EmailAlreadyExistsException extends Exception{

	public EmailAlreadyExistsException(String str)
	{
		super(str);
	}
}
