package com.employee.model;

public class EmployeeModel {

	public String idEmployee;
	public String nameFull;
	public String address;
	public String facultyName;
	public String department;
	public String designation;
	public String getEmployeeId() {
		return idEmployee;
	}
	public void setEmployeeId(String employeeID) {
		this.idEmployee = employeeID;
	}
	public String getFullName() {
		return nameFull;
	}
	public void setFullName(String fullName) {
		this.nameFull = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getDepartmentId() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		
		return "Employee ID = " + idEmployee + "\n" + "FullName = " + nameFull + "\n" + "Address = " + address + "\n"
				+ "Faculty Name = " + facultyName + "\n" + "Department = " + department + "\n" + "Designation = "
				+ designation;
	}
}
