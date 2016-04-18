package it.netgrid.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="registry_group_pivots")
public class RegistryGroupPivot implements CrudObject<Long> {
	public static final String ID_FIELD_NAME = "rgp_id";
	public static final String REGISTRY_FIELD_NAME = "rgp_registry";
	public static final String REGISTRY_GROUP_FIELD_NAME = "rgp_registry_group";
	
	
	@Id
	@GeneratedValue
	@Column(name=ID_FIELD_NAME)
	private Long id;

	@OneToOne
	@JoinColumn(name=REGISTRY_FIELD_NAME)
	private Registry registry;
	
	@OneToOne
	@JoinColumn(name=REGISTRY_GROUP_FIELD_NAME)
	private RegistryGroup registryGroup;
	
	
	
	public RegistryGroupPivot(){};
	
	public RegistryGroupPivot(Registry registry, RegistryGroup registryGroup) {
		this.registry=registry;
		this.registryGroup=registryGroup;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Registry getRegistry() {
		return registry;
	}

	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	public RegistryGroup getRegistryGroup() {
		return registryGroup;
	}

	public void setRegistryGroup(RegistryGroup registryGroup) {
		this.registryGroup = registryGroup;
	}

}
