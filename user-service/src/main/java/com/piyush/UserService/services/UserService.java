package com.piyush.UserService.services;


import java.util.List;

import com.piyush.UserService.exceptions.UserNotFoundException;
import com.piyush.UserService.shared.Header;
import com.piyush.UserService.shared.UserAuthenticate;
import com.piyush.UserService.shared.UserRequestModel;
import com.piyush.UserService.shared.UserResponseModel;

public interface UserService {

	public String createNewUser(UserRequestModel userRequestModel);

	public List<UserResponseModel> getAllUsers();


	public UserResponseModel getUserByUserId(String id) throws UserNotFoundException;

	public Header authenticateUser(UserAuthenticate user) ;

	public String removeUser(String userId) throws UserNotFoundException;

	public String removeAll();
}
