package com.aptitude.trainingW2;

import java.util.List;

public class Manager extends Employee {
	
	private List<Employee> employees;
	
	public Manager(String name, String city) {
		super(name, city);
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
