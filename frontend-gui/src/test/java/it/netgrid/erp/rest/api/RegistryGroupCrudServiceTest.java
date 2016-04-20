package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;

import io.codearte.jfairy.Fairy;
import it.netgrid.erp.model.RegistryGroup;
import it.netgrid.erp.rest.Erp2016TestEnv;
import it.netgrid.erp.rest.PersistenceTestHandler;

public class RegistryGroupCrudServiceTest {
	
	@Rule
	public final GuiceBerryRule guiceBerry = new GuiceBerryRule(Erp2016TestEnv.class);

	@Inject
	private Fairy fairy;
	
	@Inject
	private PersistenceTestHandler persistence;
	
	@Inject
	private RegistryGroupCrudService classUnderTest;
	
	@Inject
	private Dao<RegistryGroup, Long> registryGroupDao;
	
	@Before
	public void setUp() {
		persistence.setup();
		persistence.loadData();
	}
	
	@After
	public void tearDown() {
		persistence.destroy();
	}
	
	@Test(expected=SQLException.class)
	public void testDeleteNonEmptyGroup() throws SQLException {
		long groupId = 1;
		RegistryGroup group = this.registryGroupDao.queryForId(groupId);
		this.classUnderTest.delete(group);
	}
	
	@Test
	public void testDeleteEmptyGroup() throws SQLException {
		RegistryGroup group = new RegistryGroup();
		group.setHidden(fairy.baseProducer().trueOrFalse());
		group.setName(fairy.textProducer().word());
		this.registryGroupDao.create(group);
		
		this.classUnderTest.delete(group);
		
		RegistryGroup result = this.registryGroupDao.queryForId(group.getId());
		assertThat("object has been deleted", result, equalTo(null));
	}
}
