package com.aptitude.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrinterService implements IPrinter {
	
	private String greeting;
	
	public PrinterService() {
		this("Printer");
	}
	
	@Autowired
	public PrinterService(PainterService painter) {
		this("PrinterConstructor");
		System.out.println("Printer " + painter);
	}
	
	public PrinterService(String greeting) {
		this.greeting = greeting;
	}
	
	public void sayHello() {
		System.out.println(greeting);
	}
}
