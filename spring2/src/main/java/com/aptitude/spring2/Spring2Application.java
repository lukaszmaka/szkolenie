package com.aptitude.spring2;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring2Application implements InitializingBean{
	
	@Autowired
	private PrinterService ps;

	@Override
	public void afterPropertiesSet() throws Exception {
		ps.sayHello();		
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Spring2Application.class, args);
	}
}
