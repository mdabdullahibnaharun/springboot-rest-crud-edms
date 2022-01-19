package com.abdullah.springrest.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abdullah.springrest.main.model.Department;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long>{

//	Department getById(Department department);
}
