package com.bitwise.shop.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bitwise.shop.models.User;
import com.bitwise.shop.models.UserValidator;
import com.bitwise.shop.models.Users;

@Controller
public class WebController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authorizeUserFisrt(ModelMap model, @ModelAttribute("user") User user, BindingResult result, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		String url = "login";
		url = checkInput(model, user, result, url, request, response);
		return (url);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String displayProducts(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "products";
	}

	private String checkInput(ModelMap model, User user, BindingResult result, String url, HttpServletRequest request,
			HttpServletResponse response) {
		UserValidator validator = new UserValidator();
		validator.validate(user, result);
		url = authenticateUser(model, user, result, url, request, response);
		return url;

	}
	private String authenticateUser(ModelMap model, User user, BindingResult result, String url,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			url = "login";
		} else if (new Users().getUsers().contains(user)) {
			url = "redirect:/products";
		} else {
			model.addAttribute("error", "invalidUser");
		}
		return url;
	}
}