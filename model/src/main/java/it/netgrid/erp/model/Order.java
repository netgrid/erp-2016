package it.netgrid.erp.model;

import java.util.Date; 

@Entity(name="order")
public class Order {
	

	public static final String ID_FIELD_NAME = "ord_id";
	public static final String CLIENT_FIELD_NAME = "ord_client";
	public static final String PROVIDER_FIELD_NAME = "ord_client";
	public static final String STATE_CODE_FIELD_NAME = "ord_state_code";
	public static final String DDT_FIELD_NAME = "ord_ddt";
	public static final String INVOICE_FIELD_NAME = "ord_invoice";
	
	
	@Id
	@GeneratedValue
	@Column(name = ID_FIELD_NAME)
	private long id;
	
	@OneToMany
	@JoinColumn(name = CLIENT_FIELD_NAME)
	private Client client;
	
	@OneToMany
	@JoinColumn(name = PROVIDER_FIELD_NAME)
	private Provider provider;
	
	@Column(name = STATE_CODE_FIELD_NAME)
	private String stateCode;
	
	@OneToOne
	@JoinColumn(name = DDT_FIELD_NAME)
	private DDT ddt;
	
	@OneToOne
	@JoinColumn(name = INVOICE_FIELD_NAME)
	private Invoice invoice;
	
	public Order() {}

	public Order(long id, Client client, Provider provider, String stateCode, DDT ddt, Invoice invoice) {
		super();
		this.id = id;
		this.client = client;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
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
