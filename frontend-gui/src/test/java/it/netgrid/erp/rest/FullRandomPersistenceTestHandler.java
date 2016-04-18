package it.netgrid.erp.rest;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

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
	
	
	@Inject
	public FullRandomPersistenceTestHandler(ConnectionSource connectionSource) {
		this.connectionSource = connectionSource;
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
		// NOTHING TO-DO
	}

}
