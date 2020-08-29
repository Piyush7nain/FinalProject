package com.piyush.companyservice.Exceptions;

public class RegistrationError extends Throwable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RegistrationError(String message) {
		super();
		this.message = message;
	}

	public RegistrationError() {
		super();
	}
    
}