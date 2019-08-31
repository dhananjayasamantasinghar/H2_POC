package com.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.Employee;
import com.h2.repo.EmpRepo;

@RestController
@RequestMapping("/hrService")
public class HRController {

	@Autowired
	private EmpRepo empRepo;
	
	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> saveInHrDb(@RequestBody Employee emp){
		Employee emp1 = empRepo.save(emp);
		return new ResponseEntity<>(
				emp1.getName()+" Saved in HR database!!"
				,HttpStatus.OK);
	}
	
}
