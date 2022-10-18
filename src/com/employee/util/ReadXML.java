package com.employee.util;

import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;

import org.xml.sax.SAXException;

import com.employee.common.CommonConstants;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import javax.xml.transform.TransformerConfigurationException;

public class ReadXML extends ReadProperty {
	private static final String REQUEST_FILE_PATH="src/com/employee/config/EmployeeQuery.xml";
	private static final String REQUEST="query";
	private static final String ID="id";
	
	public static String Q(String id) throws Exception {
		NodeList nodeList; Element element = null;
	try {	nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(REQUEST_FILE_PATH))
				.getElementsByTagName(REQUEST);
		for (int x = 0; x < nodeList.getLength(); x++) {
			element = (Element) nodeList.item(x);
			if (element.getAttribute(ID).equals(id))
				break;
		}}catch( SAXException e){
			
		}
	catch(FileNotFoundException e ) {}
		return element.getTextContent().trim();
	}
}
