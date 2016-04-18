package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "product")
public class Product {
	public static final String ID_NAME="pro_id";
	public static final String PRODUCT_NAME="pro_product_name";
	public static final String PRODUCT_PRICE="pro_product_price";
	public static final String PRODUCT_DISCOUNT="pro_product_discount";
	public static final String PRODUCT_QUANTITY="pro_product_quatity";
	
	@Id
	@GeneratedValue
	@Column(name=ID_NAME)
	private Long id;
	
	@Column(name=PRODUCT_NAME)
	private String product;
	
	@Column(name=PRODUCT_PRICE)
	private int price;
	
	@Column(name=PRODUCT_QUANTITY)
	private int quantity;
	
	public Product(){	
	}
	
	public Product(Long id,String product,int price,int quantity){
		this.id = id;
		this.product = product;
		this.price = price;
		
		this.quantity = quantity;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
