package com.aptitude.spring2;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Configuration
public class EmployeeBatch {
	
	@Bean
	public ItemReader<Employee> employeeItemReader(DataSource dataSource) {
		
		JdbcCursorItemReader<Employee> reader = new JdbcCursorItemReader<>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT * FROM employee");
		reader.setRowMapper(new BeanPropertyRowMapper<>(Employee.class));
		
		return reader;
	}
	
	@Bean
	public ItemProcessor<Employee, Employee> employeeProcesor() {
		return item -> {
			item.setSalary(item.getSalary() * 2);
			return item;
		};
	}
	
	@Bean
	@Scope("prototype")
	public ItemWriter<Employee> employeeCsvWriter() {
		FlatFileItemWriter<Employee> writer = new FlatFileItemWriter<>();
		writer.setResource(new FileSystemResource("./employees" + System.currentTimeMillis() + ".csv"));

		DelimitedLineAggregator<Employee> aggregator = new DelimitedLineAggregator<>();
		aggregator.setDelimiter(",");
		writer.setLineAggregator(aggregator);
		
		return writer;
	}
	
	@Bean
	@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)	
	public Job jdbcToCsvJob(JobBuilderFactory jobBuilder, 
							StepBuilderFactory stepBuilder, 
							DataSource dataSource, 
							JobRepository jobRepository) {
		
		Step jobStep = stepBuilder.get("step1")
			.<Employee, Employee> chunk(5)
			.reader(employeeItemReader(dataSource))
			.processor(employeeProcesor())
			.writer(employeeCsvWriter())
			.build();
		
		return jobBuilder.get("jdbcToCsv")
			.incrementer(new RunIdIncrementer())
			.repository(jobRepository)
			.start(jobStep)
			.build();
	}
}
