package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "invoiceitems")
public class InvoiceItem {
	
	public static final String ID_FIELD_NAME = "inv_id";
	public static final String IN_PRODUCT_FIELD_NAME = "inv_product_name";
	public static final String IN_PRODUCT_DESCRIPTION_FIELD_NAME = "inv_product_description";
	public static final String PRODUCT_QUANTITY_FIELD_NAME = "inv_invoice_product_quantity";
	public static final String PRODUCT_THICKNESS_FIELD_NAME = "inv_invoice_product_thickness";
	public static final String PRODUCT_DIMENSION_FIELD_NAME = "inv_invoice_product_dimension";
	public static final String PRODUCT_MEASURE_UNIT_FIELD_NAME = "inv_invoice_product_measure_unit";
	public static final String ONE_PRODUCT_PRICE_FIELD_NAME = "inv_invoice_one_product_price";
	public static final String PRODUCT_DISCOUNT_FIELD_NAME = "inv_invoice_product_discount";
	public static final String PRODUCT_AMOUNT_FIELD_NAME = "inv_invoice_product_amount";
	public static final String VAT_CODE_PRODUCT_FIELD_NAME = "inv_invoice_vat_code_product";
	
	@Id
	@GeneratedValue	
	@Column(name = ID_FIELD_NAME)
	private long id; 
	@Column(name = IN_PRODUCT_FIELD_NAME)
	private String product; 
	//List<Product>
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
	
	public InvoiceItem(){}

	public InvoiceItem(String product, String description, String quantity, String thickness, String dimension,
			String measureUnit, String onePrice, String discount, String amount, String vatCodeProduct) {
		this.product = product;
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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
