package com.intervest.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.EmployeeDao;
import com.intervest.hrms.dao.SalaryDao;
import com.intervest.hrms.model.VariableDeduction;
import com.intervest.hrms.model.VariablePay;

@Service
public class SalaryServiceImpl implements SalaryService {
	private SalaryDao salaryDao;
	private EmployeeDao employeeDao;

	public SalaryDao getSsalaryDao() {
		return salaryDao;
	}

	public void setSalaryDao(SalaryDao salaryDao) {
		this.salaryDao = salaryDao;
	}
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	@Transactional
	public void updateSalary(int id, String new_Salary) {
		this.salaryDao.updateSalary(id, new_Salary);

	}
	
	@Override
	@Transactional
	public List<VariablePay> listVariablePay() {
		return this.salaryDao.listVariablePay();
	}
	
	@Override
	@Transactional
	public void addVariablePay(VariablePay variablePay) {
		this.salaryDao.addVariablePay(variablePay);

	}
	
	@Override
	@Transactional
	public VariablePay getVariablePayId(int id) {
		return this.salaryDao.getVariablePayID(id);
	}
	
	@Override
	@Transactional
	public void updateVariablePay(VariablePay variablePay) {
		this.salaryDao.updateVariablePay(variablePay);

	}
	
	@Override
	@Transactional
	public void deleteVariablePay(VariablePay variablePay) {
		this.salaryDao.deleteVariablePay(variablePay);

	}
	
	@Override
	@Transactional
	public List<VariableDeduction> listVariableDeduction() {
		return this.salaryDao.listVariableDeduction();
	}
	
	@Override
	@Transactional
	public void addVariableDeduction(VariableDeduction variableDeduction) {
		this.salaryDao.addVariableDeduction(variableDeduction);;

	}
	
	@Override
	@Transactional
	public VariableDeduction getVariableDeductionId(int id) {
		return this.salaryDao.getVariableDeductionID(id);
	}
	
	@Override
	@Transactional
	public void updateVariableDeduction(VariableDeduction variableDeduction) {
		this.salaryDao.updateVariableDeduction(variableDeduction);

	}
	
	@Override
	@Transactional
	public void deleteVariableDeduction(VariableDeduction variableDeduction) {
		this.salaryDao.deleteVariableDeduction(variableDeduction);

	}
	
	@Override
	@Transactional
	public void addProcess(String empId, String type, String employee, String payment, String endingDate, String payId, String deductId) {
		System.out.println(type);
		if (type.equals("variablepay")) {
			this.salaryDao.addProcessPay(empId, employee, payment, endingDate, payId);
		}
		else {
			this.salaryDao.addProcessDeduction(empId, employee, payment, endingDate, deductId);
		}
		

		
	}
	
	@Override
	@Transactional
	public List salaryDetails(String empId) {
		return this.salaryDao.salaryDetails(empId);
	}


}
