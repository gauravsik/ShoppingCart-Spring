package com.bitwise.shop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bitwise.shop.models.Products;


public class ShoppingCart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	final static List<Product> listOfProductsInCart = new ArrayList<Product>();
	public int getCartSize() {

		return 0;
	}
	public Object setCartSize(int i) {

		return null;
	}
	public void addProduct(Integer productId) {
		List<Product> listOfProducts = new Products().getProductList();
		for (Product product : listOfProducts) {
			if (product.getPID() == productId) {
					listOfProductsInCart.add(product);
			}
		}
	}
	public void removeProduct(Integer productId) {
		int index=0;
		for(Product product : listOfProductsInCart){
			index++;
			if(product.getPID() == productId){
				listOfProductsInCart.remove(index);
			}
		}
	}
	public List<Product> getListOfProductsInCart(){
		return ShoppingCart.listOfProductsInCart;
	}
}
