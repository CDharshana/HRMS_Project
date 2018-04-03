package com.intervest.hrms.dao;

import java.util.List;

import com.intervest.hrms.model.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee emp);

	public void updateEmployee(Employee emp);

	public List<Employee> listEmployees();

	public Employee getEmployeeByID(int id);

	public void removeEmployee(int id);
}
