package it.netgrid.erp.model;

import java.math.BigDecimal;

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
	public static final String UNITS_OF_MEASURE="pro_units_of_measure";
	
	@Id
	@GeneratedValue
	@Column(name=ID_NAME)
	private Long id;
	
	@Column(name=PRODUCT_NAME)
	private String product;
	
	@Column(name=PRODUCT_PRICE)
	private BigDecimal price;
	
	@Column(name=PRODUCT_QUANTITY)
	private BigDecimal quantity;
	
	@Column(name=UNITS_OF_MEASURE)
	private String units_of_measure;
	
	public Product(){	
	}
	
	public Product(Long id,String product,BigDecimal price,BigDecimal quantity, String misure){
		this.id = id;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.units_of_measure = misure;
		
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
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	public String getUnitOfMeasure() {
		return units_of_measure;
	}

	public void setUnitOfMeasure(String units_of_measure) {
		this.units_of_measure = units_of_measure;
	}
}
