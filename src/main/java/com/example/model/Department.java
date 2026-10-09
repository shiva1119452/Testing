package com.example.model;

import java.util.List;
import lombok.Data;

@Data
public class Department {

	private Long id;
	private String name;
	private List<Employee> employees;
}
