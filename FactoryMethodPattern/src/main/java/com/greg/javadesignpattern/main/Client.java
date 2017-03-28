package com.greg.javadesignpattern.main;

import com.greg.javadesignpattern.Factory.FileLoggerFactory;
import com.greg.javadesignpattern.Factory.LoggerFactory;
import com.greg.javadesignpattern.Product.*;
import com.greg.javadesignpattern.utils.XMLUtil;


public class Client {

	public static void main(String[] args) {
		LoggerFactory factory;  
        Logger logger;  
        //factory = new FileLoggerFactory(); // we can use config file here
        factory = (LoggerFactory)XMLUtil.getBean();
        logger = factory.createLogger();  
        logger.writeLog();  
	}

}
