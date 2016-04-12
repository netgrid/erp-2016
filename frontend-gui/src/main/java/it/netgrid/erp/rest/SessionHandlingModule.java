package it.netgrid.erp.rest;

import com.google.inject.AbstractModule;

public class SessionHandlingModule extends AbstractModule {

	@Override
	protected void configure() {
//		bind(SessionProvider.class).to(ShiroSessionProvider.class);
//		bind(SessionDAO.class).to(ShiroJdbcSessionDao.class);
	}

}
