package com.sprint1.spc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorMessage userNameNotFound(Exception e) {
    	return new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
    }	

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ErrorMessage emailAlreadyExists(Exception e) {
		return new ErrorMessage(HttpStatus.CONFLICT,e.getMessage());
	}
	
	@ExceptionHandler(FeeServiceException.class)
    public ErrorMessage feeNotFound(Exception e) {
		return new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
	}
	
	@ExceptionHandler(StudentIDNotFoundException.class)
    public ErrorMessage studentNotFound(Exception e) {
		return new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
	}
	
	@ExceptionHandler(ParentServiceException.class)
	public ErrorMessage parentNotFound(Exception e) {
		return new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
	}
	
	@ExceptionHandler(TeacherNotFoundException.class)
	public ErrorMessage teacherNotFound(Exception e) {
		return new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
	}
}