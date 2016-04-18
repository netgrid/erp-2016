package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
@XmlRootElement
@Entity(name="bom")
public class Bom {

	public static final String ID_NAME="bom_id";
	public static final String PRODUCT_NAME="bom_id_product";
	
	@Id
	@GeneratedValue
	@Column(name=ID_NAME)
	private Long id;
	
	@Column(name=PRODUCT_NAME)
	private String product;
	
	@ForeignCollectionField
	private ForeignCollection<BomComponent> components;
	
	public Bom(){	
	}
	
	public Bom(String product, Long id){	
		this.id = id;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public ForeignCollection<BomComponent> getComponents() {
		return components;
	}

	public void setComponents(ForeignCollection<BomComponent> components) {
		this.components = components;
	}

}
