/**
 * concrete Factory class, responsable for create concrete class and return object to client
 */
package com.greg.javadesignpattern.Factory;

import com.greg.javadesignpattern.Product.*;

/**
 * @author greg.li
 *
 */
public class FileLoggerFactory implements LoggerFactory {

	@Override
	public Logger createLogger() {
		Logger logger = new FileLogger();
		return logger;
	}

}
