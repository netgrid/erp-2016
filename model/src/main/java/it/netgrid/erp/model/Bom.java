package it.netgrid.erp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="bom")
public class Bom {
	
	public static final String ID_PRODUCT_NAME="bom_id_product";
	public static final String ID_COMPONENT_NAME="bom_id_Component";
	
	@Id
	@OneToOne
	@JoinColumn(name=ID_PRODUCT_NAME)
	private long idProduct;
	
	@Id
	@OneToOne
	@JoinColumn(name=ID_COMPONENT_NAME)
	private long idComponent;
	
	

	
	public Bom(){	
	}
	
	public Bom(long idProduct, long idComponent){	
		this.idComponent = idComponent;
		this.idProduct = idProduct;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public long getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}

	
	
}
