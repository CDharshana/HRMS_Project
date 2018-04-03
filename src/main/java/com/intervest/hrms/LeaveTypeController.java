package com.intervest.hrms;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.intervest.hrms.model.HRMSAlert;
import com.intervest.hrms.model.LeaveType;
import com.intervest.hrms.service.LeaveTypeService;

@Controller
public class LeaveTypeController {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeController.class);
	private LeaveTypeService leaveTypeService;

	@Autowired(required = true)
	@Qualifier(value = "leaveTypeService")
	public void setPersonService(LeaveTypeService lts) {
		this.leaveTypeService = lts;
	}

	@RequestMapping(value = "/leaveTypes", method = RequestMethod.GET)
	public String viewLeaveTypes(Locale locale, Model model) {
		model.addAttribute("leaveType", new LeaveType());
		model.addAttribute("leaveTypeList",
				this.leaveTypeService.listLeaveTypes());
		return "leave_types/leave_types";
	}

	@RequestMapping(value = "/leaveType/add", method = RequestMethod.POST)
	public String addLeaveType(RedirectAttributes redir,
			@ModelAttribute("leaveType") LeaveType lt) {

		if (lt.getId() == 0) {
			this.leaveTypeService.addLeaveType(lt);
			HRMSAlert alert = new HRMSAlert(1, "Success!",
					"New Leave type added.");
			redir.addFlashAttribute("hrmsAlert", alert);
		} else {

			this.leaveTypeService.updateLeaveType(lt);
		}

		return "redirect:/leaveTypes";

	}

	/*
	 * @RequestMapping("/remove/{id}") public String
	 * removeLeaveType(@PathVariable("id") int id) {
	 * 
	 * this.leaveTypeService.removeLeaveType(id); return "redirect:/leaveTypes";
	 * }
	 * 
	 * @RequestMapping("/edit/{id}") public String
	 * editLeaveType(@PathVariable("id") int id, Model model) {
	 * model.addAttribute("leaveType",
	 * this.leaveTypeService.getLeaveTypeByID(id));
	 * model.addAttribute("listPersons",
	 * this.leaveTypeService.listLeaveTypes()); return "person"; }
	 */
}
