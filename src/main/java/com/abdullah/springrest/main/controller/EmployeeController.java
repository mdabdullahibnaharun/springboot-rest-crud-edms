package com.abdullah.springrest.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdullah.springrest.main.dto.EmployeeRequest;
import com.abdullah.springrest.main.model.Department;
import com.abdullah.springrest.main.model.Employee;
import com.abdullah.springrest.main.service.DepartmentService;
import com.abdullah.springrest.main.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	private final EmployeeService employeeService;

	@Autowired
	private final DepartmentService departmentService;

	@PostMapping("/save")
	public EmployeeRequest saveEmployee(@RequestBody EmployeeRequest request) {
		return employeeService.saveEmployee(request);
	}
	
	@GetMapping(path="/get")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@GetMapping("/get/{id}")
	public Optional<Employee> getEmployee(@PathVariable(value = "id") Long id) {
		return employeeService.findById(id);
	}
	
	@PutMapping(path="/update", produces = "Application/JSON")
	public EmployeeRequest updateEmployee(@RequestBody EmployeeRequest employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping(path="/delete/{id}")
	public void deleteEmployee(@PathVariable(value = "id") Long id) {
		employeeService.deleteEmp(id);
	}
	
}
