package com.sprint1.spc.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
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
	@ExceptionHandler(ConcernNotFoundException.class)
	public ErrorMessage concernNotFound(Exception e) {
		return new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(),fieldError.getDefaultMessage())).collect(Collectors.toList());
        return fieldErrorMessages;
    }
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
    public ErrorMessage handleAllExceptions(Exception e) {
   	return new ErrorMessage(
   			HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong");
   }
}