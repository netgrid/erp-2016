package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="registry_group_pivots")
public class RegistryGroupPivot {
	public static final String ID_FIELD_NAME = "rgp_id";
	public static final String REGISTRY_ID_FIELD_NAME = "rgp_registry_id";
	public static final String REGISTRY_GROUP_ID_FIELD_NAME = "rgp_registry_group_id";
	
	
	@Id
	@GeneratedValue
	@Column(name=ID_FIELD_NAME)
	private long id;
	
	@Column(name=REGISTRY_ID_FIELD_NAME)
	private long registry_id;
	
	@Column(name=REGISTRY_GROUP_ID_FIELD_NAME)
	private long registry_group_id;
	
	
	
	public RegistryGroupPivot(){};
	
	public RegistryGroupPivot(long id, long registry_id, long registry_group_id){
		this.id=id;
		this.registry_id=registry_id;
		this.registry_group_id=registry_group_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRegistry_id() {
		return registry_id;
	}

	public void setRegistry_id(long registry_id) {
		this.registry_id = registry_id;
	}

	public long getRegistry_group_id() {
		return registry_group_id;
	}

	public void setRegistry_group_id(long registry_group_id) {
		this.registry_group_id = registry_group_id;
	};
	
	
	
	
}
