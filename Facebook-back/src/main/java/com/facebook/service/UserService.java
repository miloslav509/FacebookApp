package com.facebook.service;

import com.facebook.model.User;

public interface UserService {

	public User findOne(String username, String password);
	public User findById(Long id);
}
