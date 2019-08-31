package com.h2.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class AuthController {
	
	@GetMapping(value="/getAuthToken")
	public ResponseEntity<String> getAuthToken(){
		return new ResponseEntity<>(String.valueOf(UUID.randomUUID()),HttpStatus.OK);
	}
	
}
