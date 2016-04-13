package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="component")
public class Component {
	
	public static final String COMPONENT_NAME="com_component";
	public static final String ID_COMPONENT_NAME="com_id_Component";
	
	@Id
	@GeneratedValue
	@Column(name=ID_COMPONENT_NAME)
	private long idComponent;
	
	@Column(name=COMPONENT_NAME)
	private String component;
	
	
	
	
	public Component(){
		
	}
	
	public Component(long id,String nome){
		this.idComponent = id;
		this.component = nome;
	}

	public long getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}

	public String getCompnent() {
		return component;
	}

	public void setCompnent(String compnent) {
		component = compnent;
	}
	
}
