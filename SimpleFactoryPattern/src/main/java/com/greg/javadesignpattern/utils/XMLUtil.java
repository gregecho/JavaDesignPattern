package com.greg.javadesignpattern.utils;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

import org.w3c.dom.NodeList;

public class XMLUtil {

	public static String getChartType() {
		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			String fileName = "config.xml";
			ClassLoader classLoader = new XMLUtil().getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			doc = builder.parse(file);
			NodeList nl = doc.getElementsByTagName("chartType");
			Node classNode = nl.item(0).getFirstChild();
			String chartType = classNode.getNodeValue().trim();
			return chartType;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
