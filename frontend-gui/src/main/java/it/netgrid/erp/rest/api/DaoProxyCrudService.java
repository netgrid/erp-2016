package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import it.netgrid.erp.model.CrudObject;

public class DaoProxyCrudService<T extends CrudObject<ID>, ID> extends TemplateCrudService<T, ID> {

	private Dao<T, ID> dao;

	@Inject
	public DaoProxyCrudService(ConnectionSource connection, Dao<T, ID> dao) {
		super(connection);
		this.dao = dao;
	}

	@Override
	public int createRaw(T object) throws SQLException {
		return dao.create(object);
	}

	@Override
	public T read(ID key) throws SQLException {
		return dao.queryForId(key);
	}

	@Override
	public int updateRaw(T object) throws SQLException {
		return dao.update(object);
	}

	@Override
	public int deleteRaw(T object) throws SQLException {
		return dao.delete(object);
	}

}