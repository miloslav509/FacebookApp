package com.facebook.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.facebook.dto.UserDTO;
import com.facebook.model.User;

@Component
public class USerToUSerDto implements Converter<User, UserDTO> {

	@Override
	public UserDTO convert(User user) {
		UserDTO dto = new UserDTO();
		
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		
		return dto;
	}

	
}
