package com.intervest.hrms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.intervest.hrms.model.Employee;
import com.intervest.hrms.model.HRMSAlert;
import com.intervest.hrms.model.TrainingEmployee;
import com.intervest.hrms.model.TrainingProgram;
import com.intervest.hrms.model.User;
import com.intervest.hrms.service.EmployeeService;
import com.intervest.hrms.service.TrainingProgramService;

@Controller
public class TrainingController {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeController.class);
	private EmployeeService employeeService;
	private TrainingProgramService tpService;

	@Autowired(required = true)
	@Qualifier(value = "empService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Autowired(required = true)
	@Qualifier(value = "trainingService")
	public void setTpService(TrainingProgramService tpService) {
		this.tpService = tpService;
	}

	@RequestMapping(value = "/newTraining", method = RequestMethod.GET)
	public String howAddNewTrainingProgram(Locale locale, Model model) {
		model.addAttribute("trainingProgram", new TrainingProgram());
		model.addAttribute("employees", this.getEmployeeList());
		return "trainings/add_training";
	}

	public Map<Integer, String> getEmployeeList() {
		List<Employee> employees = this.employeeService.listEmployees();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (Employee employee : employees) {
			map.put(employee.getId(), employee.getNameWithInitials());
		}
		return map;
	}

	@RequestMapping(value = "/trainingPrograms/add", method = RequestMethod.POST)
	public String addNewTrainingProgram(RedirectAttributes redir,
			@ModelAttribute("trainingProgram") TrainingProgram tp,
			@RequestParam("empID") int[] selecredEmplist) {
		List<TrainingEmployee> trainingEmployees = new ArrayList<TrainingEmployee>();
		for (int empID : selecredEmplist) {
			TrainingEmployee trEmployee = new TrainingEmployee();
			Employee employee = this.employeeService.getEmployeeByID(empID);
			trEmployee.setEmployee(employee);
			trEmployee.setTrainProgram(tp);
			trEmployee.setStatus(1);
			trainingEmployees.add(trEmployee);
		}
		tp.setTrainingEmployees(trainingEmployees);
		this.tpService.addTrainingProgram(tp);
		HRMSAlert alert = new HRMSAlert(1, "Success!",
				"New Training Program added");
		redir.addFlashAttribute("hrmsAlert", alert);
		return "redirect:/newTraining";

	}

	@RequestMapping(value = "/trainingPrograms", method = RequestMethod.GET)
	public String viewTrainingProgramList(HttpServletRequest request,
			Model model) {
		User user = (User) request.getSession().getAttribute("loggedUser");
		List<TrainingProgram> programList;
		if (user.getType() == 1) {
			programList = this.tpService.listTrainingPrograms();
		} else {
			programList = this.tpService.listTrainingProgramsForUser(user
					.getUserID());
		}
		model.addAttribute("trainingProgram", new TrainingProgram());
		model.addAttribute("trainingPrograms", programList);
		return "trainings/list_training_programs";
	}
}
