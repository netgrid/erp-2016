package it.netgrid.erp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	private long id; 
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
	
	@OneToOne
	@JoinColumn(name = INVOICE_FIELD_NAME)
	private Invoice invoice;
	@JoinColumn(name = PRODUCT_FIELD_NAME)
	private List<Product> product;
	
	public InvoiceItem(){}

	public InvoiceItem(String description, String quantity, String thickness, String dimension,
			String measureUnit, String onePrice, String discount, String amount, String vatCodeProduct) {
		
		this.description = description;
		this.quantity = quantity;
		this.thickness = thickness;
		this.dimension = dimension;
		this.measureUnit = measureUnit;
		this.onePrice = onePrice;
		this.discount = discount;
		this.amount = amount;
		this.vatCodeProduct = vatCodeProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getOnePrice() {
		return onePrice;
	}

	public void setOnePrice(String onePrice) {
		this.onePrice = onePrice;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getVatCodeProduct() {
		return vatCodeProduct;
	}

	public void setVatCodeProduct(String vatCodeProduct) {
		this.vatCodeProduct = vatCodeProduct;
	}
	
}
