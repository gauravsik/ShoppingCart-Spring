package models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Scope("session")
public class Shop {
	private Integer pid;
	private String pname;
	private Double price;
	private Integer stock;
	private Integer quantity;
	private Double total;

	List<Shop> products = new ArrayList<Shop>();

	public List<Shop> getProducts() {
		return products;
	}

	public void setProducts(List<Shop> products) {
		this.products = products;
	}

	public Shop() {
		products.add(new Shop(1, "Apple IPhone 6S", 5, 65000.00));
		products.add(new Shop(2, "Samsung Galaxy S7 ", 6, 58000.00));
		products.add(new Shop(3, "Moto X Style", 9, 35000.00));
		products.add(new Shop(4, "Lg G4", 6, 48000.00));
		products.add(new Shop(5, "Sony Xperia Z", 6, 54000.00));
	}

	public Shop(int pid, String name, int stock, double price) {
		this.pid = pid;
		this.pname = name;
		this.stock = stock;
		this.price = price;
	}

	public Shop(Integer pid, String pname, double total, Integer quantity) {
		this.pid = pid;
		this.pname = pname;
		this.total = total;
		this.quantity = quantity;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Shop getProductByProductId(Integer pid2) {
		for (Shop shop : products) {
			if (shop.getPid().equals(pid2))
				return shop;
		}
		return null;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Shop other = (Shop) obj;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

}
