package com.aptitude.trainingW2;

import com.google.common.base.MoreObjects.ToStringHelper;

public class Employee implements Comparable<Employee>{
	private String name;
	
	public Employee(String name) {
		this.name = name;
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
		return name;
	}
}
