package com.bitwise.shop.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bitwise.shop.models.OutOfStockException;
import com.bitwise.shop.models.Product;
import com.bitwise.shop.models.ShoppingCart;

@Controller
// @Scope("session")
public class WebController {
	@Autowired
	private ShoppingCart cart;
	private Product pro;
//	private Order order;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView displayProducts(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("products", "cart", cart);
	}

	@RequestMapping(value = "/viewcart", method = RequestMethod.GET)
	public ModelAndView displayCart(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	
		return new ModelAndView("viewcart", "cart", cart);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addProductToCart(ModelMap model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam Integer productId) {

		System.out.println("pid = " + productId);
		String action = "add";
		pro = cart.getProductById(productId, action);
		int cartSize = cart.addProductToCart(pro);
		
		System.out.println("cart size = " + cartSize);
		return new ModelAndView("products", "cart", cart);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public ModelAndView removeProductFromCart(ModelMap model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam Integer productId) {
		System.out.println(req.getRequestURI());
		System.out.println(productId);
		String action = "remove";
		pro = cart.getProductById(productId, action);
		int cartSize = cart.removeProductFromCart(pro);
		System.out.println("cart size = " + cartSize);
		return new ModelAndView("viewcart", "cart", cart);
	}

	@RequestMapping(value = "/placeorder", method = RequestMethod.GET)
	public ModelAndView placeOrder(ModelMap model, HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getRequestURI());
		double orderAmount = cart.getCartValue();
		System.out.println("amount " + orderAmount);
		return new ModelAndView("placeorder", "cart", cart);
	}
	
	@ExceptionHandler(OutOfStockException.class)
	public ModelAndView handleCustomException(OutOfStockException o) {

		ModelAndView model = new ModelAndView("exception");
//		model.addObject("errCode", ex.getErrCode());
//		model.addObject("errMsg", ex.getErrMsg());
		model.addObject("exceptionMsg", o.getExceptionMsg());
		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("exception");
		model.addObject("exceptionMsg", "oops Something went wrong!");

		return model;

	}

}