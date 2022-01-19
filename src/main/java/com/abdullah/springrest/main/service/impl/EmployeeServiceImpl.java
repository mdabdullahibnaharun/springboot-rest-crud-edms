package com.abdullah.springrest.main.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdullah.springrest.main.dto.EmployeeRequest;
import com.abdullah.springrest.main.enums.GenderEnum;
import com.abdullah.springrest.main.model.Department;
import com.abdullah.springrest.main.model.Employee;
import com.abdullah.springrest.main.repository.DepartmentRepository;
import com.abdullah.springrest.main.repository.EmployeRepository;
import com.abdullah.springrest.main.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private final EmployeRepository employeRepository;
	
	@Autowired
	private final DepartmentRepository departmentRepository;
	
	@Override
	public EmployeeRequest saveEmployee(EmployeeRequest request) {
		
		Employee employee = new Employee();
		BeanUtils.copyProperties(request, employee);
		
		if(request.getGender().equals("Male")) {
			employee.setGender(GenderEnum.MALE);
		}
		else if(request.getGender().equals("Female")) {
			employee.setGender(GenderEnum.FEMALE);
		}
		else {
			employee.setGender(GenderEnum.OTHERS);
		}
		
		employee.setDepartment(departmentRepository.getById(request.getDepartment()));
		Employee emp = employeRepository.save(employee);
		System.out.println(emp);
		return request;
	}

	@Override
	public EmployeeRequest updateEmployee(EmployeeRequest request) {
		
		Employee employee = new Employee();
		Optional<Employee> employees = employeRepository.findById(request.getId());
		employee = employees.get();
		BeanUtils.copyProperties(request, employee);
		
		if(request.getGender().equals("Male")) {
			employee.setGender(GenderEnum.MALE);
		}
		else if(request.getGender().equals("Female")) {
			employee.setGender(GenderEnum.FEMALE);
		}
		else {
			employee.setGender(GenderEnum.OTHERS);
		}
		
		employee.setDepartment(departmentRepository.getById(request.getDepartment()));
		Employee emp = employeRepository.save(employee);
		System.out.println(emp);
		return request;
	}

	@Override
	public Optional<Employee> findById(Long id) {
		Optional<Employee> employee = employeRepository.findById(id);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		allEmployees = employeRepository.findAll();
		return allEmployees;
	}

	@Override
	public void deleteEmp(Long id) {
		Optional<Employee> getEmp = employeRepository.findById(id);
		Employee employee = getEmp.get();
		employeRepository.delete(employee);
		
	}

}
