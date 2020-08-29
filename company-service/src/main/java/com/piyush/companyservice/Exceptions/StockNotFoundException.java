package com.piyush.companyservice.Exceptions;

public class StockNotFoundException extends Throwable {

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

    public StockNotFoundException(String message) {
		super();
		this.message = message;
	}

	public StockNotFoundException() {
		super();
	}
    
}