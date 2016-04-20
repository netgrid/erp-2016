package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="bom_component")
public class BomComponent {

	public static final String ID_NAME="bmc_id";
	public static final String BOM_ID_NAME = "bmc_bom_id";
	public static final String COMPONENT_ID_NAME = "bmc_com_id";
	
	@Id
	@GeneratedValue
	@Column(name=ID_NAME)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name=BOM_ID_NAME)
	private Bom bom;

	@ManyToOne
	@JoinColumn(name=COMPONENT_ID_NAME)
	private Component component;
	
	public BomComponent() {}
	
	public BomComponent(Bom bom, Component component) {
		this.bom = bom;
		this.component = component;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bom getBom() {
		return bom;
	}

	public void setBom(Bom bom) {
		this.bom = bom;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

}
