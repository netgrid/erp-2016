package it.netgrid.erp.model;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DaoModule extends AbstractModule {

	private static final Logger log = LoggerFactory.getLogger(DaoModule.class);
	
	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	@Provides
	@Singleton
	public ConnectionSource getConnection(Configuration configuration) throws SQLException {
		JdbcPooledConnectionSource retval = new JdbcPooledConnectionSource(configuration.getJdbcConnectionUrl(), configuration.getJdbcUsername(), configuration.getJdbcPassword());		
		try {
			TableUtils.createTableIfNotExists(retval, Registry.class);
			TableUtils.createTableIfNotExists(retval, RegistryGroup.class);
			TableUtils.createTableIfNotExists(retval, RegistryGroupPivot.class);
			TableUtils.createTableIfNotExists(retval, Bom.class);
			TableUtils.createTableIfNotExists(retval, Component.class);
			TableUtils.createTableIfNotExists(retval, Invoice.class);
			TableUtils.createTableIfNotExists(retval, InvoiceItem.class);
			TableUtils.createTableIfNotExists(retval, Order.class);
			TableUtils.createTableIfNotExists(retval, User.class);
			TableUtils.createTableIfNotExists(retval, OrderItem.class);
			TableUtils.createTableIfNotExists(retval, DeliveryNote.class);
			TableUtils.createTableIfNotExists(retval, Product.class);
		} catch (SQLException e) {
			log.warn("SQL errors during DB creation");
			log.debug("SQL errors during DB creation:",e);
		}
		return retval;
	}
	
	@Provides
	@Singleton
	public Dao<Bom, Long> getBomDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, Bom.class);
	}
	
	@Provides
	@Singleton
	public Dao<Component, Long> getComponentDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, Component.class);
	}
	
	@Provides
	@Singleton
	public Dao<User, Long> getUserDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, User.class);
	}
	
	public Dao<DeliveryNote, Long> getDeliveryNoteDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, DeliveryNote.class);
	}	
	
	@Provides
	@Singleton
	public Dao<Registry, Long> getRegistryDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, Registry.class);
	}
	
	@Provides
	@Singleton
	public Dao<RegistryGroup, Long> getRegistryGroupDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, RegistryGroup.class);
	}
	
	@Provides
	@Singleton
	public Dao<RegistryGroupPivot, Long> getRegistryGroupPivotDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, RegistryGroupPivot.class);
	}
	
	@Provides
	@Singleton
	public Dao<Invoice, Long> getInvoiceDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, Invoice.class);
	}
	@Provides
	@Singleton
	public Dao<InvoiceItem, Long> getInvoiceItemDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, InvoiceItem.class);
	}
	
	@Provides
	@Singleton
	public Dao<Order, Long> OrderDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, Order.class);
	}
	
	@Provides
	@Singleton
	public Dao<OrderItem, Long> OrderItemDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, OrderItem.class);
	}
	
	@Provides
	@Singleton
	public Dao<Product, Long> getProductDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, Product.class);
	}

}
