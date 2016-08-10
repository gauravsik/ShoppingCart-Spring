package com.bitwise.shop.models;

public class Product {
	private Integer PID;
	private String prodName;
	private Double prodPrice;
	private String supplier;
	private Integer stock;
	
	public Product () {}
	
	public Product (Integer pid, String prodName, Double prodPrice,String supplier, Integer stock) {
		this.PID = pid;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.supplier = supplier;
		this.stock = stock;
	}
	
	public Integer getPID() {
		return PID;
	}
	public void setPID(Integer pID) {
		PID = pID;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
