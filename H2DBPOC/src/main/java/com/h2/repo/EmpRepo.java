package com.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
