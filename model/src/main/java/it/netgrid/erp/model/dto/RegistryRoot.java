package it.netgrid.erp.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.Registry;
import it.netgrid.erp.model.RegistryGroup;

@XmlRootElement
public class RegistryRoot implements CrudObject<Long> {

	private Registry registry;
	
	private List<RegistryGroup> groups;
	
	public RegistryRoot() {}
	
	public RegistryRoot(Registry registry) {
		this.registry = registry;
		this.groups = new ArrayList<RegistryGroup>();
	}

	public Registry getRegistry() {
		return registry;
	}

	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	public List<RegistryGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<RegistryGroup> groups) {
		this.groups = groups;
	}

	@Override
	public Long getId() {
		return this.registry == null ? null : this.registry.getId();
	}
	
}
