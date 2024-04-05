package com.carzoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carzoo.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
		
	public Employee findByEmail(String email);
}
