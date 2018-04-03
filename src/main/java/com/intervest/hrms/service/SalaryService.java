package com.intervest.hrms.service;

import java.util.List;

import com.intervest.hrms.model.VariableDeduction;
import com.intervest.hrms.model.VariablePay;

public interface SalaryService {

	public void updateSalary(int id, String new_Salary);

	public List<VariablePay> listVariablePay();

	public void addVariablePay(VariablePay variablePay);

	public VariablePay getVariablePayId(int id);

	public void updateVariablePay(VariablePay variablePay);

	public void deleteVariablePay(VariablePay variablePay);

	public List<VariableDeduction> listVariableDeduction();

	public void addVariableDeduction(VariableDeduction variableDeduction);

	public VariableDeduction getVariableDeductionId(int id);

	public void updateVariableDeduction(VariableDeduction variableDeduction);

	public void deleteVariableDeduction(VariableDeduction variableDeduction);

	public void addProcess(String empId, String type, String employee, String payment, String endingDate, String payId, String deductId);

	public List salaryDetails(String empId);


}
