package com.abdullah.springrest.main.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.abdullah.springrest.main.model.Department;

@Repository
@Component
@Scope(value = "singleton")
public interface DepartmentRepository  extends JpaRepository<Department, Long>{

//	Department getById(Department department);
}
