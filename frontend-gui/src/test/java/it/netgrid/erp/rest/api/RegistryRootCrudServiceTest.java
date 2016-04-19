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
import com.j256.ormlite.stmt.QueryBuilder;

import io.codearte.jfairy.Fairy;
import it.netgrid.erp.model.Registry;
import it.netgrid.erp.model.RegistryGroup;
import it.netgrid.erp.model.RegistryGroupPivot;
import it.netgrid.erp.model.dto.RegistryRoot;
import it.netgrid.erp.rest.Erp2016TestEnv;
import it.netgrid.erp.rest.PersistenceTestHandler;

public class RegistryRootCrudServiceTest {
	
	@Rule
	public final GuiceBerryRule guiceBerry = new GuiceBerryRule(Erp2016TestEnv.class);

	@Inject
	private Fairy fairy;
	
	@Inject
	private PersistenceTestHandler persistence;
	
	@Inject
	private RegistryRootCrudService classUnderTest;
	
	@Inject
	private Dao<Registry, Long> registryDao;
	
	@Inject
	private Dao<RegistryGroupPivot, Long> registryGroupPivotDao;
	
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
	public void testReadRegistryRoot() throws SQLException {
		// Definisco quale registry andare a leggere
		long registryId = 1;
		
		// Recupero gli id dei gruppi per questo registry
		QueryBuilder<RegistryGroupPivot, Long> query = this.registryGroupPivotDao.queryBuilder();
		query.where().eq(RegistryGroupPivot.REGISTRY_FIELD_NAME, registryId);
		List<Long> groupIds = new ArrayList<Long>();
		for(RegistryGroupPivot pivot : query.query()) {
			groupIds.add(pivot.getRegistryGroup().getId());
		}
		
		// Eseguo il metodo da testare
		RegistryRoot result = this.classUnderTest.read(registryId);
		
		// Verifico la presenza dei dati di registry
		assertThat("have same id", registryId, equalTo(result.getId()));
		
		// Verifico la presenza dei gruppi
		assertThat("have same group count", groupIds.size(), equalTo(result.getGroups().size()));
		for(RegistryGroup group : result.getGroups()) {
			assertThat("group is present", groupIds.contains(group.getId()), equalTo(true));
		}
	}
	
	@Test
	public void testCreateRawPersonalRegistry() throws SQLException {
		
		Registry expected = new Registry();
		RegistryRoot input = new RegistryRoot(expected);
		expected.setAddressCity(fairy.person().getAddress().getCity());
		expected.setAddressCountry(fairy.person().getAddress().getCity());
		expected.setAddressNum(fairy.person().getAddress().streetNumber());
		expected.setAddressRoad(fairy.person().getAddress().street());
		expected.setAddressZip(fairy.person().getAddress().getPostalCode());
		expected.setMailAddress(fairy.person().email());
		expected.setName(fairy.person().firstName());
		expected.setPhoneNumber(fairy.person().telephoneNumber());
		expected.setPrivateBirthDate(fairy.person().dateOfBirth().toDate());
		expected.setPrivateSurname(fairy.person().lastName());
		
		this.classUnderTest.create(input);
		
		assertThat("created id is not null", input.getId(), not(equalTo(null)));
		
		Registry current = this.registryDao.queryForId(input.getId());
		assertThat("current is not null", current, not(equalTo(null)));
		assertThat("address city are equal", expected.getAddressCity(), equalTo(current.getAddressCity()));
		assertThat("", expected.getAddressCountry(), equalTo(current.getAddressCountry()));
		assertThat("", expected.getAddressNum(), equalTo(current.getAddressNum()));
		assertThat("", expected.getAddressRoad(), equalTo(current.getAddressRoad()));
		assertThat("", expected.getAddressZip(), equalTo(current.getAddressZip()));
		assertThat("", expected.getId(), equalTo(current.getId()));
		assertThat("", expected.getMailAddress(), equalTo(current.getMailAddress()));
		assertThat("", expected.getName(), equalTo(current.getName()));
		assertThat("", expected.getPhoneNumber(), equalTo(current.getPhoneNumber()));
		assertThat("", expected.getPrivateBirthDate(), equalTo(current.getPrivateBirthDate()));
		assertThat("", expected.getPrivateSurname(), equalTo(current.getPrivateSurname()));

	}
}
