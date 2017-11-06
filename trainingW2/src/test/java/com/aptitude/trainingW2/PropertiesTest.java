package com.aptitude.trainingW2;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.junit.Test;

public class PropertiesTest {
	
	@Test
	public void test_loadProperties() throws IOException {
		
		Properties props = new Properties();
		props.setProperty("setting", "1");
		props.setProperty("something", "else");
		
		FileWriter out = new FileWriter("properties");				 

		props.store(out, null);
		
		FileReader in = new FileReader("properties");
		Properties props2 = new Properties();
		props2.load(in);
		System.out.println(props2.keySet());
		
		assertEquals(props2.getProperty("setting"), "1");
	}
}
