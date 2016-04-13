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
			TableUtils.createTableIfNotExists(retval, RegitryGroup.class);
			TableUtils.createTableIfNotExists(retval, RegistryGroupPivot.class);
		} catch (SQLException e) {
			log.warn("SQL errors during DB creation");
			log.debug("SQL errors during DB creation:",e);
		}
		return retval;
	}
	
	@Provides
	@Singleton
	public Dao<Registry, Long> getRegistryDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, Registry.class);
	}
	
	@Provides
	@Singleton
	public Dao<RegitryGroup, Long> getRegistryGroupDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, RegitryGroup.class);
	}
	
	@Provides
	@Singleton
	public Dao<RegistryGroupPivot, Long> getRegistryGroupPivotDao(ConnectionSource connection) throws SQLException {
		return DaoManager.createDao(connection, RegistryGroupPivot.class);
	}
}
