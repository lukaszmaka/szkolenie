package com.aptitude.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrinterService {
	
	private String greeting;
	
	public PrinterService() {
		this("Hello");
	}
	
	@Autowired
	public PrinterService(PainterService painter) {
		this("PainterConstructor");
		System.out.println("Painter " + painter);
	}
	
	public PrinterService(String greeting) {
		this.greeting = greeting;
	}
	
	public void sayHello() {
		System.out.println(greeting);
	}
}
