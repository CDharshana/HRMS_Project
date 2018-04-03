package com.intervest.hrms;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.intervest.hrms.model.User;
import com.intervest.hrms.service.UserService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewLogin(Locale locale, Model model) {
		logger.info("Welcome Login! The client locale is {}.", locale);

		// String password = "123456";
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// String hashedPassword = passwordEncoder.encode(password);

		// logger.info(hashedPassword);
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String home(HttpServletRequest request, Model model) {
		// User loggedUser = (User) request.getSession()
		// .getAttribute("loggedUser");
		// model.addAttribute("loggedUser", loggedUser);
		return "home";
	}

	/*
	 * User Login function
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password,
			RedirectAttributes redir, HttpServletRequest request) {
		User user = this.userService.getUserByUsername(username);
		String errorMessage = "";
		if (user != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(password, user.getPassword())) {
				request.getSession().setAttribute("loggedUser", user);
				return "redirect:/home";
			} else {
				errorMessage = "Invalid credentials";
				redir.addFlashAttribute("errorMessage", errorMessage);
				return "redirect:/";
			}

		} else {
			errorMessage = "Invalid credentials";
			redir.addFlashAttribute("errorMessage", errorMessage);
			return "redirect:/";
		}

	}

	/*
	 * Logout Function
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
