package com.abdullah.springrest.main.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.abdullah.springrest.main.dto.DepartmentRequest;
import com.abdullah.springrest.main.model.Department;
import com.abdullah.springrest.main.repository.DepartmentRepository;
import com.abdullah.springrest.main.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Component
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private final DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartment() {
		List<Department> allDepartments = new ArrayList<>();
		allDepartments = departmentRepository.findAll();
		return allDepartments;
	}

	@Override
	public DepartmentRequest saveDepartment(DepartmentRequest request) {
		Department department = new Department();
		department.setName(request.getName());
		department.setActive(request.isActive());
		departmentRepository.save(department);
		return request;
	}

	@Override
	public Department updateDepartment(Department request) {
//		Department department = new Department();
//		department.setId(request.getId());
//		department.setName(request.getName());
//		department.setActive(request.isActive());
//		return departmentRepository.save(department);
		return departmentRepository.save(request);
	}

	@Override
	public Optional<Department> getDepartmentById(Long id) {
		return departmentRepository.findById(id);
	}

	@Override
	public void deleteDept(Long id) {
		Optional<Department> getDept = departmentRepository.findById(id);
		Department department = getDept.get();
		departmentRepository.delete(department);
	}


}
