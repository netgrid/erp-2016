package it.netgrid.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;

@XmlRootElement
@Entity(name = "invoices")
	public class Invoice implements CrudObject<Long>{
		
		public static final String ID_FIELD_NAME = "inv_id";
		public static final String IN_HOLDER_FIELD_NAME = "inv_holder";
		public static final String ADDRESS_FIELD_NAME = "inv_holder_address";
		public static final String ZIP_CODE_FIELD_NAME = "inv_holder_cap";
		public static final String CITY_FIELD_NAME = "inv_holder_city";
		public static final String STATE_FIELD_NAME = "inv_holder_state";
		public static final String PHONE_FIELD_NAME = "inv_holder_phone"; 
		public static final String VAT_NUMBER_FIELD_NAME = "inv_holder_vat_number"; 
		public static final String IN_CLIENT_FIELD_NAME = "inv_client_name"; 
		public static final String CLIENT_ADDRESS_FIELD_NAME = "inv_client_address";
		public static final String CLIENT_ZIP_CODE_FIELD_NAME = "inv_client_cap";
		public static final String CLIENT_CITY_FIELD_NAME = "inv_client_city";
		public static final String CLIENT_STATE_FIELD_NAME = "inv_client_state";
		public static final String CLIENT_VAT_NUMBER_FIELD_NAME = "inv_client_vat_number"; 
		public static final String CLIENT_TAX_CODE_FIELD_NAME = "inv_client_cod_fisc"; 	
		public static final String IN_NUMBER_FIELD_NAME = "inv_number";
		public static final String IN_DATE_FIELD_NAME = "inv_date";
		public static final String BANK_FIELD_NAME = "inv_bank";
		public static final String CURRENCY_FIELD_NAME = "inv_currency";
		public static final String CONSIGNMENT_FIELD_NAME= "inv_consignment";
		public static final String IN_PRODUCT_FIELD_NAME = "inv_product_name";
		public static final String TRANSPORT_AMOUNT_FIELD_NAME = "inv_transport_amount";
		public static final String IN_FINAL_AMOUNT_FIELD_NAME = "inv_amount";
		public static final String REGISTRY_FIELD_NAME = "inv_registry";
		public static final String IN_ITEM_FIELD_NAME = "inv_item";
		
		@Id
		@GeneratedValue	
		@Column(name = ID_FIELD_NAME)
		private Long id; 
		@Column(name = IN_HOLDER_FIELD_NAME)
		private String holder;
		@Column(name = ADDRESS_FIELD_NAME)
		private String address; 
		@Column(name = ZIP_CODE_FIELD_NAME)
		private String zipCode;
		@Column(name = CITY_FIELD_NAME)
		private String city;
		@Column(name = STATE_FIELD_NAME)
		private String state;
		@Column(name = PHONE_FIELD_NAME)
		private String phone; 
		@Column(name = VAT_NUMBER_FIELD_NAME)
		private String vatNumber;		
		@Column(name = IN_CLIENT_FIELD_NAME)
		private String client;
		@Column(name = CLIENT_ADDRESS_FIELD_NAME)
		private String addressClient;
		@Column(name = CLIENT_ZIP_CODE_FIELD_NAME)
		private String zipCodeClient;
		@Column(name = CLIENT_CITY_FIELD_NAME)
		private String cityClient;
		@Column(name = CLIENT_STATE_FIELD_NAME)
		private String stateClient;
		@Column(name = CLIENT_VAT_NUMBER_FIELD_NAME)
		private String vatNumClient;
		@Column(name = CLIENT_TAX_CODE_FIELD_NAME)
		private String taxCodeClient;
		@Column(name = IN_NUMBER_FIELD_NAME)
		private String number;
		@Column(name = IN_DATE_FIELD_NAME )
		private Date dateInv;
		@Column(name = BANK_FIELD_NAME)
		private String bank;
		@Column(name = CURRENCY_FIELD_NAME)
		private String currency;
		@Column(name = CONSIGNMENT_FIELD_NAME)
		private String consign;
		@Column(name = IN_PRODUCT_FIELD_NAME )
		private String nameProduct;
		@Column(name = TRANSPORT_AMOUNT_FIELD_NAME)
		private String transport;
		@Column(name = IN_FINAL_AMOUNT_FIELD_NAME)
		private String finalAmount;
		
		@OneToOne
		@JoinColumn(name = REGISTRY_FIELD_NAME)
		private Registry registry;
		
		@ForeignCollectionField
		private ForeignCollection<InvoiceItem> invoiceItem;
		
		public Invoice(){}
		
		public Invoice(String holder, String address, String zipCode, String city, String state, String phone,
				String vatNumber, String client, String addressClient, String zipCodeClient, String cityClient,
				String stateClient, String vatNumClient, String taxCodeClient, String number, Date dateInv, String bank,
				String currency, String consign, String nameProduct, String transport, String finalAmount) {
			this.holder = holder;
			this.address = address;
			this.zipCode = zipCode;
			this.city = city;
			this.state = state;
			this.phone = phone;
			this.vatNumber = vatNumber;
			this.client = client;
			this.addressClient = addressClient;
			this.zipCodeClient = zipCodeClient;
			this.cityClient = cityClient;
			this.stateClient = stateClient;
			this.vatNumClient = vatNumClient;
			this.taxCodeClient = taxCodeClient;
			this.number = number;
			this.dateInv = dateInv;
			this.bank = bank;
			this.currency = currency;
			this.consign = consign;
			this.nameProduct = nameProduct;
			this.transport = transport;
			this.finalAmount = finalAmount;
		}

		public String getHolder() {
			return holder;
		}

		public void setHolder(String holder) {
			this.holder = holder;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPhone() {
			return phone;
		}

		public Registry getRegistry() {
			return registry;
		}

		public void setRegistry(Registry registry) {
			this.registry = registry;
		}

		@XmlTransient
		public ForeignCollection<InvoiceItem> getInvoiceItem() {
			return invoiceItem;
		}

		public void setInvoiceItem(ForeignCollection<InvoiceItem> invoiceItem) {
			this.invoiceItem = invoiceItem;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getVatNumber() {
			return vatNumber;
		}

		public void setVatNumber(String vatNumber) {
			this.vatNumber = vatNumber;
		}

		public String getClient() {
			return client;
		}

		public void setClient(String client) {
			this.client = client;
		}

		public String getAddressClient() {
			return addressClient;
		}

		public void setAddressClient(String addressClient) {
			this.addressClient = addressClient;
		}

		public String getZipCodeClient() {
			return zipCodeClient;
		}

		public void setZipCodeClient(String zipCodeClient) {
			this.zipCodeClient = zipCodeClient;
		}

		public String getCityClient() {
			return cityClient;
		}

		public void setCityClient(String cityClient) {
			this.cityClient = cityClient;
		}

		public String getStateClient() {
			return stateClient;
		}

		public void setStateClient(String stateClient) {
			this.stateClient = stateClient;
		}

		public String getVatNumClient() {
			return vatNumClient;
		}

		public void setVatNumClient(String vatNumClient) {
			this.vatNumClient = vatNumClient;
		}

		public String getTaxCodeClient() {
			return taxCodeClient;
		}

		public void setTaxCodeClient(String taxCodeClient) {
			this.taxCodeClient = taxCodeClient;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public Date getDateInv() {
			return dateInv;
		}

		public void setDateInv(Date dateInv) {
			this.dateInv = dateInv;
		}

		public String getBank() {
			return bank;
		}

		public void setBank(String bank) {
			this.bank = bank;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getConsign() {
			return consign;
		}

		public void setConsign(String consign) {
			this.consign = consign;
		}

		public String getNameProduct() {
			return nameProduct;
		}

		public void setNameProduct(String nameProduct) {
			this.nameProduct = nameProduct;
		}


		public String getTransport() {
			return transport;
		}

		public void setTransport(String transport) {
			this.transport = transport;
		}

		public String getFinalAmount() {
			return finalAmount;
		}

		public void setFinalAmount(String finalAmount) {
			this.finalAmount = finalAmount;
		}

		@Override
		public Long getId() {
			// TODO Auto-generated method stub
			return null;
		}

}
