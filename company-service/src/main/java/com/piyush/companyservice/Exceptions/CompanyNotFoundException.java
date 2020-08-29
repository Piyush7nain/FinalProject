package com.piyush.companyservice.Exceptions;

public class CompanyNotFoundException extends Throwable {

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

    public CompanyNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CompanyNotFoundException() {
		super();
	}
    
}