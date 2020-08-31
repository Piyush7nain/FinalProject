package com.piyush.UserService.services;


import com.piyush.UserService.exceptions.UserNotFoundException;
import com.piyush.UserService.shared.Header;
import com.piyush.UserService.shared.UserAuthenticate;
import com.piyush.UserService.shared.UserRequestModel;
import com.piyush.UserService.shared.UserResponseModel;

public interface UserService {

	public void createNewUser(UserRequestModel userRequestModel);

	public Object getAllUsers();


	public UserResponseModel getUserByUserId(String id) throws UserNotFoundException;

	public Header authenticateUser(UserAuthenticate user) ;
}
