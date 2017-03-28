package com.greg.javadesignpattern.Product;

public class LineChart implements Chart {

	public LineChart() {
		System.out.println("Initialize line chart...");
	}

	@Override
	public void display() {
		System.out.println("Display line chart...");
	}

}
