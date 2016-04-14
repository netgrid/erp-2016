package it.netgrid.erp.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.j256.ormlite.dao.ForeignCollection;
 

@Entity(name="order")

public class Order {
	public static final String ID_FIELD_NAME = "ord_id";
	public static final String ORDER_FIELD_NAME = "ord_order";
	public static final String NUMBER_ORDERS_FIELD_NAME = "ord_number_orders";
	
	@Id
	@GeneratedValue
	@Column(name = ID_FIELD_NAME)
	private long id;	
	
	@OneToMany
	@JoinColumn(name = ORDER_FIELD_NAME)
	private ForeignCollection<OrderItem> order;	
	
	@Column(name = NUMBER_ORDERS_FIELD_NAME)
	private int numberOrders;

	public Order() {}

	public Order(long id, ForeignCollection<OrderItem> order, int numberOrders) {
		super();
		this.id = id;
		this.order = order;
		this.numberOrders = numberOrders;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ForeignCollection<OrderItem> getOrder() {
		return order;
	}

	public void setOrder(ForeignCollection<OrderItem> order) {
		this.order = order;
	}

	public int getNumberOrders() {
		return numberOrders;
	}

	public void setNumberOrders(int numberOrders) {
		this.numberOrders = numberOrders;
	}
	


	
	


}
