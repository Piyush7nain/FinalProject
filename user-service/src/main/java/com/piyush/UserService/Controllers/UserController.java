package com.piyush.UserService.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.UserService.exceptions.UserNotFoundException;
import com.piyush.UserService.services.UserService;
import com.piyush.UserService.shared.Header;
import com.piyush.UserService.shared.UserAuthenticate;
import com.piyush.UserService.shared.UserRequestModel;
import com.piyush.UserService.shared.UserResponseModel;

@RestController
@RequestMapping("/api")
public class UserController {
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/users/addUser")
	public ResponseEntity<UserResponseModel> addUser(@RequestBody UserRequestModel userRequestModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(userRequestModel));
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body( userService.getAllUsers() );
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserResponseModel> getAllUsers(@PathVariable("id") int id){
		return ResponseEntity.status(HttpStatus.OK).body( userService.getUserById(id));
	}
	
	@GetMapping("/users/search/{userId}")
	public ResponseEntity<UserResponseModel> getUserByUserId(@PathVariable("userId") String id) throws UserNotFoundException{
		
		UserResponseModel user = userService.getUserByUserId(id);
		
		if(user == null) { throw new UserNotFoundException("User not Found with userId " + id );}
		return ResponseEntity.status(HttpStatus.OK).body( user);
	}

	@PostMapping("/users/login")
	public ResponseEntity<Header> authenticateUser(@RequestBody UserAuthenticate user){

		return ResponseEntity.status(HttpStatus.FOUND).body(userService.authenticateUser(user));
	}
}
