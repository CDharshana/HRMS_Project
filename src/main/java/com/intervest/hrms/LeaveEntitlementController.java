package com.intervest.hrms;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import com.intervest.hrms.model.EntitlementDetail;
import com.intervest.hrms.model.HRMSAlert;
import com.intervest.hrms.model.LeaveEntitlement;
import com.intervest.hrms.model.LeaveType;
import com.intervest.hrms.service.EmployeeService;
import com.intervest.hrms.service.LeaveEntitlementService;
import com.intervest.hrms.service.LeaveTypeService;

@Controller
public class LeaveEntitlementController {
	private LeaveTypeService leaveTypeService;
	private EmployeeService employeeService;
	private LeaveEntitlementService leaveEntitlementService;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired(required = true)
	@Qualifier(value = "leaveEntitlementService")
	public void setLeaveEntitlementService(LeaveEntitlementService les) {
		this.leaveEntitlementService = les;
	}

	@Autowired(required = true)
	@Qualifier(value = "leaveTypeService")
	public void setPersonService(LeaveTypeService lts) {
		this.leaveTypeService = lts;
	}

	@Autowired(required = true)
	@Qualifier(value = "empService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/entitlements", method = RequestMethod.GET)
	public String showAddEntitlements(Locale locale, Model model) {
		model.addAttribute("leaveTypes", this.leaveTypeService.listLeaveTypes());
		model.addAttribute("leaveEntitlement", new LeaveEntitlement());
		model.addAttribute("employees", this.employeeService.listEmployees());
		return "entitlements/add_entitlements";
	}

	@RequestMapping(value = "/leaveEntitlements/add", method = RequestMethod.POST)
	public String addLeaveEntitlements(RedirectAttributes redir,
			@ModelAttribute("leaveEntitlement") LeaveEntitlement len,
			@RequestParam("employee") int employeeID,
			@RequestParam("leaveTypes") int leaveType,
			@RequestParam("leaveAmount") double leaveAmount) {
		if (employeeID == 0) {
			List<EntitlementDetail> enDetails = new ArrayList<EntitlementDetail>();
			List<Employee> employeeList = this.employeeService.listEmployees();
			for (Employee employee : employeeList) {
				EntitlementDetail enDetail = new EntitlementDetail();
				LeaveType leaveTypeObj = new LeaveType();
				leaveTypeObj.setId(leaveType);
				enDetail.setEmployee(employee);
				enDetail.setLeaveType(leaveTypeObj);
				enDetail.setAmount(leaveAmount);
				enDetail.setEntitlement(len);
				enDetails.add(enDetail);
			}
			len.setEntitlements(enDetails);

			logger.info("size " + enDetails.size());
		} else {
			List<EntitlementDetail> enDetails = new ArrayList<EntitlementDetail>();
			Employee employee = this.employeeService
					.getEmployeeByID(employeeID);
			EntitlementDetail enDetail = new EntitlementDetail();
			LeaveType leaveTypeObj = new LeaveType();
			leaveTypeObj.setId(leaveType);
			enDetail.setEmployee(employee);
			enDetail.setLeaveType(leaveTypeObj);
			enDetail.setAmount(leaveAmount);
			enDetail.setEntitlement(len);
			enDetails.add(enDetail);
			len.setEntitlements(enDetails);

		}
		this.leaveEntitlementService.addLeaveEntitlement(len);
		HRMSAlert alert = new HRMSAlert(1, "Success!",
				"New Leave Entitlements added");
		redir.addFlashAttribute("hrmsAlert", alert);
		return "redirect:/entitlements";

	}

	// @RequestMapping("/remove/{id}")
	// public String removeLeaveEntitlement(@PathVariable("id") int id) {
	//
	// this.leaveEntitlementService.removeLeaveEntitlement(id);
	// return "redirect:/leaveEntitlements";
	// }
	//
	// @RequestMapping("/edit/{id}")
	// public String editLeaveEntitlement(@PathVariable("id") int id, Model
	// model) {
	// model.addAttribute("leaveEntitlement",
	// this.leaveEntitlementService.getLeaveEntitlementById(id));
	// model.addAttribute("listPersons",
	// this.leaveEntitlementService.listLeaveEntitlements());
	// return "leave_entitlements/leave_entitlements";
	// }
}
