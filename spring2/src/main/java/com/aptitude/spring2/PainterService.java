package com.aptitude.spring2;

import org.springframework.stereotype.Service;

@Service
@PainterQualifier
public class PainterService implements IPrinter {

	@Override
	public void sayHello() {
		System.out.println("Painter");
		
	}

}
