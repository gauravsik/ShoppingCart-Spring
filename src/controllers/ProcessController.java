package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Remove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import supporters.OtherExceptions;
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
		if (cart.getCartItems().size() == 0)
			throw new OtherExceptions("No Item in cart");
		else
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
	public ModelAndView handleOutOfStockException(OutOfStockException o) {
		ModelAndView model = new ModelAndView("exception");
		model.addObject("exceptionMsg", o.getMessage());
		return model;
	}
	@ExceptionHandler(OtherExceptions.class)
	public ModelAndView handleOtherExceptions(OtherExceptions o) {
		ModelAndView model = new ModelAndView("exception");
		model.addObject("exceptionMsg", o.getMessage());
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView("exception");
		String msg="Oops Something went wrong!";
		model.addObject("exceptionMsg", msg);
		return model;
	}

}
