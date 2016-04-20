package it.netgrid.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "delivery_notes")
public class DeliveryNote {

	public static final String ID_NAME = "dlv_id";
	public static final String SEQUENTIAL_NUMBER_NAME = "dlv_sequential_number";
	public static final String DOCUMENT_DATE_NAME = "dlv_documet_date";
	public static final String PRODUCTS_AMOUNT_NAME = "dlv_products_amount";
	public static final String RECEIVER_ID_NAME = "dlv_receiver_id";
	public static final String SENDER_ID_NAME = "dlv_sender_id";
	public static final String REGISTRY_FIELD_NAME = "dlv_registry";
	public static final String ORDER_ITEM_ID_NAME = "dlv_oit_id";

	@Id
	@GeneratedValue
	@Column(name = ID_NAME)	
	private Long id;
	
	@Column(name = SEQUENTIAL_NUMBER_NAME)
	private Integer sequentialNumber;

	@Column(name = DOCUMENT_DATE_NAME)
	private Date documentDate;

	@Column(name = PRODUCTS_AMOUNT_NAME)
	private Integer productsAmount;

	@OneToOne
	@JoinColumn(name = RECEIVER_ID_NAME)
	private Registry receiver;

	@OneToOne
	@JoinColumn(name = SENDER_ID_NAME)
	private Registry sender;

	@OneToOne
	@JoinColumn(name = ORDER_ITEM_ID_NAME)
	private OrderItem orderItem;

	public DeliveryNote() {
	}

	public DeliveryNote(Integer sequentialNumber, Date documentDate, Integer productsAmount, Registry sender, Registry receiver) {
		this.sequentialNumber = sequentialNumber;
		this.documentDate = documentDate;
		this.productsAmount = productsAmount;
		this.receiver = receiver;
		this.sender = sender;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSequentialNumber() {
		return sequentialNumber;
	}

	public void setSequentialNumber(Integer sequentialNumber) {
		this.sequentialNumber = sequentialNumber;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public Integer getProductsAmount() {
		return productsAmount;
	}

	public void setProductsAmount(Integer productsAmount) {
		this.productsAmount = productsAmount;
	}

	public Registry getReceiver() {
		return receiver;
	}

	public void setReceiver(Registry receiver) {
		this.receiver = receiver;
	}

	public Registry getSender() {
		return sender;
	}

	public void setSender(Registry sender) {
		this.sender = sender;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

}
