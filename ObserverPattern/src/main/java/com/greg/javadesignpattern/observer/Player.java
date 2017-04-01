package com.greg.javadesignpattern.observer;

import com.greg.javadesignpattern.subject.AllyControlCenter;

public class Player implements Observer {

	private String name;  
	  
    public Player(String name) {  
        this.name = name;  
    }  
      
    public void setName(String name) {  
        this.name = name;  
    }  
      
    public String getName() {  
        return this.name;  
    }  

    public void help() {  
        System.out.println("Hold on," + this.name + "coming to help you");  
    }  

    public void beAttacked(AllyControlCenter acc) {  
        System.out.println(this.name + "be attacked!");  
        acc.notifyObserver(name);         
    }  

}
