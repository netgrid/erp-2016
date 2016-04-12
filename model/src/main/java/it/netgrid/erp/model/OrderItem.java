package it.netgrid.erp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class OrderItem {
	
	public static final String ID_FIELD_NAME = "oit_id";
	public static final String PRODUCTS_FIELD_NAME = "oit_products";
	public static final String NUMBER_PRODUCTS_FIELD_NAME = "oit_number_products";
	
	@Id
	@GeneratedValue
	@Column(name = ID_FIELD_NAME)
	private long id;
	
	@Column(name = PRODUCTS_FIELD_NAME)
	private List<Product> products;
	
	@Column(name = NUMBER_PRODUCTS_FIELD_NAME)
	private int numberProducts;

	public OrderItem() {}

	public OrderItem(long id, List<Product> products, int numberProducts) {
		this.id = id;
		this.products = products;
		this.numberProducts = numberProducts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getNumberProducts() {
		return numberProducts;
	}

	public void setNumberProducts(int numberProducts) {
		this.numberProducts = numberProducts;
	}
	
	
	
}
