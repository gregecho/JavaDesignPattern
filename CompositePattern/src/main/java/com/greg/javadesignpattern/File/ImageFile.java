package com.greg.javadesignpattern.File;

public class ImageFile extends AbstractFile {

	public ImageFile(String name) {
		this.setName(name);
	}

	public void add(AbstractFile file) {
		System.out.println("Sorry, do not support the method");
	}

	public void remove(AbstractFile file) {
		System.out.println("Sorry, do not support the method");
	}

	public AbstractFile getChild(int i) {
		System.out.println("Sorry, do not support the method");
		return null;
	}

	public void killVirus() {
		System.out.println("----image for'" + this.getName() + "'kill");
	}
}
