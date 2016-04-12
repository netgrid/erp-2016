package it.netgrid.erp.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 

@Entity(name="order")

public class Order {
	public static final String ID_FIELD_NAME = "ord_id";
	public static final String ORDERS_FIELD_NAME = "ord_orders";
	public static final String NUMBER_ORDERS_FIELD_NAME = "ord_number_orders";
	
	@Id
	@GeneratedValue
	@Column(name = ID_FIELD_NAME)
	private long id;	
	@Column(name = ORDERS_FIELD_NAME)
	private List<OrderItem> orders;	
	@Column(name = NUMBER_ORDERS_FIELD_NAME)
	private int numberOrders;

	public Order() {}
	
	public Order(long id, List<OrderItem> orders, int numberOrders) {
		this.id = id;
		this.orders = orders;
		this.numberOrders = numberOrders;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<OrderItem> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderItem> orders) {
		this.orders = orders;
	}

	public int getNumberOrders() {
		return numberOrders;
	}

	public void setNumberOrders(int numberOrders) {
		this.numberOrders = numberOrders;
	}

	
	

	
}
