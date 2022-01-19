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

import com.abdullah.springrest.main.dto.DepartmentRequest;
import com.abdullah.springrest.main.model.Department;
import com.abdullah.springrest.main.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("dept")
public class DepartmentController {
	
	@Autowired
	private final DepartmentService departmentService;
	
	@PostMapping("/save")
	public DepartmentRequest saveDepartment(@RequestBody DepartmentRequest request) {
		return departmentService.saveDepartment(request);
	}
	
	@GetMapping(path="/get")
	List<Department> getAllDepartment(){
		return departmentService.getAllDepartment();
	}
	
	@GetMapping(path="/get/{id}")
	Optional<Department> getDepartment(@PathVariable(value = "id") Long id){
		return departmentService.getDepartmentById(id);
	}
	
	@PutMapping(path="/update", produces = "Application/JSON")
	public Department updateDepartment(@RequestBody Department request) {
		return departmentService.updateDepartment(request);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void deleteDepartment(@PathVariable(value = "id") Long id) {
		departmentService.deleteDept(id);
	}

}
