package com.greg.javadesignpattern.Factory;

import com.greg.javadesignpattern.Product.Logger;

// Factory interface, base for other factory
public interface LoggerFactory {
	public Logger createLogger();  
}
