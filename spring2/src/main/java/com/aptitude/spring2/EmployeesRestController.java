package com.aptitude.spring2;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesRestController {
	
//	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeesRestController(IEmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> listEmployees() {
		return employeeRepository.getAll();
	}
	
	@RequestMapping(value = "/employee/create", method = RequestMethod.GET)
	public ResponseEntity addEmployee(@RequestParam("name") String name, 
							@RequestParam("surname")String surname, 
							@RequestParam("city")String city, 
							@RequestParam("salary")int salary) {
		// http://localhost:8080/employee/create?name=Test&surname=Testowy&city=Wroclaw&salary=5000
		Employee employee = new Employee();
		employee.setCity(city);
		employee.setName(name);
		employee.setSurname(surname);
		employee.setSalary(salary);
		
		employeeRepository.save(Collections.singletonList(employee));
		
//		return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
//				.header("Location", "/employees")
//				.build();
		
		return ResponseEntity.noContent().build();
	}
}
