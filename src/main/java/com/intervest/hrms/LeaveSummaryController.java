package com.intervest.hrms;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.intervest.hrms.model.User;
import com.intervest.hrms.service.AppliedLeaveService;
import com.intervest.hrms.service.EmployeeService;
import com.intervest.hrms.service.HolidayService;
import com.intervest.hrms.service.LeaveTypeService;

@Controller
public class LeaveSummaryController {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeController.class);
	private AppliedLeaveService appliedLeaveService;
	private LeaveTypeService leaveTypeService;
	private EmployeeService employeeService;
	private HolidayService holidayService;

	@Autowired(required = true)
	@Qualifier(value = "leaveTypeService")
	public void setPersonService(LeaveTypeService lts) {
		this.leaveTypeService = lts;
	}

	@Autowired(required = true)
	@Qualifier(value = "appliedLeaveService")
	public void setAppliedLeaveService(AppliedLeaveService als) {
		this.appliedLeaveService = als;
	}

	@Autowired(required = true)
	@Qualifier(value = "empService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Autowired(required = true)
	@Qualifier(value = "holidayService")
	public void setHolidayService(HolidayService holidayService) {
		this.holidayService = holidayService;
	}

	@RequestMapping(value = "/leaveBalance", method = RequestMethod.GET)
	public String viewLeaveBalance(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loggedUser");
		int empID = user.getEmployee().getId();
		model.addAttribute("leaveBalance",
				this.appliedLeaveService.getLeaveBalance(empID));
		return "leaves/leave_balance";
	}

	@RequestMapping(value = "/leaveReport", method = RequestMethod.GET)
	public String viewLeaveReport(
			Model model,
			@RequestParam(value = "empID", required = false) Integer empID,
			@RequestParam(value = "dateFrom", required = false) String dateFrom,
			@RequestParam(value = "dateTo", required = false) String dateTo) {
		model.addAttribute("employees", this.employeeService.listEmployees());
		if (empID != null && dateFrom != null && dateTo != null) {
			model.addAttribute("leaveBalance", this.appliedLeaveService
					.getLeaveReport(empID.intValue(), dateFrom, dateTo));

		}
		return "leaves/leave_report";
	}

}
