package com.apache.team.service;

import com.apache.team.model.User;

public interface UserService {

	public User findOne(String username, String password);
	public User findById(Long id);
}
