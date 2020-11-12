package com.example.hibernatecrud.entities;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="employee")
public class Employee {
	@Id
	private Long id;
	private String name;
}
