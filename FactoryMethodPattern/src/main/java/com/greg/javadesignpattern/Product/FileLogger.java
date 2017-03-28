package com.greg.javadesignpattern.Product;

//Contrete logger
public class FileLogger implements Logger {

	@Override
	public void writeLog() {
		System.out.println("File logger");
	}


}
