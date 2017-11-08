package com.aptitude.trainingW2;


public class Employee implements Comparable<Employee>{
	private String name;
	private String city;
	private int salary;

	public Employee(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public <T extends Employee> T setSalary(int salary) {
		this.salary = salary;
		return (T) this;
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		return name + " " + city + " " + salary;
	}
}
