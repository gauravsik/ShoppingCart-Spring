package com.bitwise.shop.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Product {
	private Integer PID;
	

	private String prodName;
	private Double prodPrice;
	private String supplier;
	private Integer stock;
	private int quantity;
	private double totalAmount;

	public Product() {
	}

	public Product(Integer pid, String prodName, Double prodPrice, String supplier, Integer stock) {
		this.PID = pid;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.supplier = supplier;
		this.stock = stock;
	}

	public Product(Integer pid, String prodName, int quantity, double totalAmount, String supplier) {
		this.PID = pid;
		this.prodName = prodName;
		this.quantity = quantity;
		this.supplier = supplier;
		this.totalAmount = totalAmount;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PID == null) ? 0 : PID.hashCode());
		result = prime * result + ((prodName == null) ? 0 : prodName.hashCode());
		result = prime * result + ((prodPrice == null) ? 0 : prodPrice.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (PID == null) {
			if (other.PID != null)
				return false;
		} else if (!PID.equals(other.PID))
			return false;
		if (prodName == null) {
			if (other.prodName != null)
				return false;
		} else if (!prodName.equals(other.prodName))
			return false;
		if (prodPrice == null) {
			if (other.prodPrice != null)
				return false;
		} else if (!prodPrice.equals(other.prodPrice))
			return false;
		if (quantity != other.quantity)
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		return true;
	}
}
