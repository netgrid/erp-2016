package it.netgrid.erp.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
 

@Entity(name="order")

public class Order implements CrudObject<Long>{
	public static final String ID_FIELD_NAME = "ord_id";
	public static final String ORDER_FIELD_NAME = "ord_order";
	public static final String NUMBER_ORDERS_FIELD_NAME = "ord_number_orders";
	
	@Id
	@GeneratedValue
	@Column(name = ID_FIELD_NAME)
	private Long id;	
	
	@ForeignCollectionField
	private ForeignCollection<OrderItem> items;	
	
	@Column(name = NUMBER_ORDERS_FIELD_NAME)
	private Integer numberOrders;

	public Order() {}

	public Order(Long id, ForeignCollection<OrderItem> items, Integer numberOrders) {
		super();
		this.id = id;
		this.items = items;
		this.numberOrders = numberOrders;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumberOrders() {
		return numberOrders;
	}

	public void setNumberOrders(Integer numberOrders) {
		this.numberOrders = numberOrders;
	}

	public ForeignCollection<OrderItem> getItems() {
		return items;
	}

	public void setItems(ForeignCollection<OrderItem> items) {
		this.items = items;
	}

}
