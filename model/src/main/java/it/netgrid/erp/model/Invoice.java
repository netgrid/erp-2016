package it.netgrid.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "invoices")
	public class Invoice {
		
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
		public static final String IN_NUMBER_FIELD_NAME = "inv_invoice_number";
		public static final String IN_DATE_FIELD_NAME = "inv_invoice_date";
		public static final String BANK_FIELD_NAME = "inv_invoice_bank";
		public static final String CURRENCY_FIELD_NAME = "inv_invoice_currency";
		public static final String CONSIGNMENT_FIELD_NAME= "inv_invoice_consignment";
		public static final String IN_PRODUCT_DESCRIPTION_FIELD_NAME = "inv_invoice_product_description";
		public static final String PRODUCT_QUANTITY_FIELD_NAME = "inv_invoice_product_quantity";
		public static final String PRODUCT_THICKNESS_FIELD_NAME = "inv_invoice_product_thickness";
		public static final String PRODUCT_DIMENSION_FIELD_NAME = "inv_invoice_product_dimension";
		public static final String PRODUCT_MEASURE_UNIT_FIELD_NAME = "inv_invoice_product_measure_unit";
		public static final String ONE_PRODUCT_PRICE_FIELD_NAME = "inv_invoice_one_product_price";
		public static final String PRODUCT_DISCOUNT_FIELD_NAME = "inv_invoice_product_discount";
		public static final String PRODUCT_AMOUNT_FIELD_NAME = "inv_invoice_product_amount";
		public static final String VAT_CODE_PRODUCT_FIELD_NAME = "inv_invoice_vat_code_product";
		public static final String TRANSPORT_AMOUNT_FIELD_NAME = "inv_invoice_transport_amount";
		public static final String IN_FINAL_AMOUNT_FIELD_NAME = "inv_invoice_amount";
		
		@Id
		@GeneratedValue	
		@Column(name = ID_FIELD_NAME)
		private long id; 
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
		@Column(name = IN_PRODUCT_DESCRIPTION_FIELD_NAME)
		private String description;
		@Column(name = PRODUCT_QUANTITY_FIELD_NAME)
		private String quantity;
		@Column(name = PRODUCT_THICKNESS_FIELD_NAME)
		private String thickness;
		@Column(name = PRODUCT_DIMENSION_FIELD_NAME)
		private String dimension;
		@Column(name = PRODUCT_MEASURE_UNIT_FIELD_NAME)
		private String measureUnit;
		@Column(name = ONE_PRODUCT_PRICE_FIELD_NAME)
		private String onePrice;	
		@Column(name = PRODUCT_DISCOUNT_FIELD_NAME)
		private String discount;	
		@Column(name = PRODUCT_AMOUNT_FIELD_NAME)
		private String amount;
		@Column(name = VAT_CODE_PRODUCT_FIELD_NAME)
		private String vatCodeProduct;
		@Column(name = TRANSPORT_AMOUNT_FIELD_NAME)
		private String transport;
		@Column(name = IN_FINAL_AMOUNT_FIELD_NAME)
		private String finalAmount;
}
