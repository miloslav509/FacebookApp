package com.apache.team.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apache.team.dto.UserDTO;
import com.apache.team.model.User;
import com.apache.team.service.impl.UserServiceImpl;
import com.apache.team.support.USerToUSerDto;


@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
   @Autowired
   private USerToUSerDto toUSerDto;
   
   @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
	   
		User retVal = service.findOne(userDTO.getUsername(), userDTO.getPassword());
		
		if (retVal != null) {
			return new ResponseEntity<>(toUSerDto.convert(retVal), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
}
