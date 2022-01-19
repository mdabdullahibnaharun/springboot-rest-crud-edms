package com.abdullah.springrest.main.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.abdullah.springrest.main.enums.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(EntityListeners.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 4)
	private String code;
	
//	@NotNull
	@Column(nullable = false, length = 25)
	private String name;
	
	private LocalDate dob;
	
	private GenderEnum gender;
	
	private String mobile;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

}
