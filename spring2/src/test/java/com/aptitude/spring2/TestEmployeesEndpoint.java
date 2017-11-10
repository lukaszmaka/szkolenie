package com.aptitude.spring2;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.RequestResultMatchers;

import com.jayway.jsonpath.JsonPath;

import static org.mockito.Mockito.when;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TestEmployeesEndpoint {
	@Autowired
	private MockMvc mvc;
	
//	@MockBean
//	private IEmployeeRepository mockedRepository;
	
	@Test
	public void test() throws Exception {
//		when(mockedRepository.getAll()).thenReturn(Collections.singletonList(new Employee("Jan", "Kowalski", "Wroclaw", 2000)));
		mvc.perform(MockMvcRequestBuilders.get("/employees"))
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
	}
}
