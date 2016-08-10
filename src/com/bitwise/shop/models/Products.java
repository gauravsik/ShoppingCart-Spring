package com.bitwise.shop.models;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.shop.models.Product;

public class Products {
	private List<Product> products = new ArrayList<Product>();
	
	public Products () {
		products.add(new Product(1, "Galaxy S7", 3500.500d,"Samsung", 15));
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
	
	public List<Product> getProductList () {
		return this.products;
	}
}
