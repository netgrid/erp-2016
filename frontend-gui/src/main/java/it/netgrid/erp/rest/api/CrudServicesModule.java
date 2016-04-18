package it.netgrid.erp.rest.api;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;

import it.netgrid.erp.model.Registry;
import it.netgrid.erp.model.RegistryGroup;
import it.netgrid.erp.model.RegistryGroupPivot;
import it.netgrid.erp.model.dto.RegistryRoot;

public class CrudServicesModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(new TypeLiteral<CrudService<Registry, Long>>() {}).to(new TypeLiteral<DaoProxyCrudService<Registry, Long>>() {}).in(Singleton.class);
		bind(new TypeLiteral<CrudService<RegistryGroup, Long>>() {}).to(new TypeLiteral<DaoProxyCrudService<RegistryGroup, Long>>() {}).in(Singleton.class);
		bind(new TypeLiteral<CrudService<RegistryGroupPivot, Long>>() {}).to(new TypeLiteral<DaoProxyCrudService<RegistryGroupPivot, Long>>() {}).in(Singleton.class);
	
		bind(new TypeLiteral<CrudService<RegistryRoot, Long>>() {}).to(new TypeLiteral<RegistryRootCrudService>(){}).in(Singleton.class);
	}
}
