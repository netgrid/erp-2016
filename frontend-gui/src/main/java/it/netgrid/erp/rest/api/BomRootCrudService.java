package it.netgrid.erp.rest.api;

import java.sql.SQLException;
import org.apache.commons.lang3.Validate;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import it.netgrid.erp.model.Bom;
import it.netgrid.erp.model.Component;
import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.dto.BomRoot;

public class BomRootCrudService extends TemplateCrudService<BomRoot, Long> {

	public static final String INVALID_ID_BOM = "Bom";
	public static final String INVALID_ID_COMPONENT = "Component";
	
	private final Dao<Bom, Long> BomDao;
	private final Dao<Component, Long> ComponentDao;
	
	
	@Inject
	public BomRootCrudService(ConnectionSource connection,
		Dao<Bom, Long> BomDao,
		Dao<Component, Long> ComponentDao) {
		super (connection);
		
		this.BomDao=BomDao;
		this.ComponentDao=ComponentDao;
	}
	


	@Override
	public BomRoot read(Long key) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createRaw(BomRoot object) throws SQLException, IllegalArgumentException {
		int retval = 0;
		
		// Verifica correttezza dati
		Validate.notNull(object.getBom(), INVALID_ID_BOM);
		Validate.notNull(object.getComponent(), INVALID_ID_COMPONENT);
		

		// Creo righe nel DB
		retval += this.BomDao.create(object.getBom());
		for(Component component : object.getComponent()) {
			
		}
		
		return retval;
	}

	@Override
	public int updateRaw(BomRoot object) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRaw(BomRoot object) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}