package com.greg.javadesignpattern.subject;

import com.greg.javadesignpattern.observer.Observer;

public class ConcreteAllyControlCenter extends AllyControlCenter {

	public ConcreteAllyControlCenter(String allyName) {
		System.out.println(allyName + "ally created successfully!");
		System.out.println("----------------------------");
		this.allyName = allyName;
	}

	public void notifyObserver(String name) {
		System.out.println(this.allyName + "allen" + name + "are attacked!");
		for (Object obs : players) {
			if (!((Observer) obs).getName().equalsIgnoreCase(name)) {
				((Observer) obs).help();
			}
		}
	}
}
