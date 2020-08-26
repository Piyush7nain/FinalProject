package com.piyush.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<UserErrorMessage> handleExceptions(UserNotFoundException userNotFoundException){
		UserErrorMessage userErrorMessage = new UserErrorMessage(userNotFoundException.getMessage(), 
				HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userErrorMessage);
	}

}
