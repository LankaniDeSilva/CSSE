package com.employee.main;

import com.employee.util.UtilTransform;
import com.employee.service.*;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;



public class EmployeeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		try {
			EmployeeService employeeService = new EmployeeService();
			UtilTransform.rEQUESTtRANSFORM();
			employeeService.employeeXML();
			employeeService.employeeTableCreate();
			employeeService.employeesAdd();
//			employeeService.eMPLOYEEGETBYID("EMP10004");
//			employeeService.EMPLOYEEDELETE("EMP10001");
			employeeService.employeeDisplay();
		}catch(TransformerConfigurationException e) {
			
		}catch(TransformerFactoryConfigurationError e) {
			
		}catch(TransformerException e) {
			
		}catch (Exception e) {
		}

	}

}
