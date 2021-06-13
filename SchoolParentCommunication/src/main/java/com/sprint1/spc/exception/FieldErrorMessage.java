package com.sprint1.spc.exception;

public class FieldErrorMessage {
	private String field;
    private String message;
   
   	public String getField() {
        return field;
    }
   
    public void setField(String field) {
        this.field = field;
    }
   
    public String getMessage() {
        return message;
    }
   
    public void setMessage(String message) {
        this.message = message;
    }

	public FieldErrorMessage(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	@Override
	public String toString() {
		return "FieldErrorMessage [field=" + field + ", message=" + message + "]";
	}
 

}
