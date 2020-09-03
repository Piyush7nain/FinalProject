package com.piyush.UserService.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.piyush.UserService.exceptions.UserNotFoundException;
import com.piyush.UserService.services.UserService;
import com.piyush.UserService.shared.Header;
import com.piyush.UserService.shared.UserAuthenticate;
import com.piyush.UserService.shared.UserRequestModel;
import com.piyush.UserService.shared.UserResponseModel;

@RestController
@RequestMapping("/users")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public Map<String, String> addUser(@RequestBody UserRequestModel userRequestModel) {
		userService.createNewUser(userRequestModel);
		Map<String, String> map = new HashMap<>();
		map.put("signup", "successful");		
		return map;
	}
	
	@GetMapping("/all")
	public ResponseEntity<Object> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body( userService.getAllUsers() );
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseModel> getUserByUserId(@PathVariable("userId") String id) throws UserNotFoundException{
		
		UserResponseModel user = userService.getUserByUserId(id);
		
		if(user == null) { throw new UserNotFoundException("User not Found with userId " + id );}
		return ResponseEntity.status(HttpStatus.OK).body( user);
	}

	@PostMapping("/login")
	public ResponseEntity<Header> authenticateUser(@RequestBody UserAuthenticate user){

		return ResponseEntity.status(HttpStatus.OK).body(userService.authenticateUser(user));
	}
}
