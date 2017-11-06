package com.aptitude.trainingW2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.junit.Test;

public class Lambdas {
	
//	public void test() {
//		Collections.sort(Collections.<String>emptyList(), Comparator<String>);
//	}
	
//	@Test
//	public void test1() {
//		Collections.sort(Collections.<String>emptyList(), (o1, o2) -> 0);
//	}
//	
//	@Test
//	public void test2() {
//		Collections.sort(Collections.<String>emptyList(), this::fnCompare);
//	}
//	
//	@Test
//	public int fnCompare(String s1, String s2) {
//		return 0;
//	}
	
	@Test
	public void _forEach() {
		IntStream.range(0, 100)
			.filter(e -> e % 2 == 0)
			.mapToObj(e -> "E" + e);
	}
	
	@Test
	public void forEach() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Jan Kowalski", "Wroclaw"));
		employees.add(new Employee("Grazyna Nowak", "Warszawa"));
		employees.add(new Employee("Janusz Bak", "Gdansk"));
		employees.add(new Employee("Arkadiusz Marks", "Wroclaw"));
		employees.add(new Employee("Jan Nowak", "Wroclaw"));
		
		
		
		employees.stream()
			.filter(e -> e.getCity().equals("Wroclaw"))
			.forEach(e -> System.out.println(e));
		
		System.out.println();
		
		employees.stream()
			.map(e -> e.getCity())
			.distinct()
			.forEach(e -> System.out.println(e));
		
		System.out.println();
		
		employees.stream()
			.map(e -> e.getName().split(" ")[0])
			.filter(e -> e.endsWith("a"))
			.distinct()
			.forEach(System.out::println);
		
	}
}
