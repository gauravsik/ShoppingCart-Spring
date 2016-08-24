package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import supporters.OutOfStockException;

import models.Shop;
import models.ShoppingCart;

@Controller
@RequestMapping(value = "/shop")
public class ProcessController {
	@Autowired
	Shop shop;

	@Autowired
	ShoppingCart cart;

	@RequestMapping(value = "/products")
	public ModelAndView displayAllProducts(ModelMap model, HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		return new ModelAndView("products", "shop", shop);
	}

	@RequestMapping(value = "/add")
	public ModelAndView add(@RequestParam Integer pid, HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		int cartSize = cart.add(shop.getProductByProductId(pid));
		System.out.println("cart size = " + cartSize);
		return new ModelAndView("products", "shop", shop);
	}

	@RequestMapping(value = "/viewcart")
	public ModelAndView displayCart(ModelMap model, HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		return new ModelAndView("viewcart", "cart", cart);
	}

	@RequestMapping(value = "/placeorder")
	public ModelAndView placeOrder(ModelMap model, HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		cart.clearCart();
		return new ModelAndView("placeorder", "cart", cart);
	}

	@RequestMapping(value = "/remove")
	public ModelAndView remove(@RequestParam Integer pid, HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		int cartSize = cart.remove(shop.getProductByProductId(pid));
		System.out.println("cart size = " + cartSize);
		return new ModelAndView("viewcart", "cart", cart);
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest req, HttpSession session) {
		System.out.println(req.getRequestURI());
		session.invalidate();
		return new ModelAndView("redirect:/index");
	}

	@ExceptionHandler(OutOfStockException.class)
	public ModelAndView handleCustomException(OutOfStockException o) {
		ModelAndView model = new ModelAndView("exception");
		model.addObject("exceptionMsg", o.getMessage());
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView("exception");
		model.addObject("exceptionMsg", "Oops Something went wrong!");
		return model;
	}

}
