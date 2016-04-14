package it.netgrid.erp.rest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import it.netgrid.erp.model.DaoModule;

public class WebApplicationEnv extends GuiceServletContextListener {
	
	@Override
	protected Injector getInjector() {
		Injector injector = Guice.createInjector(
				new BootstrapServletModule(),
				new SessionHandlingModule(),
				new ConfigurationModule(),
				new DaoModule());
		
		return injector;
	}

}
