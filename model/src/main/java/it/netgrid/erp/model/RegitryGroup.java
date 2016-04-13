package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="registry_group")
public class RegitryGroup {
	public static final String ID_FIELD_NAME = "reg_group_id";
	public static final String NAME_ID_FIELD_NAME = "reg_group_registry_id";
	public static final String REGISTRY_GROUP_PIVOT_FIELD_NAME = "reg_group_registry_pivot";
	public static final String HIDDEN_FIELD_NAME = "reg_group_hidden";
	
	
	@Id
	@GeneratedValue
	@Column(name=ID_FIELD_NAME)
	private long id;
	
	@Column(name=NAME_ID_FIELD_NAME)
	private long name;
	
	@Column(name=REGISTRY_GROUP_PIVOT_FIELD_NAME)
	private long registryGroupPivotId;
	
	@Column(name=HIDDEN_FIELD_NAME)
	private boolean hidden;
	
	public RegitryGroup(){
	
	}
	
	
	
	public RegitryGroup(long id, long name, long registryGroupPivotId, boolean hidden){
		this.id=id;
		this.name=name;
		this.registryGroupPivotId=registryGroupPivotId;
		this.hidden=hidden;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getName() {
		return name;
	}



	public void setName(long name) {
		this.name = name;
	}


	public long getRegistryGroupPivotId() {
		return registryGroupPivotId;
	}



	public void setRegistryGroupPivotId(long registryGroupPivotId) {
		this.registryGroupPivotId = registryGroupPivotId;
	}



	public boolean isHidden() {
		return hidden;
	}



	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	
}
