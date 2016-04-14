package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="components")
public class Component {
	
	public static final String PARENT_ID_NAME="com_parent_id";
	public static final String ID_NAME="com_id_Component";
	public static final String DESCRIPTION_NAME = "com_description";
	
	@Id
	@GeneratedValue
	@Column(name=ID_NAME)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name=PARENT_ID_NAME)
	private Component parent;
	
	@Column(name=DESCRIPTION_NAME)
	private String description;
	
	public Component(){}
	
	public Component(Component parent, String description){
		this.parent = parent;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Component getParent() {
		return parent;
	}

	public void setParent(Component parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
