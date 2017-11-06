package com.aptitude.trainingW2;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class PrinterTest {
	
	@Test
	public void testPrinter() {
		String test1 = "test";
		Integer test2 = 1;
		Boolean test3 = true;		
		ArrayList<String> test4 = new ArrayList<String>(Arrays.asList("a", "b", "c"));	
		
		Printer.print(test1);
		Printer.print(test2);
		Printer.print(test3);
		Printer.print(test4);
	}
	
//	@Test
//	public static <T extends Manager> void testExtends(List<T> managers) {
//		Manager m = managers.get(0);
//		managers.add(new Manager());
//		managers.add(new Director());
//	}
	
//	@Test
//	public static <T super Manager> void testSuper(List<T> managers) {
//		Manager m = managers.get(0);
//		managers.add(new Manager());
//		CEO ceo = managers.get(0);
//	}
	
//	@Test
//	public static void testSuperWildcard(List<? super Manager> managers) {
////		Manager m = managers.get(0);
////		managers.add(new Employee());
//		managers.add(new Manager());
//		managers.add(new Director());
//		managers.add(new CEO());
//		
//	}
//	
//	@Test
//	public static void testExtendsWildcard(List<? extends Manager> managers) {
//		Manager m = managers.get(0);
////		managers.add(new Employee());
////		managers.add(new Manager());
////		managers.add(new Director());
////		managers.add(new CEO());
//	}
	
	@Test
	public void treeSetTest() {
		Set<Employee> employees = new TreeSet<Employee>();

		employees.add(new Employee("E"));
		employees.add(new Manager("M"));
		employees.add(new Director("D"));
		employees.add(new CEO("C"));
		
		System.out.println(employees);

	}
	

}
