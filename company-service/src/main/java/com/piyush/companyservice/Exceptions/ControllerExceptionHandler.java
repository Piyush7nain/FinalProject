package com.piyush.companyservice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleExceptions(CompanyNotFoundException NotFoundException){
		ErrorMessage userErrorMessage = new ErrorMessage(NotFoundException.getMessage(), 
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userErrorMessage);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleExceptions(IpoNotFoundException NotFoundException){
		ErrorMessage userErrorMessage = new ErrorMessage(NotFoundException.getMessage(), 
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userErrorMessage);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleExceptions(StockNotFoundException NotFoundException){
		ErrorMessage userErrorMessage = new ErrorMessage(NotFoundException.getMessage(), 
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userErrorMessage);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleExceptions(StockExchangeNotFoundException NotFoundException){
		ErrorMessage userErrorMessage = new ErrorMessage(NotFoundException.getMessage(), 
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userErrorMessage);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleExceptions(SectorNotFoundException NotFoundException){
		ErrorMessage userErrorMessage = new ErrorMessage(NotFoundException.getMessage(), 
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userErrorMessage);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleExceptions(RegistrationError NotFoundException){
		ErrorMessage userErrorMessage = new ErrorMessage(NotFoundException.getMessage(), 
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userErrorMessage);
	}

}
