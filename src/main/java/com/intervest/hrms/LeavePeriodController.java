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
import com.intervest.hrms.model.LeavePeriod;
import com.intervest.hrms.service.LeavePeriodService;

@Controller
public class LeavePeriodController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	private LeavePeriodService leavePeriodService;

	@Autowired(required = true)
	@Qualifier(value = "leavePeriodService")
	public void setLeavePeriodService(LeavePeriodService leavePeriodService) {
		this.leavePeriodService = leavePeriodService;
	}

	@RequestMapping(value = "/leavePeriods", method = RequestMethod.GET)
	public String showLeavePeriods(Locale locale, Model model) {
		model.addAttribute("leavePeriod", new LeavePeriod());
		model.addAttribute("leavePeriods",
				this.leavePeriodService.listLeavePeriods());
		return "leave_periods/leave_period";
	}

	@RequestMapping(value = "/leavePeriod/add", method = RequestMethod.POST)
	public String addLeavePeriod(RedirectAttributes redir,
			@ModelAttribute("leavePeriod") LeavePeriod lp) {

		if (lp.getId() == 0) {
			this.leavePeriodService.addLeavePeriod(lp);
			HRMSAlert alert = new HRMSAlert(1, "Success!",
					"New Leave Period added");
			redir.addFlashAttribute("hrmsAlert", alert);
		} else {

			this.leavePeriodService.updateLeavePeriod(lp);
		}

		return "redirect:/leavePeriods";

	}
}
