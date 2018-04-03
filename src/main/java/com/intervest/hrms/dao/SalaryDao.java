package com.intervest.hrms.dao;

import java.util.List;

import com.intervest.hrms.model.VariableDeduction;
import com.intervest.hrms.model.VariablePay;

public interface SalaryDao {

	public void updateSalary(int id, String new_Salary);

	public List<VariablePay> listVariablePay();

	public void addVariablePay(VariablePay variablepay);

	public VariablePay getVariablePayID(int id);

	public void updateVariablePay(VariablePay variablepay);

	public void deleteVariablePay(VariablePay variablepay);

	public List<VariableDeduction> listVariableDeduction();

	public void addVariableDeduction(VariableDeduction variableDeduction);

	public VariableDeduction getVariableDeductionID(int id);

	public void updateVariableDeduction(VariableDeduction variableDeduction);

	public void deleteVariableDeduction(VariableDeduction variableDeduction);

	public void addProcessDeduction(String empId, String employee, String payment, String endingDate, String deductionId);

	public void addProcessPay(String empId, String employee, String payment, String endingDate, String payId);

	public List salaryDetails(String empId);

}
