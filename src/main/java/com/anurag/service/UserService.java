package com.anurag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.entities.User;
import com.anurag.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	IUserRepository userRepo;

	public User saveUser(User user) {
		User saveUser = userRepo.save(user);
		return saveUser;
	}
}
