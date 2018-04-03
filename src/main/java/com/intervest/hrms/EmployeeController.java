package com.intervest.hrms;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.intervest.hrms.model.Designation;
import com.intervest.hrms.model.Employee;
import com.intervest.hrms.model.HRMSAlert;
import com.intervest.hrms.model.User;
import com.intervest.hrms.service.DesignationService;
import com.intervest.hrms.service.EmployeeService;
import com.intervest.hrms.service.UserService;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private EmployeeService employeeService;
	private DesignationService designationService;
	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "empService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Autowired(required = true)
	@Qualifier(value = "designationService")
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public String viewAddEmployee(Locale locale, Model model) {
		model.addAttribute("designations",
				this.designationService.listDesignations());
		model.addAttribute("employees", this.employeeService.listEmployees());
		return "employees/add_employee";
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addEmployees(
			RedirectAttributes redir,
			@RequestParam("empID") int empID,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("nameWithInitials") String nameWithInitials,
			@RequestParam("nameInFull") String nameInFull,
			@RequestParam("nicNo") String nicNo,
			@RequestParam("personalAddress") String personalAddress,
			@RequestParam("cAddress") String cAddress,
			@RequestParam("gender") int gender,
			@RequestParam("dob") String dob,
			@RequestParam("email") String email,
			@RequestParam("highestQualifications") String highestQualifications,
			@RequestParam("skillsAndSpecialization") String skillsAndSpecialization,
			@RequestParam("yearsOfExperiance") double yearsOfExperiance,
			@RequestParam("university") String university,
			@RequestParam("yearGraduated") int yearGraduated,
			@RequestParam("curentlyFollowing") String curentlyFollowing,
			@RequestParam("dateOfAppointment") String dateOfAppointment,
			@RequestParam("contactNo") String contactNo,
			@RequestParam("designation") int designation,
			@RequestParam("supervisor") int supervisor,
			@RequestParam("bSalary") double bSalary,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("role") int role

	) {
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setNameWithInitials(nameWithInitials);
		emp.setNameInFull(nameInFull);
		emp.setNicNo(nicNo);
		emp.setPersonalAddress(personalAddress);
		emp.setCurrentAddress(cAddress);
		emp.setGender(gender);
		emp.setDob(dob);
		emp.setEmail(email);
		emp.setHighestQualification(highestQualifications);
		emp.setSkillsAndSpecialozations(skillsAndSpecialization);
		emp.setYearsOfExperiance(yearsOfExperiance);
		emp.setUniversity(university);
		emp.setYearGraduated(yearGraduated);
		emp.setCurrentlyFollowing(curentlyFollowing);
		emp.setAppointmentDate(dateOfAppointment);
		emp.setBasicSalary(bSalary);
		emp.setContactNo(contactNo);

		Designation desigObj = new Designation();
		desigObj.setId(designation);

		Employee supervisorEmp = new Employee();
		supervisorEmp.setId(supervisor);

		User user = new User();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);

		user.setUsername(username);
		user.setPassword(encodedPassword);
		user.setType(role);

		emp.setDesignation(desigObj);
		emp.setSupervisor(supervisorEmp);
		user = this.userService.addUser(user);
		if (user != null) {
			if (empID == 0) {
				emp.setUser(user);
				this.employeeService.addEmployee(emp);
				HRMSAlert alert = new HRMSAlert(1, "Success!",
						"New Employee added.");
				redir.addFlashAttribute("hrmsAlert", alert);
			} else {
				emp.setId(empID);
				this.employeeService.updateEmployee(emp);
			}
		}

		return "redirect:/listEmployees";

	}

	@RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
	public String listEmployees(HttpServletRequest request, Model model) {
		model.addAttribute("employees", this.employeeService.listEmployees());
		User user = (User) request.getSession().getAttribute("loggedUser");
		int empID = user.getEmployee().getId();
		Employee userEmp = this.employeeService.getEmployeeByID(user
				.getEmployee().getId());

		return "employees/list_employees";
	}

}
