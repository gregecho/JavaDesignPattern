package com.greg.javadesignpattern.Product;

public class PieChart implements Chart {

	public PieChart() {
		System.out.println("Initialize pie chart...");
	}

	@Override
	public void display() {
		System.out.println("Display pie chart...");
	}

}
