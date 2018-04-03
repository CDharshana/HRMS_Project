package com.intervest.hrms;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.intervest.hrms.model.AppliedLeave;
import com.intervest.hrms.model.Employee;
import com.intervest.hrms.model.HRMSAlert;
import com.intervest.hrms.model.LeaveAmount;
import com.intervest.hrms.model.LeaveStatus;
import com.intervest.hrms.model.User;
import com.intervest.hrms.service.AppliedLeaveService;
import com.intervest.hrms.service.EmployeeService;
import com.intervest.hrms.service.HolidayService;
import com.intervest.hrms.service.LeaveTypeService;

@Controller
public class AppliedLeaveController {
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

	@RequestMapping(value = "/applyLeave", method = RequestMethod.GET)
	public String viewApplyLeave(Locale locale, Model model) {
		model.addAttribute("leaveTypes", leaveTypeService.listLeaveTypes());
		model.addAttribute("appliedLeave", new AppliedLeave());
		return "leaves/apply_leave";
	}

	@RequestMapping(value = "/applyLeaves/add", method = RequestMethod.POST)
	public String applyLeave(HttpServletRequest request,
			RedirectAttributes redir,
			@ModelAttribute("appliedLeave") AppliedLeave al) {
		User user = (User) request.getSession().getAttribute("loggedUser");
		LeaveAmount leaveAmount = new LeaveAmount();
		leaveAmount.setId(1);
		LeaveStatus ls = new LeaveStatus();
		ls.setId(1);

		al.setEmployee(user.getEmployee());
		al.setLeaveStatus(ls);
		al.setLeaveAmount(leaveAmount);

		// this.holidayService.getHolidayByDate(al.get)

		if (al.getId() == 0) {
			this.appliedLeaveService.addLeave(al);
			HRMSAlert alert = new HRMSAlert(1, "Success!", "Leave(s) Applied.");
			redir.addFlashAttribute("hrmsAlert", alert);

		} else {
			this.appliedLeaveService.updateLeave(al);
		}

		return "redirect:/applyLeave";

	}

	@RequestMapping(value = "/assignLeave", method = RequestMethod.GET)
	public String viewAssignLeave(Locale locale, Model model) {
		model.addAttribute("leaveTypes", this.leaveTypeService.listLeaveTypes());
		model.addAttribute("appliedLeave", new AppliedLeave());
		model.addAttribute("employees", this.employeeService.listEmployees());
		return "leaves/assign_leave";
	}

	@RequestMapping(value = "/assignLeaves/add", method = RequestMethod.POST)
	public String assignLeave(RedirectAttributes redir,
			@ModelAttribute("appliedLeave") AppliedLeave al) {

		LeaveAmount leaveAmount = new LeaveAmount();
		leaveAmount.setId(1);
		LeaveStatus ls = new LeaveStatus();
		ls.setId(2);

		al.setLeaveStatus(ls);
		al.setLeaveAmount(leaveAmount);

		if (al.getId() == 0) {
			this.appliedLeaveService.addLeave(al);
			HRMSAlert alert = new HRMSAlert(1, "Success!", "Leave(s) assigned");
			redir.addFlashAttribute("hrmsAlert", alert);
		} else {
			this.appliedLeaveService.updateLeave(al);
		}

		return "redirect:/assignLeave";

	}

	@RequestMapping(value = "/leaveList", method = RequestMethod.GET)
	public String viewLeaveList(Locale locale, Model model) {
		model.addAttribute("leavesList",
				this.appliedLeaveService.listAppliedLeaves());
		return "leaves/leave_list";
	}

	@RequestMapping(value = "/leaveStatus", method = RequestMethod.GET)
	public String viewLeaveStatus(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loggedUser");
		Employee userEmp = this.employeeService.getEmployeeByID(user
				.getEmployee().getId());
		model.addAttribute("leavesList", userEmp.getAppliedLeaves());
		return "leaves/leave_status";
	}

	@RequestMapping("/remove/{id}")
	public String removeAppliedLeave(@PathVariable("id") int id) {

		this.appliedLeaveService.removeAppliedLeave(id);
		return "redirect:/leave_list";
	}

	@RequestMapping("/edit/{id}")
	public String editAppliedLeave(@PathVariable("id") int id, Model model) {
		model.addAttribute("appliedLeave",
				this.appliedLeaveService.getAppliedLeaveById(id));
		model.addAttribute("listPersons",
				this.appliedLeaveService.listAppliedLeaves());
		return "applied_leaves/applied_leaves";
	}

	@RequestMapping(value = "/approveLeave", method = RequestMethod.GET)
	public String viewLeavesForApprove(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loggedUser");

		model.addAttribute("approveList", this.appliedLeaveService
				.getPendingLeavesForSupervisor(user.getEmployee().getId()));
		return "leaves/leaves_for_approval";
	}

	@RequestMapping(value = "/leave/approve", method = RequestMethod.GET)
	public String approveLeave(HttpServletRequest request,
			RedirectAttributes redir, @RequestParam("leaveID") int leaveID) {
		AppliedLeave al = this.appliedLeaveService.getAppliedLeaveById(leaveID);
		LeaveStatus ls = new LeaveStatus();
		ls.setId(2);
		al.setLeaveStatus(ls);
		this.appliedLeaveService.updateLeave(al);
		HRMSAlert alert = new HRMSAlert(1, "Success!", "Leave Approved.");
		redir.addFlashAttribute("hrmsAlert", alert);

		return "redirect:/approveLeave";
	}

	@RequestMapping(value = "/leave/reject", method = RequestMethod.GET)
	public String rejectLeave(HttpServletRequest request,
			RedirectAttributes redir, @RequestParam("leaveID") int leaveID) {
		AppliedLeave al = this.appliedLeaveService.getAppliedLeaveById(leaveID);
		LeaveStatus ls = new LeaveStatus();
		ls.setId(3);
		al.setLeaveStatus(ls);
		this.appliedLeaveService.updateLeave(al);
		HRMSAlert alert = new HRMSAlert(2, "Warning!", "Leave Rejected.");
		redir.addFlashAttribute("hrmsAlert", alert);
		return "redirect:/approveLeave";
	}
}
