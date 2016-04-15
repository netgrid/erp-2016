package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;

@Entity(name = "order_item")
public class OrderItem implements CrudObject<Long> {

	public static final String ID_FIELD_NAME = "oit_id";
	public static final String CUSTOMER_FIELD_NAME = "oit_customer_id";
	public static final String PROVIDER_FIELD_NAME = "oit_provider_id";
	public static final String STATE_CODE_FIELD_NAME = "oit_state_code";
	public static final String INVOICE_FIELD_NAME = "oit_invoice_id";
	public static final String ORDER_ID_FIELD_NAME = "oit_ord_id";
	

	@Id
	@GeneratedValue
	@Column(name = ID_FIELD_NAME)
	private Long id;

	@ManyToOne
	@JoinColumn(name = CUSTOMER_FIELD_NAME)
	private Registry customer;

	@ManyToOne
	@JoinColumn(name = PROVIDER_FIELD_NAME)
	private Registry provider;

	@Column(name = STATE_CODE_FIELD_NAME)
	private String stateCode;

	@ForeignCollectionField
	private ForeignCollection<DeliveryNote> deliveryNotes;

	@ManyToOne
	@JoinColumn(name = INVOICE_FIELD_NAME)
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = ORDER_ID_FIELD_NAME)
	private Order order;

	public OrderItem() {
	}

	public OrderItem(Long id, Registry customer, Registry provider, String stateCode, Invoice invoice) {
		this.id = id;
		this.customer = customer;
		this.provider = provider;
		this.stateCode = stateCode;
		this.invoice = invoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public ForeignCollection<DeliveryNote> getDeliveryNotes() {
		return deliveryNotes;
	}

	public void setDeliveryNotes(ForeignCollection<DeliveryNote> deliveryNotes) {
		this.deliveryNotes = deliveryNotes;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
