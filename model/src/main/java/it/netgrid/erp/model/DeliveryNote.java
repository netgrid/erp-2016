package it.netgrid.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "DeliveryNotes")
public class DeliveryNote {

	public static final String SEQUENTIAL_NUMBER_NAME = "dlv_sequential_number";
	public static final String DOCUMENT_DATE_NAME = "dlv_documet_date";
	public static final String PRODUCTS_AMOUNT_NAME = "dlv_products_amount";
	public static final String CUSTOMER_NAME = "dlv_customer";
	public static final String SELLER_NAME = "dlv_seller";
	public static final String REGISTRY_FIELD_NAME = "dlv_registry";

	@Id
	@GeneratedValue
	@Column(name = SEQUENTIAL_NUMBER_NAME)
	private int sequentialNumber;

	@Column(name = DOCUMENT_DATE_NAME)
	private Date documentDate;

	@Column(name = PRODUCTS_AMOUNT_NAME)
	private int productsAmount;

	@Column(name = CUSTOMER_NAME)
	private Registry customer;

	@Column(name = SELLER_NAME)
	private Registry seller;

	@OneToOne
	@JoinColumn(name = REGISTRY_FIELD_NAME)
	private Registry registry;

	public DeliveryNote() {
	}

	public DeliveryNote(int sequentialNumber, Date documentDate, int productsAmount, Registry customer,
			Registry seller) {
		this.sequentialNumber = sequentialNumber;
		this.documentDate = documentDate;
		this.productsAmount = productsAmount;
		this.customer = customer;
		this.seller = seller;
	}

	public int getSequentialNumber() {
		return sequentialNumber;
	}

	public void setSequentialNumber(int sequentialNumber) {
		this.sequentialNumber = sequentialNumber;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public int getProductsAmount() {
		return productsAmount;
	}

	public void setProductsAmount(int productsAmount) {
		this.productsAmount = productsAmount;
	}

	public Registry getCustomer() {
		return customer;
	}

	public void setCustomer(Registry customer) {
		this.customer = customer;
	}

	public Registry getSeller() {
		return seller;
	}

	public void setSeller(Registry seller) {
		this.seller = seller;
	}

}
