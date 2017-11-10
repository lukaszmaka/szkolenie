package com.aptitude.spring2;

import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring2ApplicationTests {

	@Mock
	private IEmployeeRepository mockedRepository;
	
	@InjectMocks
	private EmployeesRestController controller;
	
	@Captor
	private ArgumentCaptor<List> employeeListCaptor;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(mockedRepository.getAll()).thenReturn(Collections.emptyList());
	}
	
	@Test
	public void testVerify_listEmployees_repositoryInteractions() {
//		IEmployeeRepository mockedRepository = Mockito.mock(IEmployeeRepository.class);
//		EmployeesRestController controller = new EmployeesRestController(mockedRepository);
		
		List<Employee> results = controller.listEmployees();
		
		Mockito.verify(mockedRepository, Mockito.times(1)).getAll();
		Mockito.verifyNoMoreInteractions(mockedRepository);
	}
	
	@Test
	public void testVerify_createEmployee() {
//		Employee testEmployee = Mockito.mock(Employee.class);
		Employee testEmployee = new Employee("Jan", "Kowalski", "Wroclaw", 3000);
		controller.addEmployee(testEmployee.getName(), testEmployee.getSurname(), testEmployee.getCity(), testEmployee.getSalary());
		
		Mockito.verify(mockedRepository).save(employeeListCaptor.capture());
		
		List<Employee> captured = employeeListCaptor.getValue();
		assertThat(captured, Matchers.hasSize(1));
		assertThat(captured.get(0).getName(), Matchers.is(testEmployee.getName()));
	}

}
