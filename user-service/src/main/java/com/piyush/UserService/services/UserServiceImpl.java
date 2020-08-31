package com.piyush.UserService.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piyush.UserService.exceptions.UserNotFoundException;
import com.piyush.UserService.model.User;
import com.piyush.UserService.repo.UserRepository;
import com.piyush.UserService.shared.Header;
import com.piyush.UserService.shared.UserAuthenticate;
import com.piyush.UserService.shared.UserRequestModel;
import com.piyush.UserService.shared.UserResponseModel;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private ModelMapper mapper;

	public UserServiceImpl(UserRepository repo, ModelMapper modelMapper) {
		this.userRepository = repo;
		this.mapper = modelMapper;
	}

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Transactional
	public void createNewUser(UserRequestModel userRequestModel) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		logger.info("userRequestModel -> {} ", userRequestModel);
		userRequestModel.setRole("user");
		userRepository.save(mapper.map(userRequestModel, User.class));
	}

	@Override
	@Transactional
	public List<UserResponseModel> getAllUsers() {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<UserResponseModel>>() {
		}.getType();
		List<UserResponseModel> list = mapper.map(userRepository.findAll(), listType);
		return list;
	}

	

	@Override
	@Transactional
	public UserResponseModel getUserByUserId(String id) throws UserNotFoundException {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user = userRepository.findUserByUserIdIgnoreCase(id);
		logger.info("User of  id {} is {}", id, user);

		if (user == null) {
			throw new UserNotFoundException("user not found with id " + id);
		}

		return mapper.map(user, UserResponseModel.class);
	}

	@Override
	public Header authenticateUser(UserAuthenticate userRequest)  {
		
		Header header = new Header();	
		User user = userRepository.findByUserIdIgnoreCaseAndPassword(userRequest.getUserId(), userRequest.getPassword());	
		if(user == null){
			header.setStatus("login-failed");
			return header;
		}else{
			header.setUserId(user.getUserId());
			header.setRole(user.getRole());
			header.setStatus("successful");
			header.setToken("");
			return header;			
		}	
	}
}
