package com.abdullah.springrest.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdullah.springrest.main.model.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Long>{

}
