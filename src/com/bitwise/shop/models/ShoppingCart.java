package com.bitwise.shop.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ShoppingCart {
	static int cartSize;
	static double cartValue;
	static List<Product> productsInCart = new ArrayList<Product>();
	static List<Product> products = new ArrayList<Product>();
	Set<Product> orderdItems = new HashSet<Product>();

	Product pro;

	public ShoppingCart() {
		this.buildProductList();
	}

	private void buildProductList() {
		products.add(new Product(1, "Galaxy S7", 3500.500d, "Samsung", 15));
		products.add(new Product(2, "Xperia Xs", 2800.00d, "Sony", 12));
		products.add(new Product(3, "LG G4", 11200.00d, "LG", 13));
		products.add(new Product(4, "Galaxy Note 5", 1100.00d, "Samsung", 10));
		products.add(new Product(5, "iPhone 6s", 56000.00d, "Apple", 10));
		products.add(new Product(6, "iPhone 6s Plus", 109000.00d, "Apple", 15));
		products.add(new Product(7, "Moto X Play", 1129.00d, "Motorola", 11));
		products.add(new Product(8, "Nokia Lumia ", 9900.00d, "Nokia", 13));
		products.add(new Product(9, "Moto X Style", 12000.00d, "Motorola", 16));
		products.add(new Product(10, "Nokia 3300", 60.00d, "Nokia", 25));
	}

	public static double getCartValue() {
		return cartValue;
	}

	public static void setCartValue(double cartValue) {
		ShoppingCart.cartValue = cartValue;
	}

	public  Set<Product> getCartItems() {

		System.out.println(orderdItems.size());
		return orderdItems;
	}

	public List<Product> getProductsList() {
		return products;
	}

	public List<Product> getProductsInCart() {
		return productsInCart;
	}

	public int getCartSize() {
		return cartSize;
	}

	public void setCartSize(int cartSize) {
		ShoppingCart.cartSize = cartSize;
	}

	public Set<Product> getOrderdItems() {
		this.setOrderdItems(orderdItems);
		return orderdItems;
	}

	public void setOrderdItems(Set<Product> orderdItems) {
		Set<Product> uniqueSet = new HashSet<Product>(productsInCart);
		for (Product temp : uniqueSet) {
			System.out.println(temp.getProdName() + ": " + Collections.frequency(productsInCart, temp));
			pro = temp;
			pro.setQuantity(Collections.frequency(productsInCart, pro));
			pro.setTotalAmount(pro.getQuantity() * pro.getProdPrice());
			orderdItems.add(pro);
		}
		//this.orderdItems = orderdItems;
	}

	public Product getProductById(Integer productId, String action) {
		if (action.equals("add")) {
			for (Product product : products) {
				if (product.getPID() == productId) {
					pro = product;
					return pro;
				}
			}
		} else if (action.equals("remove")) {
			for (Product product : productsInCart) {
				if (product.getPID() == productId) {
					pro = product;
					return pro;
				}
			}
		}
		return pro;
	}

	public int addProductToCart(Product productToAdd) {

		System.out.println("stock for " + productToAdd.getProdName() + " is " + productToAdd.getStock());
		if (inStock(productToAdd)) {
			productsInCart.add(productToAdd);
			setCartValue(productToAdd.getProdPrice() + getCartValue());
			productToAdd.setStock(productToAdd.getStock() - 1);
			setCartSize(productsInCart.size());

		} else {
			System.out.println("out of stock");
			throw new OutOfStockException("No Stock For " + productToAdd.getProdName() + " left!!");
		}
		return cartSize;
	}

	private boolean inStock(Product productToAdd) {
		if (productToAdd.getStock() - 1 < 0)
			return false;
		return true;
	}

	public int removeProductFromCart(Product productToRemove) {
		System.out.println("stock for " + productToRemove.getProdName() + " is " + productToRemove.getStock());
		Iterator<Product> itr = productsInCart.iterator();
		while (itr.hasNext()) {
			setCartValue(getCartValue() - productToRemove.getProdPrice());
			productToRemove.setStock(productToRemove.getStock() + 1);
			productsInCart.remove(productToRemove);
			setCartSize(productsInCart.size());
			break;
		}
		return cartSize;
	}

}
