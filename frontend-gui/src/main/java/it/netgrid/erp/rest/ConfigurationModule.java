package it.netgrid.erp.rest;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import it.netgrid.erp.model.Configuration;
import it.netgrid.erp.utils.PropertiesConfigurationImpl;

public class ConfigurationModule extends AbstractModule {

	@Override
	protected void configure() {
	
	}
	
	@Provides
	@Singleton
	public Configuration getConfiguration() {
		return new PropertiesConfigurationImpl();
	}

}
