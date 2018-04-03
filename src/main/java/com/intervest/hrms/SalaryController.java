package com.intervest.hrms;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.intervest.hrms.model.VariableDeduction;
import com.intervest.hrms.model.VariablePay;
import com.intervest.hrms.service.EmployeeService;
import com.intervest.hrms.service.SalaryService;

@Controller
public class SalaryController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private SalaryService salaryService;

	@Autowired(required = true)
	@Qualifier(value = "salaryService")
	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}
	
	private EmployeeService employeeService;

	@Autowired(required = true)
	@Qualifier(value = "empService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
		
	@RequestMapping(value = "/salaryAdjustment", method = RequestMethod.GET)
	public String viewSalaryAdjustment(Model model) {
		model.addAttribute("employees", this.employeeService.listEmployees());
		return "salary/salaryadjustment";
	}
	
	@RequestMapping(value = "/editSalary/{empId}", method = RequestMethod.GET)
	public String editSalary(@PathVariable("empId") String empId, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeByID(Integer.parseInt(empId)));
		return "salary/editSalary";
	}
	
	@RequestMapping(value = "/updateSalary", method = RequestMethod.POST)
	public RedirectView updateSalary(@RequestParam("empID") int empID,
			@RequestParam("new_salary") String new_salary) {
		this.salaryService.updateSalary(empID, new_salary);
		return new RedirectView("salaryAdjustment");
	}
	
	@RequestMapping(value = "/variablepay", method = RequestMethod.GET)
	public String viewVariablePay(Model model) {
		model.addAttribute("variablepays", this.salaryService.listVariablePay());
		return "salary/list_variablepay";
	}
	
	@RequestMapping(value = "/addVariablePay", method = RequestMethod.GET)
	public String viewAddVariablePay() {
		return "salary/add_variablepay";
	}
	
	@RequestMapping(value = "/submitVariablePay", method = RequestMethod.POST)
	public String addVariablePay(
			@RequestParam("description") String description,
			@RequestParam("amount") double amount,
			@RequestParam("mode") String mode) {
		
		VariablePay variablePay = new VariablePay();
		variablePay.setDescription(description);
		variablePay.setAmount(amount);
		variablePay.setMode(mode);
		this.salaryService.addVariablePay(variablePay);
		return "redirect:/variablepay";

	}
	
	@RequestMapping(value = "/editVariablePay/{id}", method = RequestMethod.GET)
	public String editVariablePay(@PathVariable("id") String id, Model model) {
		model.addAttribute("variablePay", this.salaryService.getVariablePayId(Integer.parseInt(id)));
		return "salary/edit_variablepay";
	}
	
	@RequestMapping(value = "/updateVariablePay", method = RequestMethod.POST)
	public String updateVariablePay(
			@RequestParam("varid") int id,
			@RequestParam("description") String description,
			@RequestParam("amount") double amount,
			@RequestParam("mode") String mode) {
		
		VariablePay variablePay = new VariablePay();
		variablePay.setId(id);
		variablePay.setDescription(description);
		variablePay.setAmount(amount);
		variablePay.setMode(mode);
		this.salaryService.updateVariablePay(variablePay);
		return "redirect:/variablepay";

	}
	
	@RequestMapping(value = "/deleteVariablePay/{id}", method = RequestMethod.GET)
	public String deleteVariablePay(@PathVariable("id") String id) {
		VariablePay variablePay = this.salaryService.getVariablePayId(Integer.parseInt(id));
		this.salaryService.deleteVariablePay(variablePay);
		return "redirect:/variablepay";
	}
	
	@RequestMapping(value = "/variablededuction", method = RequestMethod.GET)
	public String viewVariableDeduction(Model model) {
		model.addAttribute("variabledeductions", this.salaryService.listVariableDeduction());
		return "salary/list_variablededuction";
	}
	
	@RequestMapping(value = "/addVariableDeduction", method = RequestMethod.GET)
	public String viewAddVariableDeduction() {
		return "salary/add_variablededuction";
	}
	
	@RequestMapping(value = "/submitVariableDeduction", method = RequestMethod.POST)
	public String addVariableDeduction(
			@RequestParam("description") String description,
			@RequestParam("amount") double amount,
			@RequestParam("mode") String mode) {
		
		VariableDeduction variableDeduction = new VariableDeduction();
		variableDeduction.setDescription(description);
		variableDeduction.setAmount(amount);
		variableDeduction.setMode(mode);
		this.salaryService.addVariableDeduction(variableDeduction);;
		return "redirect:/variablededuction";

	}
	
	@RequestMapping(value = "/editVariableDeduction/{id}", method = RequestMethod.GET)
	public String editVariableDeduction(@PathVariable("id") String id, Model model) {
		model.addAttribute("variableDeduction", this.salaryService.getVariableDeductionId(Integer.parseInt(id)));
		return "salary/edit_variablededuction";
	}
	
	@RequestMapping(value = "/updateVariableDeduction", method = RequestMethod.POST)
	public String updateVariableDeduction(
			@RequestParam("varid") int id,
			@RequestParam("description") String description,
			@RequestParam("amount") double amount,
			@RequestParam("mode") String mode) {
		
		VariableDeduction variableDeduction = new VariableDeduction();
		variableDeduction.setId(id);
		variableDeduction.setDescription(description);
		variableDeduction.setAmount(amount);
		variableDeduction.setMode(mode);
		this.salaryService.updateVariableDeduction(variableDeduction);
		return "redirect:/variablededuction";

	}
	
	@RequestMapping(value = "/deleteVariableDeduction/{id}", method = RequestMethod.GET)
	public String deleteVariableDeduction(@PathVariable("id") String id) {
		VariableDeduction variableDeduction = this.salaryService.getVariableDeductionId(Integer.parseInt(id));
		this.salaryService.deleteVariableDeduction(variableDeduction);
		return "redirect:/variablededuction";
	}
	
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	public String viewProcess(Model model) {
		model.addAttribute("employees", this.employeeService.listEmployees());
		model.addAttribute("variablepays", this.salaryService.listVariablePay());
		model.addAttribute("variabledeductions", this.salaryService.listVariableDeduction());
		return "salary/process";
	}
	
	@RequestMapping(value = "/submitProcess", method = RequestMethod.POST)
	public String addProcess(
			@RequestParam("payment") String payment,
			@RequestParam(value = "ending_date", required = false) String endingDate,
			@RequestParam("apply_to") String employee,
			@RequestParam(value = "employee", required = false) String empId,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "variablepay", required = false) String payId,
			@RequestParam(value = "variablededuction", required = false) String deductId) {
		this.salaryService.addProcess(empId, type, employee, payment, endingDate, payId, deductId);
		return "redirect:/process";

	}
	
	@RequestMapping(value = "/employeeSalaries", method = RequestMethod.GET)
	public String viewSalary(Model model) {
		model.addAttribute("employees", this.employeeService.listEmployees());
		return "salary/list_salary";
	}
	
	@RequestMapping(value = "/getSalaryDetails", method = RequestMethod.POST)
	public String getSalaryDetails(
			@RequestParam(value = "employee") String empId, Model model) {
		List salaryDetails = this.salaryService.salaryDetails(empId);
		model.addAttribute("employees", this.employeeService.listEmployees());
		model.addAttribute("variablepays", salaryDetails.get(0));
		model.addAttribute("variabledeductions", salaryDetails.get(1));
		model.addAttribute("employee", this.employeeService.getEmployeeByID(Integer.parseInt(empId)));
		return "salary/list_salary";

	}
}
