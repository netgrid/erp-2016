package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import org.apache.commons.lang3.Validate;
import org.apache.commons.validator.routines.EmailValidator;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import it.netgrid.erp.model.Registry;
import it.netgrid.erp.model.RegistryGroup;
import it.netgrid.erp.model.RegistryGroupPivot;
import it.netgrid.erp.model.dto.RegistryRoot;

public class RegistryRootCrudService extends TemplateCrudService<RegistryRoot, Long> {

	public static final String INVALID_REGISTRY = "registry";
	public static final String INVALID_REGISTRY_NAME = "registry/name";
	public static final String INVALID_REGISTRY_MAIL_ADDRESS = "registry/mail";
	
	private final Dao<Registry, Long> registryDao;
	private final Dao<RegistryGroupPivot, Long> registryGroupPivotDao;
	
	@Inject
	public RegistryRootCrudService(ConnectionSource connection,
			Dao<Registry, Long> registryDao,
			Dao<RegistryGroupPivot, Long> registryGroupPivotDao) {
		super(connection);
		
		this.registryDao = registryDao;
		this.registryGroupPivotDao = registryGroupPivotDao;
	}

	@Override
	public int createRaw(RegistryRoot object) throws SQLException, IllegalArgumentException {
		int retval = 0;
		
		// Verifico correttezza dati
		Validate.notNull(object.getRegistry(), INVALID_REGISTRY);
		Validate.notEmpty(object.getRegistry().getName(), INVALID_REGISTRY_NAME);
		String mailAddress = object.getRegistry().getMailAddress();
		if(mailAddress != null) {
			mailAddress = mailAddress.trim();
			if(!EmailValidator.getInstance().isValid(mailAddress)) {
				throw new IllegalArgumentException(INVALID_REGISTRY_MAIL_ADDRESS);
			}
		}
		
		// Creo righe nel DB
		retval += this.registryDao.create(object.getRegistry());
		for(RegistryGroup group : object.getGroups()) {
			RegistryGroupPivot pivot = new RegistryGroupPivot(object.getRegistry(), group);
			retval += this.registryGroupPivotDao.create(pivot);
		}
		
		return retval;
	}

	@Override
	public int updateRaw(RegistryRoot object) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRaw(RegistryRoot object) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RegistryRoot read(Long key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
