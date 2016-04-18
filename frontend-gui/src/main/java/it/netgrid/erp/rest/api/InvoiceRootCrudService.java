package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import org.apache.commons.lang3.Validate;

import it.netgrid.erp.model.Invoice;
import it.netgrid.erp.model.InvoiceItem;
import it.netgrid.erp.model.dto.InvoiceRoot;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

public class InvoiceRootCrudService extends TemplateCrudService<InvoiceRoot, Long> {

	public static final String INVALID_ID_INVOICE = "invoice";
	
	
	private final Dao<Invoice, Long> invoiceDao;
	private final Dao<InvoiceItem, Long> invoiceItemDao;
	
	
	@Inject
	public InvoiceRootCrudService(ConnectionSource connection,
		Dao<Invoice, Long> invoiceDao,
		Dao<InvoiceItem, Long> invoiceItemDao) {
		super (connection);
		
		this.invoiceDao = invoiceDao;
		this.invoiceItemDao = invoiceItemDao;
	}
	


	@Override
	public InvoiceRoot read(Long key) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createRaw(InvoiceRoot object) throws SQLException, IllegalArgumentException {
		int retval = 0;
		
		// Verifica correttezza dati
		Validate.notNull(object.getInvoice(), INVALID_ID_INVOICE);
		
		

		// Creo righe nel DB
		retval += this.invoiceDao.create(object.getInvoice());
		for() {
			
		}
		
		return retval;
	}

	@Override
	public int updateRaw(InvoiceRoot object) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRaw(InvoiceRoot object) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
