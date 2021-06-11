package com.sprint1.spc.exception;

public class ParentServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	public ParentServiceException(String str)
	{
		super(str);
	}
}