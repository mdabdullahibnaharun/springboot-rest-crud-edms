package com.abdullah.springrest.main.service;

import java.util.List;
import java.util.Optional;

import com.abdullah.springrest.main.dto.DepartmentRequest;
import com.abdullah.springrest.main.model.Department;

public interface DepartmentService {

	DepartmentRequest saveDepartment(DepartmentRequest request);
	
//	DepartmentRequest updateDepartment(DepartmentRequest request);
	
	Department updateDepartment(Department request);
	
	Optional<Department> getDepartmentById(Long id);
	
	List<Department> getAllDepartment();
	
	void deleteDept(Long id);
}
