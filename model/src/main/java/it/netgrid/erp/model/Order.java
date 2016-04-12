package it.netgrid.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne; 

@Entity(name="order")
public class Order {
	

	public static final String ID_FIELD_NAME = "ord_id";
	public static final String CUSTOMER_FIELD_NAME = "ord_customer";
	public static final String PROVIDER_FIELD_NAME = "ord_provider";
	public static final String STATE_CODE_FIELD_NAME = "ord_state_code";
	public static final String DDT_FIELD_NAME = "ord_ddt";
	public static final String INVOICE_FIELD_NAME = "ord_invoice";
	public static final String ORDER_ITEM_FIELD_NAME = "ord_order_item";
	
	
	@Id
	@GeneratedValue
	@Column(name = ID_FIELD_NAME)
	private long id;
	
	@OneToMany
	@JoinColumn(name = CUSTOMER_FIELD_NAME)
	private Registry customer;
	
	@OneToMany
	@JoinColumn(name = PROVIDER_FIELD_NAME)
	private Registry provider;
	
	@Column(name = STATE_CODE_FIELD_NAME)
	private String stateCode;
	
	@OneToMany
	@JoinColumn(name = DDT_FIELD_NAME)
	private DDT ddt;
	
	@OneToOne
	@JoinColumn(name = INVOICE_FIELD_NAME)
	private Invoice invoice;
	
	@OneToMany
	@JoinColumn(name = ORDER_ITEM_FIELD_NAME)
	private OrderItem orderItem;
	
	public Order() {}



	



	
	


}
