package it.netgrid.erp.rest;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.guice.web.GuiceShiroFilter;

import com.sun.jersey.api.core.*;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class BootstrapServletModule extends JerseyServletModule {

	private static final String RESOURCES_PACKAGE = "it/netgrid/erp/rest/resources";
	private static final String CLASSNAMES = "it.netgrid.erp.rest.CorsResponseFilter";
	
	@Override
	protected void configureServlets() {
		super.configureServlets();
		
		install(new BootstrapInMemoryShiroModule(getServletContext()));
		install(new ShiroAnnotationsModule());

		Map<String, String> params = new HashMap<String, String>();
        params.put(PackagesResourceConfig.PROPERTY_PACKAGES, RESOURCES_PACKAGE);
        params.put(ClassNamesResourceConfig.PROPERTY_CLASSNAMES, CLASSNAMES);
        
        filter("/*").through(CORSServletFilter.class);
        filter("/*").through(GuiceShiroFilter.class);
        serve("/*").with(GuiceContainer.class, params);
	}
}