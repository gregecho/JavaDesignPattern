package com.greg.javadesignpattern.observer;

import com.greg.javadesignpattern.subject.AllyControlCenter;

public interface Observer {
	public String getName();

	public void setName(String name);

	public void help();

	public void beAttacked(AllyControlCenter acc);
}
