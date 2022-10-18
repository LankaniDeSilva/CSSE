package com.employee.service;



import com.employee.model.EmployeeModel;
import com.employee.util.DBConnect;
import com.employee.util.ReadProperty;
import com.employee.util.ReadXML;
import com.employee.util.UtilTransform;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Map;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;



public class EmployeeService extends ReadProperty implements EmployeeServiceImpl {

	private final ArrayList<EmployeeModel> employeeList = new ArrayList<EmployeeModel>();

	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;

	public EmployeeService() throws SQLException {
		try {
			connection = DBConnect.getConnection();
				
		}catch (Exception e) {
		} 
	finally {
		
		try {
			
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


	@Override
	public void employeeXML() {

		try {
			int s = UtilTransform.XMLXPATHS().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> list = UtilTransform.XMLXPATHS().get(i);
				EmployeeModel employee = new EmployeeModel();
				employee.setEmployeeId(list.get("XpathEmployeeIDKey"));
				employee.setFullName(list.get("XpathEmployeeNameKey"));
				employee.setAddress(list.get("XpathEmployeeAddressKey"));
				employee.setFacultyName(list.get("XpathFacultyNameKey"));
				employee.setDepartment(list.get("XpathDepartmentKey"));
				employee.setDesignation(list.get("XpathDesignationKey"));
				employeeList.add(employee);
				System.out.println(employee.toString() + "\n");
			}
		} catch (Exception e) {
		}
	}
	@Override
	public void employeeTableCreate() {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(ReadXML.Q("q2"));
			statement.executeUpdate(ReadXML.Q("q1"));
		} catch (Exception e) {
		}finally {
			
			try {
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		}
	
	@Override
	public void employeesAdd() {
		try {
			preparedStatement = connection.prepareStatement(ReadXML.Q("q3"));
			connection.setAutoCommit(false);
			for(int i = 0; i < employeeList.size(); i++){
				EmployeeModel employeeModel = employeeList.get(i);
				preparedStatement.setString(1, employeeModel.getEmployeeId());
				preparedStatement.setString(2, employeeModel.getFullName());
				preparedStatement.setString(3, employeeModel.getAddress());
				preparedStatement.setString(4, employeeModel.getFacultyName());
				preparedStatement.setString(5, employeeModel.getDepartmentId());
				preparedStatement.setString(6, employeeModel.getDesignation());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
		} catch (Exception e) {
		}finally {
			
			try {
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
	}

	@Override
	public void employeeGetById(String eid) {

		EmployeeModel employeeModel = new EmployeeModel();
		try {
			preparedStatement = connection.prepareStatement(ReadXML.Q("q4"));
			preparedStatement.setString(1, eid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employeeModel.setEmployeeId(resultSet.getString(1));
				employeeModel.setFullName(resultSet.getString(2));
				employeeModel.setAddress(resultSet.getString(3));
				employeeModel.setFacultyName(resultSet.getString(4));
				employeeModel.setDepartment(resultSet.getString(5));
				employeeModel.setDesignation(resultSet.getString(6));
			}
			ArrayList<EmployeeModel> l = new ArrayList<EmployeeModel>();
			l.add(employeeModel);
			employeeOutput(l);
		} catch (Exception ex) {
		}finally {
			
			try {
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
	}
	@Override
	public void employeeDelete(String eid) {

		try {
			preparedStatement = connection.prepareStatement(ReadXML.Q("q6"));
			preparedStatement.setString(1, eid);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
	}
	@Override
	public void employeeDisplay() {

		ArrayList<EmployeeModel> list = new ArrayList<EmployeeModel>();
		try {
			preparedStatement = connection.prepareStatement(ReadXML.Q("q5"));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeModel employeeModel = new EmployeeModel();
				employeeModel.setEmployeeId(resultSet.getString(1));
				employeeModel.setFullName(resultSet.getString(2));
				employeeModel.setAddress(resultSet.getString(3));
				employeeModel.setFacultyName(resultSet.getString(4));
				employeeModel.setDepartment(resultSet.getString(5));
				employeeModel.setDesignation(resultSet.getString(6));
				list.add(employeeModel);
			}
		} catch (Exception e) {
		}finally {
			
			try {
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		employeeOutput(list);
	}
	@Override
	public void employeeOutput(ArrayList<EmployeeModel> list){
		
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out
				.println("================================================================================================================");
		for(int i = 0; i < list.size(); i++){
			EmployeeModel employeeModel = list.get(i);
			System.out.println(employeeModel.getEmployeeId() + "\t" + employeeModel.getFullName() + "\t\t"
					+ employeeModel.getAddress() + "\t" + employeeModel.getFacultyName() + "\t" + employeeModel.getDepartmentId() + "\t"
					+ employeeModel.getDesignation() + "\n");
			System.out
			.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
