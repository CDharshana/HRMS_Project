package com.intervest.hrms;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AttendanceController {
	

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@RequestMapping(value = "/fingerprint_upl", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "fgprint/fingerprint_upl";
	}


}
