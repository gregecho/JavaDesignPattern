package com.greg.javadesignpattern.main;

import com.greg.javadesignpattern.Factory.SkinFactory;
import com.greg.javadesignpattern.Product.*;
import com.greg.javadesignpattern.utils.XMLUtil;


public class Client {

	public static void main(String[] args) {
		SkinFactory factory;  
        Button bt;  
        TextBox tf;   
        factory = (SkinFactory)XMLUtil.getBean();  
        bt = factory.createButton();  
        tf = factory.createTextBox();   
        bt.display();  
        tf.display();   
	}

}
