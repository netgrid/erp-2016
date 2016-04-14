package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;

@Entity(name="registry_group")
public class RegistryGroup {
	public static final String ID_FIELD_NAME = "rgg_id";
	public static final String NAME_ID_FIELD_NAME = "rgg_registry_id";
	public static final String REGISTRY_GROUP_PIVOT_FIELD_NAME = "rgg_registry_pivot";
	public static final String HIDDEN_FIELD_NAME = "rgg_hidden";
	
	
	@Id
	@GeneratedValue
	@Column(name=ID_FIELD_NAME)
	private Long id;
	
	@Column(name=NAME_ID_FIELD_NAME)
	private String name;
	
	@ForeignCollectionField
	private ForeignCollection<RegistryGroupPivot> members; 
	
	@Column(name=HIDDEN_FIELD_NAME)
	private boolean hidden;
	
	public RegistryGroup(){
	
	}
	
	
	
	public RegistryGroup(long id, String name, ForeignCollection<RegistryGroupPivot> members, boolean hidden){
		this.id=id;
		this.name=name;
		this.members=members;
		this.hidden=hidden;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ForeignCollection<RegistryGroupPivot> getMembers() {
		return members;
	}



	public void setMembers(ForeignCollection<RegistryGroupPivot> members) {
		this.members = members;
	}



	public boolean isHidden() {
		return hidden;
	}



	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	
}
