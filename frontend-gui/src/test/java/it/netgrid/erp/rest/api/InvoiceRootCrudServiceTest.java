package it.netgrid.erp.rest.api;


import java.sql.SQLException;

import org.junit.Rule;
import org.junit.Test;

import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;

import io.codearte.jfairy.Fairy;
import it.netgrid.erp.model.Invoice;
import it.netgrid.erp.model.Registry;
import it.netgrid.erp.model.dto.InvoiceRoot;
import it.netgrid.erp.rest.Erp2016TestEnv;

public class InvoiceRootCrudServiceTest {
	@Rule
	public final GuiceBerryRule guiceBerry = new GuiceBerryRule(Erp2016TestEnv.class);

	@Inject
	private Fairy fairy;
	
	@Inject
	private InvoiceRootCrudService classUnderTest;
	
	@Inject
	private Dao<Registry, Long> registryDao;
	
	@Test
	public void testCreateRawInvoice() throws SQLException {

		

	}
}
