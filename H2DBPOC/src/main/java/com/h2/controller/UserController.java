package com.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.User;
import com.h2.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addUser(@RequestBody User user){
		return service.saveUser(user).getName();
	}
}
