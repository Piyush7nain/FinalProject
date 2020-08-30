package com.piyush.UserService.services;

import java.util.List;
import java.util.UUID;

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
	public UserResponseModel createNewUser(UserRequestModel userRequestModel) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		userRequestModel.setUserId(UUID.randomUUID().toString().split("-")[0]);
		logger.info("userRequestModel -> {} ", userRequestModel);

		User user = userRepository.save(mapper.map(userRequestModel, User.class));

		logger.info("user -> {} ", user);

		UserResponseModel userResponseModel = mapper.map(user, UserResponseModel.class);
		logger.info("userResponseModel -> {} ", userResponseModel);
		return userResponseModel;

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
	public UserResponseModel getUserById(int id) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user = userRepository.findById(id).get();
		logger.info("User of  id {} is {}", id, user);
		return mapper.map(user, UserResponseModel.class);
	}

	@Override
	@Transactional
	public UserResponseModel getUserByUserId(String id) throws UserNotFoundException {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user = userRepository.findUserByUserId(id);
		logger.info("User of  id {} is {}", id, user);

		if (user == null) {
			throw new UserNotFoundException("user not found with id " + id);
		}

		return mapper.map(user, UserResponseModel.class);
	}

	@Override
	public Header authenticateUser(UserAuthenticate userRequest)  {
		
		Header header = new Header();	
		User user = userRepository.findByUserIdAndPassword(userRequest.getUserId(), userRequest.getPassword());	
		if(user == null){
			header.setStatus("Login Failed");
			return header;
		}else{
			header.setUserId(user.getUserId());
			header.setRole(user.getRole());
			header.setStatus("Successful");
			return header;			
		}	
	}
}
