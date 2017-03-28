package com.greg.javadesignpattern.Product;

// Contrete logger
public class DatabaseLogger implements Logger {

	@Override
	public void writeLog() {
		System.out.println("Database logger");
	}

}
