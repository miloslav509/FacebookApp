package com.apache.team.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache.team.model.User;
import com.apache.team.repository.UserRepository;
import com.apache.team.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User findOne(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User findById(Long id) {
		
		return repository.findById(id).get();
	}

	@Override
	public User findByUsername(String username) {
		
		return repository.findByUsername(username);
	}

	
}
