package it.netgrid.erp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="order_item")
public class OrderItem {
	
	public static final String ID_FIELD_NAME = "oit_id";
	public static final String CUSTOMER_FIELD_NAME = "oit_customer";
	public static final String PROVIDER_FIELD_NAME = "oit_provider";
	public static final String STATE_CODE_FIELD_NAME = "oit_state_code";
	public static final String DDT_FIELD_NAME = "oit_ddt";
	public static final String INVOICE_FIELD_NAME = "oit_invoice";
	
	
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
	
	public OrderItem() {}

	public OrderItem(long id, Registry customer, Registry provider, String stateCode, DDT ddt, Invoice invoice) {
		this.id = id;
		this.customer = customer;
		this.provider = provider;
		this.stateCode = stateCode;
		this.ddt = ddt;
		this.invoice = invoice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Registry getCustomer() {
		return customer;
	}

	public void setCustomer(Registry customer) {
		this.customer = customer;
	}

	public Registry getProvider() {
		return provider;
	}

	public void setProvider(Registry provider) {
		this.provider = provider;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public DDT getDdt() {
		return ddt;
	}

	public void setDdt(DDT ddt) {
		this.ddt = ddt;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	
	
}
