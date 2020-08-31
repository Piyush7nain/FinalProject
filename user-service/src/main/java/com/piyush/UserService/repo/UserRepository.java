package com.piyush.UserService.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piyush.UserService.model.User;

@Repository 
public interface UserRepository extends JpaRepository<User,Integer> {
	public User findUserByUserIdIgnoreCase(String userId);

	public User findByUserIdIgnoreCaseAndPassword(String userId, String password);
}
