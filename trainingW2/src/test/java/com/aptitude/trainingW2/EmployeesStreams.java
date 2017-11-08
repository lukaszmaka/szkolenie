package com.aptitude.trainingW2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

public class EmployeesStreams {

//	@Test
//	public void minMaxSalary() {
//		List<Employee> list = TestData.exampleCompany();
//		
//		list.stream()
//			.map(e -> e.getSalary())
//			.min((x, y) -> Integer.compare(x, y))
//			.ifPresent(e -> System.out.println("min salary: " + e));
//		
//		list.stream()
//			.map(e -> e.getSalary())
//			.max((x, y) -> Integer.compare(x, y))
//			.ifPresent(e -> System.out.println("max salary: " + e));
//		
//	}
//	
//	@Test
//	public void howManyNotFromWroclaw() {
//		List<Employee> list = TestData.exampleCompany();
//		
//		System.out.println("Not from Wroclaw: " + (list.stream()
//															.map(e -> e.getCity())
//															.filter(e -> !e.equals("Wroclaw"))
//															.count())
//				);
//	}
//	
//	@Test
//	public void notManagers() {
//		List<Employee> list = TestData.exampleCompany();
//		
//		list.stream()
//			.filter(e -> !(e instanceof Manager))
//			.forEach(e -> System.out.println(e));			
//	}
//	
//	@Test
//	public void earnLeast() {
//		List<Employee> list = TestData.exampleCompany();
//		
////		list.stream()
////			.min(Comparator.comparing(Employee::getSalary));
//		
//		list.stream()
//			.collect(Collectors.groupingBy(Employee::getSalary))
//			.entrySet()
//			.stream()
//				.min((x,y) -> Integer.compare(x.getKey(), y.getKey()))
//				.ifPresent(e -> System.out.println(e.getValue()));
//		
//		list.stream()
//		.collect(Collectors.groupingBy(Employee::getSalary))
//		.entrySet()
//		.stream()
//			.min(Comparator.comparing(Map.Entry::getKey))
//			.map(Map.Entry::getValue)
//			.ifPresent(System.out::println);
//		
//		Optional.ofNullable(TestData.exampleCompany().stream()
//			.collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList()))
//			.firstEntry())
//			.map(Map.Entry::getValue)
//			.ifPresent(System.out::println);
//			
//	}
	
//	@Test
//	public void doubleGrouping() {
//		List<Employee> list = TestData.exampleCompany();
//		
//		list.stream()
//			.collect(Collectors.groupingBy(Employee::getCity, Collectors.partitioningBy(e -> e instanceof Manager)))
//			.entrySet().forEach(System.out::println);
//	}
	
//	@Test
//	public void concat() {
//		
//		System.out.println(Stream.of("A", "B", "C", "D").collect(Collectors.joining(", ")));
//		
//		System.out.println(Stream.of("A", "B", "C", "D").reduce((a, b) -> a + ", " + b));
//	}
	
//	@Test
//	public void fiveGreatest() {
//		List<Employee> list = TestData.exampleCompany();
//		
//		list.stream()
//			.filter(e -> !(e instanceof CEO))
////			.peek(e -> System.out.println("Before sorted: " + e))
//			.sorted(Comparator.comparing(Employee::getSalary).reversed())
////			.peek(e -> System.out.println("Before limit: " + e))
//			.limit(5)
////			.peek(e -> System.out.println("After limit: " + e))
//			.forEach(System.out::println);
//	}
//	
//	@Test
//	public void statistics() {
//		List<Employee> list = TestData.exampleCompany();
//		
//		System.out.println(list.stream().collect(Collectors.summarizingInt(Employee::getSalary)).toString());
//		
//		list.stream()
//			.collect(Collectors.groupingBy(e -> e.getClass().getSimpleName(), Collectors.summarizingInt(Employee::getSalary)));
//		
//		System.out.println(
//				list.stream().collect(Collectors.groupingBy(e -> e.getClass().getSimpleName(), Collectors.summarizingInt(Employee::getSalary))));
//				
//
//	}
	
	@Test
	public void parallel() {
		IntStream.range(0, 10000)
			.parallel()
			.filter(e -> e % 6 == 0)
			.peek(e -> System.out.println(Thread.currentThread().getName()))
			.forEach(e -> System.out.println(e));
		
		
	}
}



