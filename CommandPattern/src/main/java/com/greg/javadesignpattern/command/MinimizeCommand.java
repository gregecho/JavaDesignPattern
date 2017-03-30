package com.greg.javadesignpattern.command;

import com.greg.javadesignpattern.receiver.WindowHanlder;

public class MinimizeCommand extends Command {
	 private WindowHanlder whObj; 
     
	    public MinimizeCommand() {  
	        whObj = new WindowHanlder();  
	    }  
	      
	    public void execute() {  
	        whObj.minimize();  
	    }  
}
