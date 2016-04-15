package it.netgrid.erp.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "invoice_items")
public class InvoiceItem {
	
	public static final String ID_FIELD_NAME = "ini_id";
	public static final String IN_PRODUCT_DESCRIPTION_FIELD_NAME = "ini_product_description";
	public static final String PRODUCT_QUANTITY_FIELD_NAME = "ini_product_quantity";
	public static final String PRODUCT_THICKNESS_FIELD_NAME = "ini_product_thickness";
	public static final String PRODUCT_DIMENSION_FIELD_NAME = "ini_product_dimension";
	public static final String PRODUCT_MEASURE_UNIT_FIELD_NAME = "ini_product_measure_unit";
	public static final String ONE_PRODUCT_PRICE_FIELD_NAME = "ini_one_product_price";
	public static final String PRODUCT_DISCOUNT_FIELD_NAME = "ini_product_discount";
	public static final String PRODUCT_AMOUNT_FIELD_NAME = "ini_product_amount";
	public static final String VAT_CODE_PRODUCT_FIELD_NAME = "ini_vat_code_product";
	public static final String INVOICE_FIELD_NAME = "ini_invoice";
	public static final String PRODUCT_FIELD_NAME = "ini_product_name";
	
	@Id
	@GeneratedValue	
	@Column(name = ID_FIELD_NAME)
	private Long id; 
	@Column(name = IN_PRODUCT_DESCRIPTION_FIELD_NAME)
	private String description;
	@Column(name = PRODUCT_QUANTITY_FIELD_NAME)
	private BigDecimal quantity;
	@Column(name = PRODUCT_THICKNESS_FIELD_NAME)
	private BigDecimal thickness;
	@Column(name = PRODUCT_DIMENSION_FIELD_NAME)
	private BigDecimal dimension;
	@Column(name = PRODUCT_MEASURE_UNIT_FIELD_NAME)
	private String measureUnit;
	@Column(name = ONE_PRODUCT_PRICE_FIELD_NAME)
	private BigDecimal onePrice;	
	@Column(name = PRODUCT_DISCOUNT_FIELD_NAME)
	private BigDecimal discount;	
	@Column(name = PRODUCT_AMOUNT_FIELD_NAME)
	private BigDecimal amount;
	@Column(name = VAT_CODE_PRODUCT_FIELD_NAME)
	private String vatCodeProduct;
	
	@OneToOne
	@JoinColumn(name = INVOICE_FIELD_NAME)
	private Invoice invoice;
	
	@Column(name = PRODUCT_FIELD_NAME)
	private String product;
	
	public InvoiceItem(){}

	public InvoiceItem(String description, BigDecimal quantity, BigDecimal thickness, BigDecimal dimension,
			String measureUnit, BigDecimal onePrice, BigDecimal discount, BigDecimal amount, String vatCodeProduct) {
		
		this.description = description;
		this.measureUnit = measureUnit;
		this.vatCodeProduct = vatCodeProduct;
		this.thickness = thickness;
		this.quantity = quantity;
		this.dimension =dimension;
		this.onePrice = onePrice;
		this.discount = discount;
		this.amount = amount;
		this.amount = this.onePrice.multiply(this.quantity);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getVatCodeProduct() {
		return vatCodeProduct;
	}

	public void setVatCodeProduct(String vatCodeProduct) {
		this.vatCodeProduct = vatCodeProduct;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getThickness() {
		return thickness;
	}

	public void setThickness(BigDecimal thickness) {
		this.thickness = thickness;
	}

	public BigDecimal getDimension() {
		return dimension;
	}

	public void setDimension(BigDecimal dimension) {
		this.dimension = dimension;
	}

	public BigDecimal getOnePrice() {
		return onePrice;
	}

	public void setOnePrice(BigDecimal onePrice) {
		this.onePrice = onePrice;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
}
