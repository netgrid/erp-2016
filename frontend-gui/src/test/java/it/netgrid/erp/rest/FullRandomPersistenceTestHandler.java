package it.netgrid.erp.rest;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import io.codearte.jfairy.Fairy;
import it.netgrid.erp.model.Bom;
import it.netgrid.erp.model.BomComponent;
import it.netgrid.erp.model.Component;
import it.netgrid.erp.model.DeliveryNote;
import it.netgrid.erp.model.Invoice;
import it.netgrid.erp.model.InvoiceItem;
import it.netgrid.erp.model.Order;
import it.netgrid.erp.model.OrderItem;
import it.netgrid.erp.model.Product;
import it.netgrid.erp.model.Registry;
import it.netgrid.erp.model.RegistryGroup;
import it.netgrid.erp.model.RegistryGroupPivot;
import it.netgrid.erp.model.User;

public class FullRandomPersistenceTestHandler implements PersistenceTestHandler {

	private static final Logger log = LoggerFactory.getLogger(FullRandomPersistenceTestHandler.class);
	private final ConnectionSource connectionSource;
	

	private final Dao<Registry, Long> registryDao;
	private final Dao<RegistryGroup, Long> registryGroupDao;
	private final Dao<RegistryGroupPivot, Long> registryGroupPivotDao;
	
	
	@Inject
	public FullRandomPersistenceTestHandler(ConnectionSource connectionSource, 
			Dao<RegistryGroup, Long> registryGroupDao,
			Dao<Registry, Long> registryDao,
			Dao<RegistryGroupPivot, Long> registryGroupPivotDao) {
		this.connectionSource = connectionSource;
		this.registryGroupDao = registryGroupDao;
		this.registryDao = registryDao;
		this.registryGroupPivotDao = registryGroupPivotDao;
	}
	
	@Override
	public void setup() {
		try{
			TableUtils.createTableIfNotExists(connectionSource, Registry.class);
			TableUtils.createTableIfNotExists(connectionSource, RegistryGroup.class);
			TableUtils.createTableIfNotExists(connectionSource, RegistryGroupPivot.class);
			TableUtils.createTableIfNotExists(connectionSource, Bom.class);
			TableUtils.createTableIfNotExists(connectionSource, BomComponent.class);
			TableUtils.createTableIfNotExists(connectionSource, Component.class);
			TableUtils.createTableIfNotExists(connectionSource, Invoice.class);
			TableUtils.createTableIfNotExists(connectionSource, InvoiceItem.class);
			TableUtils.createTableIfNotExists(connectionSource, Order.class);
			TableUtils.createTableIfNotExists(connectionSource, User.class);
			TableUtils.createTableIfNotExists(connectionSource, OrderItem.class);
			TableUtils.createTableIfNotExists(connectionSource, DeliveryNote.class);
			TableUtils.createTableIfNotExists(connectionSource, Product.class);
		} catch (SQLException e) {
			log.warn("SQL errors during DB creation");
			log.debug("SQL errors during DB creation:",e);
		}
	}

	@Override
	public void destroy() {
		try {
			TableUtils.dropTable(connectionSource, Registry.class, true);
			TableUtils.dropTable(connectionSource, RegistryGroup.class, true);
			TableUtils.dropTable(connectionSource, RegistryGroupPivot.class, true);
			TableUtils.dropTable(connectionSource, Bom.class, true);
			TableUtils.dropTable(connectionSource, BomComponent.class, true);
			TableUtils.dropTable(connectionSource, Component.class, true);
			TableUtils.dropTable(connectionSource, Invoice.class, true);
			TableUtils.dropTable(connectionSource, InvoiceItem.class, true);
			TableUtils.dropTable(connectionSource, Order.class, true);
			TableUtils.dropTable(connectionSource, User.class, true);
			TableUtils.dropTable(connectionSource, OrderItem.class, true);
			TableUtils.dropTable(connectionSource, DeliveryNote.class, true);
			TableUtils.dropTable(connectionSource, Product.class, true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadData() {
		Fairy fairy = Fairy.create();
		try {
			this.createRegistryGroups(fairy);
			for(int i=0; i<fairy.baseProducer().randomBetween(3, 10); i++) {
				this.createRegistry(fairy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void createRegistry(Fairy fairy) throws SQLException {
		char type = fairy.baseProducer().trueOrFalse() ? Registry.COMPANY : Registry.PRIVATE;
		
		Registry registry = new Registry();
		registry.setAddressCity(fairy.person().getAddress().getCity());
		registry.setAddressCountry(fairy.person().getAddress().getCity());
		registry.setAddressNum(fairy.person().getAddress().streetNumber());
		registry.setAddressRoad(fairy.person().getAddress().street());
		registry.setAddressZip(fairy.person().getAddress().getPostalCode());
		registry.setMailAddress(fairy.person().email());
		registry.setName(fairy.person().firstName());
		registry.setPhoneNumber(fairy.person().telephoneNumber());
		registry.setPrivateBirthDate(fairy.person().dateOfBirth().toDate());
		registry.setPrivateSurname(fairy.person().lastName());
		registry.setType(type);
		
		this.registryDao.create(registry);
		
		long baseGroup = fairy.baseProducer().trueOrFalse() ? 1 : 2;
		RegistryGroup group = this.registryGroupDao.queryForId(baseGroup);
		RegistryGroupPivot pivot = new RegistryGroupPivot(registry, group);
		this.registryGroupPivotDao.create(pivot);
	}

	private void createRegistryGroups(Fairy fairy) throws SQLException {
		RegistryGroup group = new RegistryGroup();
		group.setHidden(true);
		group.setName("customers");
		this.registryGroupDao.create(group);
		group = new RegistryGroup();
		group.setHidden(true);
		group.setName("providers");
		this.registryGroupDao.create(group);

		int count = fairy.baseProducer().randomBetween(0, 5);
		for(int i=0; i<count; i++) {
			group = new RegistryGroup();
			group.setHidden(false);
			group.setName(fairy.textProducer().word());
			this.registryGroupDao.create(group);
		}
	}
}
