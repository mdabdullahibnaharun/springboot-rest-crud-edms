package com.abdullah.springrest.main.repository;

import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.abdullah.springrest.main.model.Employee;

@Repository
@Component
@Scope(value = "singleton")
public interface EmployeRepository extends JpaRepository<Employee, Long> {

	@Override
	Optional<Employee> findById(Long id);
	
}
