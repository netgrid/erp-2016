package it.netgrid.erp.rest.api;


import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;

import io.codearte.jfairy.Fairy;
import it.netgrid.erp.model.Order;
import it.netgrid.erp.rest.Erp2016TestEnv;
import it.netgrid.erp.rest.PersistenceTestHandler;

public class OrderRootCrudService {

	
	@Rule
	public final GuiceBerryRule guiceBerry = new GuiceBerryRule(Erp2016TestEnv.class);

	@Inject
	private Fairy fairy;
	
	@Inject
	private PersistenceTestHandler persistence;
	
	@Inject
	private OrderRootCrudService classUnderTest;
	
	@Inject
	private Dao<Order, Long> registryDao;
	
	@Before
	public void setUp() {
		persistence.setup();
		persistence.loadData();
	}
	
	@After
	public void tearDown() {
		persistence.destroy();
	}
	
	@Test
	public void testCreateOrder() throws SQLException {
		
	}
	
	
	
}
