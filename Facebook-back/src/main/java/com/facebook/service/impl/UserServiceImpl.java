package com.facebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.model.User;
import com.facebook.repository.UserRepository;
import com.facebook.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User findOne(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}

	
}
