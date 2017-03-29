package com.greg.javadesignpattern.File;

public abstract class AbstractFile implements File {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
