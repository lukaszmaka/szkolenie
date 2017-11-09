package com.aptitude.spring2;

import java.util.List;

public interface IEmployeeRepository {
		
	void save(List<Employee> list);
	List<Employee> getAll();
}
