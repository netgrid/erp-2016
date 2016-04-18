package it.netgrid.erp.model.dto;

import java.util.List;

import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.Order;
import it.netgrid.erp.model.OrderItem;

public class OrderRoot implements CrudObject<Long>{

	private Order order;
	private List<OrderItem> orderItems;
	
	public OrderRoot(Order order, List<OrderItem> orderItems){
		this.order=order;
		this.orderItems=orderItems;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
