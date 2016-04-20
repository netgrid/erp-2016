package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import it.netgrid.erp.model.DeliveryNote;
import it.netgrid.erp.model.dto.DeliveryNoteRoot;

public class DeliveryNoteRootCrudService extends TemplateCrudService<DeliveryNoteRoot, Long> {

	public static final String INVALID_ID_DELIVERY_NOTE ="Delivery_Note";
	
	private final Dao<DeliveryNote, Long>DeliveryNoteDao;

	@Inject
	public DeliveryNoteRootCrudService(ConnectionSource connection, Dao<DeliveryNote, Long> DeliveryNoteDao) {
		super(connection);
		this.DeliveryNoteDao = DeliveryNoteDao;
	}

	@Override
	public int createRaw(DeliveryNoteRoot object) throws SQLException, IllegalArgumentException {
		int retval = 0;
		retval += this.DeliveryNoteDao.create(object.getdelivery());
		return retval;
	}

	@Override
	public DeliveryNoteRoot read(Long key) throws SQLException, IllegalArgumentException {
		return null;
	}

	@Override
	public int updateRaw(DeliveryNoteRoot object) throws SQLException, IllegalArgumentException {
		return 0;
	}

	@Override
	public int deleteRaw(DeliveryNoteRoot object) throws SQLException, IllegalArgumentException {
		return 0;
	}
 
}
