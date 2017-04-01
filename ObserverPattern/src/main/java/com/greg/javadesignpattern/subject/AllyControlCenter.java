package com.greg.javadesignpattern.subject;

import java.util.ArrayList;

import com.greg.javadesignpattern.observer.Observer;

public abstract class AllyControlCenter {

	 protected String allyName; 
	    protected ArrayList<Observer> players = new ArrayList<Observer>();
	      
	    public void setAllyName(String allyName) {  
	        this.allyName = allyName;  
	    }  
	      
	    public String getAllyName() {  
	        return this.allyName;  
	    }  
	      
	    public void join(Observer obs) {  
	        System.out.println(obs.getName() + "Join" + this.allyName + "ally!");  
	        players.add(obs);  
	    }  

	    public void quit(Observer obs) {  
	        System.out.println(obs.getName() + "Quit" + this.allyName + "ally!");  
	        players.remove(obs);  
	    }  
	      
 
	    public abstract void notifyObserver(String name);  
}
