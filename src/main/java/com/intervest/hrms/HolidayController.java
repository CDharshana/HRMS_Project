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
import com.intervest.hrms.model.Holiday;
import com.intervest.hrms.service.HolidayService;

@Controller
public class HolidayController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	private HolidayService holidayService;

	@Autowired(required = true)
	@Qualifier(value = "holidayService")
	public void setHolidayService(HolidayService holidayService) {
		this.holidayService = holidayService;
	}

	@RequestMapping(value = "/holidays", method = RequestMethod.GET)
	public String showHolidays(Locale locale, Model model) {
		model.addAttribute("holiday", new Holiday());
		model.addAttribute("holidays", this.holidayService.listHolidays());
		return "holidays/holidays";
	}

	@RequestMapping(value = "/holiday/add", method = RequestMethod.POST)
	public String addHoliday(RedirectAttributes redir,
			@ModelAttribute("holiday") Holiday holiday) {

		if (holiday.getId() == 0) {
			this.holidayService.addHoliday(holiday);
			HRMSAlert alert = new HRMSAlert(1, "Success!", "New Holiday added");
			redir.addFlashAttribute("hrmsAlert", alert);
		} else {

			this.holidayService.updateHoliday(holiday);
		}

		return "redirect:/holidays";

	}
}
