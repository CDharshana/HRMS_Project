package com.intervest.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.EmployeeDao;
import com.intervest.hrms.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public void addEmployee(Employee emp) {
		this.employeeDao.addEmployee(emp);

	}

	@Override
	@Transactional
	public void updateEmployee(Employee emp) {
		this.employeeDao.updateEmployee(emp);

	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return this.employeeDao.listEmployees();

	}

	@Override
	@Transactional
	public Employee getEmployeeByID(int id) {
		return this.employeeDao.getEmployeeByID(id);
	}

	@Override
	@Transactional
	public void removeEmployee(int id) {
		this.employeeDao.removeEmployee(id);

	}

}
