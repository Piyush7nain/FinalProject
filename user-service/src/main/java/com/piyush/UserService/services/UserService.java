package com.piyush.UserService.services;

import com.piyush.UserService.exceptions.UserNotFoundException;
import com.piyush.UserService.shared.UserRequestModel;
import com.piyush.UserService.shared.UserResponseModel;

public interface UserService {

	public UserResponseModel createNewUser(UserRequestModel userRequestModel);

	public Object getAllUsers();

	public UserResponseModel getUserById(int id);

	public UserResponseModel getUserByUserId(String id) throws UserNotFoundException;
}
