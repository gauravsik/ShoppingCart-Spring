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

import com.bitwise.shop.helpers.UserValidation;
import com.bitwise.shop.models.User;
import com.bitwise.shop.models.Users;
@Controller
public class LoginController {
	@RequestMapping(value = "/index")
	public String displayIndex(ModelMap model) {
		return ("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayLogin(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return ("login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String auth(ModelMap model, @ModelAttribute("user") User user, BindingResult result, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		String url = "login";
		url = checkInput(model, user, result, url, request, response);
		return (url);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String performLogout(ModelMap model) {
		
		return ("logout");
	}

	private String checkInput(ModelMap model, User user, BindingResult result, String url, HttpServletRequest request,
			HttpServletResponse response) {
		UserValidation validation = new UserValidation();
		validation.validate(user, result);
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
