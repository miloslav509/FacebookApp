package com.facebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.facebook.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
}
