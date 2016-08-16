package com.bitwise.shop.helpers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.bitwise.shop.models.Product;
import com.bitwise.shop.models.ShoppingCart;

public class DisplayCart extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletResponse res = (HttpServletResponse) pageContext.getResponse();
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		List<Product> productsInCart = new ShoppingCart().getProductsInCart();
		out.println("<center>");
		out.println("<table border=1>");
		// out.println("<form method=post action=add>");
		out.println("<tr>");
		out.println("<td colspan=6 style='text-allign=center'><h3>Products</h3></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>ID</td>");
		out.println("<td>Name</td>");
		out.println("<td>Price</td>");
		out.println("<td>Supplier</td>");
		out.println("<td>Stock</td>");
		out.println("<td>ADD</td>");
		out.println("</tr>");
		for (Product product : productsInCart) {
			out.println("<tr>");
			out.println("<td>");
			out.println(product.getPID());
			out.println("</td>");
			out.println("<td>");
			out.println(product.getProdName());
			out.println("</td>");
			out.println("<td>");
			out.println("Rs " + product.getProdPrice());
			out.println("</td>");
			out.println("<td>");
			out.println(product.getSupplier());
			out.println("</td>");
			out.println("<td>");
			out.println(product.getStock());
			out.println("</td>");
			out.println("<td>");
			out.println("<a href='/ShoppingCart/remove?productId=" + product.getPID() + "'>REMOVE</a>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<center>");
		
	}
}
