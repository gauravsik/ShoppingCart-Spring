package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import models.User;
import supporters.UserValidation;

@Controller
public class LoginController {
	@Autowired
	User user;

	@RequestMapping(value = "/index")
	public ModelAndView displayIndexPage(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLoginPage(HttpServletRequest req, HttpSession session) {
		System.out.println(req.getRequestURI());
		String url;
		if (req.getSession(false).getAttribute("username") != null)
			url = "redirect:/index";
		else
			url = "login";
		return new ModelAndView(url, "user", user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView authenticateUser(ModelMap model, @ModelAttribute("user") User user, BindingResult result,
			HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("username " + user.getUsername() + " password " + user.getPassword());
		String url = null;
		new UserValidation().validate(user, result);
		if (result.hasErrors()) {
			url = "login";
		} else if (new data.Users().getUsers().contains(user)) {
			session = request.getSession(true);
			session.setAttribute("username", user.getUsername());
			url = "redirect:/shop/products";
		} else {
			model.addAttribute("error", "invalidUser");
		}
		return new ModelAndView(url);
	}

}
