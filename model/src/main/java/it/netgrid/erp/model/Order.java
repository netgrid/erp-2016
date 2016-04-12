package it.netgrid.erp.model;

import java.util.Date; 


@Entity(name="order")
public class Order {
	

	public static final String ID_FIELD_NAME = "ord_id";
	public static final String CLIENT_FIELD_NAME = "ord_client";
	public static final String PROVIDER_FIELD_NAME = "ord_client";
	public static final String STATE_CODE_FIELD_NAME = "ord_state_code";
	//public static final String DATE_ORDER_FIELD_NAME = "ord_date_order";
	//public static final String DATE_SHIP_FIELD_NAME = "ord_date_ship";
	public static final String DDT_FIELD_NAME = "ord_ddt";
	public static final String INVOICE_FIELD_NAME = "ord_invoice";
	
	
	
	@Id
	@GeneratedValue
	@Column(name = ID_FIELD_NAME)
	private long id;
	
	@OneToMany
	@JoinColumn(name = CLIENT_FIELD_NAME)
//	private Client client;
	
	@OneToMany
	@JoinColumn(name = PROVIDER_FIELD_NAME)
//	private Provider provider;
	
	@Column(name = STATE_CODE_FIELD_NAME)
	private String stateCode;
	
	/*
	@Column(name = DATE_ORDER_FIELD_NAME)
	private Date dateOrder;
	
	@Column(name = DATE_SHIP_FIELD_NAME)
	private Date dateShip;
	*/
	@OneToOne
	@JoinColumn(name = DDT_FIELD_NAME)
//	private DDT ddt;
	
	@OneToOne
	@JoinColumn(name = INVOICE_FIELD_NAME)
//	private Invoice invoice;
	
	public Order() {}



	
	


}
