package it.netgrid.erp.rest.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import it.netgrid.erp.model.Bom;
import it.netgrid.erp.model.BomComponent;
import it.netgrid.erp.model.Component;
import it.netgrid.erp.model.Registry;
import it.netgrid.erp.model.dto.BomRoot;
import it.netgrid.erp.model.dto.RegistryRoot;
import it.netgrid.erp.rest.Erp2016TestEnv;
import it.netgrid.erp.rest.PersistenceTestHandler;

public class BomRootCrudServiceTest {

	@Rule
	public final GuiceBerryRule guiceBerry = new GuiceBerryRule(Erp2016TestEnv.class);

	@Inject
	private Fairy fairy;

	@Inject
	private PersistenceTestHandler persistence;

	@Inject
	private BomRootCrudService classUnderTest;

	@Inject
	private Dao<Bom, Long> BomDao;

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
	public void testCreateRawPersonalRegistry() throws SQLException {
		Bom bom = new Bom();
		Component component = new Component();
		List<Component> items = new ArrayList<Component>();

		BomRoot input = new BomRoot(bom, items);

		bom.setId(null);
		bom.setComponents(null);
		bom.setProduct(null);

		component.setDescription(null);
		component.setId(null);
		component.setParent(null);

		items.add(component);
		items.add(component);
		// expected.setName(fairy.person().firstName());

		this.classUnderTest.create(input);

		assertThat("created id is not null", input.getId(), not(equalTo(null)));

		Bom current = this.BomDao.queryForId(input.getId());
		assertThat("", bom.getComponents(), equalTo(current.getComponents()));
		assertThat("", bom.getId(), equalTo(current.getId()));
		assertThat("", bom.getProduct(), equalTo(current.getProduct()));

	}
}
