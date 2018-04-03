package com.intervest.hrms.service;

import java.util.List;

import com.intervest.hrms.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee emp);

	public void updateEmployee(Employee emp);

	public List<Employee> listEmployees();

	public Employee getEmployeeByID(int id);

	public void removeEmployee(int id);
}
