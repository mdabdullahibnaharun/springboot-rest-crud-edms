package com.abdullah.springrest.main.dto;

import java.time.LocalDate;

import com.abdullah.springrest.main.enums.GenderEnum;
import com.abdullah.springrest.main.model.Department;

import lombok.Data;

@Data
public class EmployeeRequest {
	
	private Long id;
	private String code;
	private String name;
	private LocalDate dob;
	private String gender;
	private String mobile;
	private Long department;

}
