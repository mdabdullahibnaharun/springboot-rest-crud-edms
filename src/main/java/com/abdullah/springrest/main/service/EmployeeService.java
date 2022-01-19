package com.abdullah.springrest.main.service;

import java.util.List;
import java.util.Optional;

import com.abdullah.springrest.main.dto.EmployeeRequest;
import com.abdullah.springrest.main.model.Employee;

public interface EmployeeService {
	
	EmployeeRequest saveEmployee(EmployeeRequest request);

	EmployeeRequest updateEmployee(EmployeeRequest request);

//	Employee updateEmployee(Employee request);

	Optional<Employee> findById(Long id);

	List<Employee> getAllEmployees();

	void deleteEmp(Long id);
}
