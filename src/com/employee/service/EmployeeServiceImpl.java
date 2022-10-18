package com.employee.service;

import java.util.ArrayList;

import com.employee.model.EmployeeModel;

public interface EmployeeServiceImpl {
	public void employeeXML();
	public void employeeTableCreate();
	public void employeesAdd();
	public void employeeGetById(String eid);
	public void employeeDelete(String eid);
	public void employeeDisplay();
	public void employeeOutput(ArrayList<EmployeeModel> l);
}
