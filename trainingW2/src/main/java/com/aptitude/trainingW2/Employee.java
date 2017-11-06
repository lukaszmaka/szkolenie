package com.aptitude.trainingW2;

import com.google.common.base.MoreObjects.ToStringHelper;

public class Employee implements Comparable<Employee>{
	private String name;
	private String city;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

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

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		return name + " " + city;
	}
}
