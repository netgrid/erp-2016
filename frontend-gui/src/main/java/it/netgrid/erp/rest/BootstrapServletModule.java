package it.netgrid.erp.rest;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.guice.web.GuiceShiroFilter;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;

import com.google.inject.Scopes;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class BootstrapServletModule extends JerseyServletModule {

	private static final String RESOURCES_PACKAGE = "it/netgrid/erp/rest/resources";
	
	@Override
	protected void configureServlets() {
		super.configureServlets();
		
		install(new BootstrapInMemoryShiroModule(getServletContext()));
		install(new ShiroAnnotationsModule());

		Map<String, String> params = new HashMap<String, String>();
        params.put(PackagesResourceConfig.PROPERTY_PACKAGES, RESOURCES_PACKAGE);
        
        filter("/*").through(GuiceShiroFilter.class);
        serve("/*").with(GuiceContainer.class, params);
	}
}
