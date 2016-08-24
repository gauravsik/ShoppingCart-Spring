package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import supporters.OutOfStockException;

@Component
@Scope("session")
public class ShoppingCart extends Shop {
	List<Shop> cartItems = new ArrayList<Shop>();

	List<Shop> customerCart = new ArrayList<Shop>();
	private double cartValue;

	public List<Shop> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Shop> cartItems) {
		this.cartItems = cartItems;
	}

	public List<Shop> getCustomerCart() {
		return customerCart;
	}

	public void setCustomerCart(List<Shop> customerCart) {
		this.customerCart = customerCart;
	}

	public double getCartValue() {
		return cartValue;
	}

	public void setCartValue(double cartValue) {
		this.cartValue = cartValue;
	}

	public int add(Shop productToAdd) {
		if (inStock(productToAdd)) {
			cartItems.add(productToAdd);
			productToAdd.setStock(productToAdd.getStock() - 1);
			setCartValue(getCartValue() + productToAdd.getPrice());
			buildCart(productToAdd);
		} else
			throw new OutOfStockException(productToAdd.getPname() + " is out of stock!");
		return cartItems.size();
	}

	private boolean inStock(Shop productToAdd) {
		if (productToAdd.getStock() - 1 < 0)
			return false;
		return true;
	}

	public int remove(Shop productToRemove) {
		System.out.println("stock for " + productToRemove.getPname() + " is " + productToRemove.getStock());
		Iterator<Shop> itr = cartItems.iterator();
		while (itr.hasNext()) {
			setCartValue(getCartValue() - productToRemove.getPrice());
			productToRemove.setStock(productToRemove.getStock() + 1);
			cartItems.remove(productToRemove);
			buildCart(productToRemove);
			break;
		}
		return cartItems.size();
	}

	public void buildCart(Shop product) {
		Set<Shop> uniqueSet = new HashSet<Shop>(cartItems);
		int quantity;
		customerCart.remove(product);
		quantity = Collections.frequency(cartItems, product);
		product.setQuantity(quantity);
		System.out.println("product = " + product.getPname() + " quantity = " + product.getQuantity());
		if(!(product.getQuantity()==0)){
			customerCart.add(product);
		}
	}

	public void clearCart() {
		cartItems.removeAll(cartItems);
		customerCart.removeAll(customerCart);
	}

}
