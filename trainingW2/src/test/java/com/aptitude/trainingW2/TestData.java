package com.aptitude.trainingW2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestData {

	public static List<Employee> exampleCompany() {
		CEO ceo = new CEO("Jan Nowak","Wroclaw").setSalary(30000);		
		
		Director d1 = new Director("Zbigniew Kowalski", "Wroclaw").setSalary(21000);
		Director d2 = new Director("Aleksander Kaczor", "Wroclaw").setSalary(19000);
		
		ceo.setEmployees(Arrays.asList(d1, d2));
		
		Manager m11 = new Manager("Janusz Janusz", "Wroclaw").setSalary(9000);
		Manager m12 = new Manager("Jakub Jakub", "Warszawa").setSalary(8000);
		Manager m21 = new Manager("Janusz Jakub", "Krakow").setSalary(9500);
		Manager m22 = new Manager("Jakub Janusz", "Poznan").setSalary(8500);
		
		d1.setEmployees(Arrays.asList(m11, m12));
		d2.setEmployees(Arrays.asList(m21, m22));
		
		Employee e1 = new Employee("Janusz Kowalski", "Wroclaw").setSalary(5000);
		Employee e2 = new Employee("Jakub Kowalski", "Warszawa").setSalary(5000);
		Employee e3 = new Employee("Aleksander Kowalski", "Krakow").setSalary(6000);
		Employee e4 = new Employee("Janusz Kaczor", "Poznan").setSalary(5000);
		
		m11.setEmployees(Collections.singletonList(e1));
		m12.setEmployees(Collections.singletonList(e2));
		m21.setEmployees(Collections.singletonList(e3));
		m22.setEmployees(Collections.singletonList(e4));
		
		return Arrays.asList(ceo, d1, d2, m11, m12, m21, m22, e1, e2, e3, e4);
	}
}