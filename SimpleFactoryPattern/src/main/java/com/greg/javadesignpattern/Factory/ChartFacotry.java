/**
 * Factory class, responsable for create concrete class and return object to client
 */
package com.greg.javadesignpattern.Factory;

import com.greg.javadesignpattern.Product.*;

/**
 * @author greg.li
 *
 */
public class ChartFacotry {

	public static Chart getChart(String type){
		Chart chart = null;
		if(type.equalsIgnoreCase("pie")){
			chart = new PieChart();
		}else if(type.equalsIgnoreCase("line")){
			chart = new LineChart();
		}
		return chart;
	}

}
