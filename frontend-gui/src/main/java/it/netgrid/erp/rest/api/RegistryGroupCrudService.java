package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import org.apache.commons.lang3.Validate;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import it.netgrid.erp.model.RegistryGroup;
import it.netgrid.erp.model.RegistryGroupPivot;

public class RegistryGroupCrudService extends DaoProxyCrudService<RegistryGroup, Long> {

	public static final String ILLEGAL_CONTENT = "group/not-empty";
	public static final String ILLEGAL_GROUP = "group";
	
	private final Dao<RegistryGroupPivot, Long> registryGroupPivotDao;
	
	@Inject
	public RegistryGroupCrudService(ConnectionSource connection, Dao<RegistryGroup, Long> dao, Dao<RegistryGroupPivot, Long> registryGroupPivotDao) {
		super(connection, dao);
		this.registryGroupPivotDao = registryGroupPivotDao;
	}

	@Override
	public int deleteRaw(RegistryGroup object) throws SQLException {
		Validate.notNull(object, ILLEGAL_GROUP);
		
		// Verifico che il gruppo sia vuoto
		QueryBuilder<RegistryGroupPivot, Long> builder = this.registryGroupPivotDao.queryBuilder();
		builder.where().eq(RegistryGroupPivot.REGISTRY_GROUP_FIELD_NAME, object.getId());
		Validate.isTrue(builder.countOf() < 1, ILLEGAL_CONTENT);
		
		return this.getDao().delete(object);
	}
}
