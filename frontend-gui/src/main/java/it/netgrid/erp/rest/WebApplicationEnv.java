package it.netgrid.erp.rest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class WebApplicationEnv extends GuiceServletContextListener {
	
	@Override
	protected Injector getInjector() {
		Injector injector = Guice.createInjector(
				new BootstrapServletModule(),
				new SessionHandlingModule());
		return injector;
	}

}
