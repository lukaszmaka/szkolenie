package com.aptitude.spring2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcEmployeeRepository implements IEmployeeRepository{

	private final NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public JdbcEmployeeRepository(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}	
	
	@Override
	@Transactional
	public void save(List<Employee> list) {
		jdbc.batchUpdate("INSERT INTO employee (name, surname, city, salary) VALUES (:name, :surname, :city, :salary)", 
				list.stream()
					.map(e -> new BeanPropertySqlParameterSource(e))
					.collect(Collectors.toList())
					.toArray(new BeanPropertySqlParameterSource[list.size()]));
	}

	@Override
	public List<Employee> getAll() {		
		return jdbc.query("SELECT * FROM employee", new BeanPropertyRowMapper<Employee>(Employee.class));
	}
}
