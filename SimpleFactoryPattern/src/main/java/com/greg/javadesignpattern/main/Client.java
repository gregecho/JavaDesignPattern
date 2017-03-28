package com.greg.javadesignpattern.main;

import com.greg.javadesignpattern.Factory.ChartFacotry;
import com.greg.javadesignpattern.Product.*;
import com.greg.javadesignpattern.utils.XMLUtil;

public class Client {

	public static void main(String[] args) {
		Chart chart;
		String type = XMLUtil.getChartType();
		chart = ChartFacotry.getChart(type);
		chart.display();
	}

}
