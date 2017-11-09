package com.aptitude.spring2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Spring2Application implements InitializingBean{
//	
//	@Autowired
//	@PainterQualifier
//	private IPrinter ps;
//	
//	@Value("${aptitude.environment}")
//	private String environment;
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("Environment: " + environment);
//		ps.sayHello();		
//	}
	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Jan", "Kowalski", "Wroclaw", 3000));
		list.add(new Employee("Andrzej", "Nowak", "Wroclaw", 3500));
		list.add(new Employee("Pawel", "Polak", "Wroclaw", 2500));
		
		employeeRepository.save(list);
		
		List<Employee> list2 = new ArrayList<>();
		list2 = employeeRepository.getAll();
		
		System.out.println(list2);
		System.out.println(System.getProperty("user.dir"));
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(Spring2Application.class, args);
	}
}
