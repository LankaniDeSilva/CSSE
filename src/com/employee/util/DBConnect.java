package com.employee.util;

import java.util.Properties;
import java.beans.PropertyChangeEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.MessageFormat;
import com.employee.util.ReadProperty;


public class DBConnect {
//	static Properties properties = new Properties();
	
	static ReadProperty property;
	
	

	private static String url = property.getProperty("url");
	private static String userName = property.getProperty("username");
	private static String password = property.getProperty("password");
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName(property.getProperty("driverName"));
			
			con = DriverManager.getConnection(url,userName,password);
			
		}catch(Exception e) {
			
			System.out.println("Database connection is not success!! " + e);
			
		}
		return con;
		
	}

}
