package it.netgrid.erp.rest.api;

import java.sql.SQLException;
import org.apache.commons.lang3.Validate;

import it.netgrid.erp.model.Invoice;
import it.netgrid.erp.model.InvoiceItem;
import it.netgrid.erp.model.dto.InvoiceRoot;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;

public class InvoiceRootCrudService extends TemplateCrudService<InvoiceRoot, Long> {

	public static final String INVALID_ID_INVOICE = "invoice";
	public static final String INVALID_ADDRESS_INVOICE = "invoice/address";
	public static final String INVALID_ADDRESS_CLIENT_INVOICE = "invoice/address_client";
	public static final String INVALID_BANK_INVOICE = "invoice/bank";
	public static final String INVALID_CITY_INVOICE = "invoice/city";
	public static final String INVALID_CITY_CLIENT_INVOICE = "invoice/city_client";
	public static final String INVALID_CLIENT_INVOICE = "invoice/client";
	public static final String INVALID_CONSIGN_INVOICE = "invoice/consign";
	public static final String INVALID_CURRENCY_INVOICE = "invoice/currency";
	public static final String INVALID_DATE_INV_INVOICE = "invoice/date_inv";
	public static final String INVALID_FINAL_AMOUNT_INVOICE = "invoice/final_amount";
	public static final String INVALID_HOLDER_INVOICE = "invoice/holder";
	public static final String INVALID_INVOICE_ITEM_INVOICE = "invoice/invoice_item";
	public static final String INVALID_NAME_PRODUCT_INVOICE = "invoice/name_product";
	public static final String INVALID_NUMBER_INVOICE = "invoice/number";
	public static final String INVALID_PHONE_INVOICE = "invoice/phone";
	public static final String INVALID_REGISTRY_INVOICE = "invoice/registry";
	public static final String INVALID_STATE_INVOICE = "invoice/state";
	public static final String INVALID_STATE_CLIENT_INVOICE = "invoice/state_client";
	public static final String INAVLID_TAX_CODE_CLIENT_INVOICE = "invoice/tax_code_client";
	public static final String INVALID_TRANSPORT_INVOICE = "invoice/transport";
	public static final String INVALID_VAT_NUMBER_INVOICE = "invoice/vat_number";
	public static final String INVALID_VAT_NUM_CLIENT_INVOICE = "invoice/vat_num_client";
	public static final String INVALID_ZIP_CODE_INVOICE = "invoice/zip_code";
	public static final String INVALID_ZIP_CODE_CLIENT_INVOICE = "invoice/zip_code_client";
	public static final String INVALID_ID_INVOICE_ITEMS = "invoice_items";

	private final Dao<Invoice, Long> invoiceDao;
	private final Dao<InvoiceItem, Long> invoiceItemDao;

	@Inject
	public InvoiceRootCrudService(ConnectionSource connection, Dao<Invoice, Long> invoiceDao,
			Dao<InvoiceItem, Long> invoiceItemDao) {
		super(connection);

		this.invoiceDao = invoiceDao;
		this.invoiceItemDao = invoiceItemDao;
	}

	@Override
	public InvoiceRoot read(Long key) throws SQLException, IllegalArgumentException {
		
		return null;
	}

	@Override
	public int createRaw(InvoiceRoot object) throws SQLException, IllegalArgumentException {
		int retval = 0;

		// Verifica correttezza dati
		Validate.notNull(object.getInvoice(), INVALID_ID_INVOICE);
		Validate.notEmpty(object.getInvoice().getAddress(), INVALID_ADDRESS_INVOICE);
		Validate.notEmpty(object.getInvoice().getAddressClient(), INVALID_ADDRESS_CLIENT_INVOICE);
		Validate.notEmpty(object.getInvoice().getBank(), INVALID_BANK_INVOICE);
		Validate.notEmpty(object.getInvoice().getCity(), INVALID_CITY_INVOICE);
		Validate.notEmpty(object.getInvoice().getCityClient(), INVALID_CITY_CLIENT_INVOICE);
		Validate.notEmpty(object.getInvoice().getClient(), INVALID_CLIENT_INVOICE);
		Validate.notEmpty(object.getInvoice().getConsign(), INVALID_CONSIGN_INVOICE);
		Validate.notEmpty(object.getInvoice().getCurrency(), INVALID_CURRENCY_INVOICE);
		Validate.notNull(object.getInvoice().getDateInv(), INVALID_DATE_INV_INVOICE);
		Validate.notEmpty(object.getInvoice().getFinalAmount(), INVALID_FINAL_AMOUNT_INVOICE);
		Validate.notEmpty(object.getInvoice().getHolder(), INVALID_HOLDER_INVOICE);
		Validate.notEmpty(object.getInvoice().getInvoiceItem(), INVALID_INVOICE_ITEM_INVOICE);
		Validate.notEmpty(object.getInvoice().getNameProduct(), INVALID_NAME_PRODUCT_INVOICE);
		Validate.notNull(object.getInvoice().getNumber(), INVALID_NUMBER_INVOICE);
		Validate.notEmpty(object.getInvoice().getPhone(), INVALID_PHONE_INVOICE);
		Validate.notNull(object.getInvoice().getRegistry(), INVALID_REGISTRY_INVOICE);
		Validate.notEmpty(object.getInvoice().getState(), INVALID_STATE_INVOICE);
		Validate.notEmpty(object.getInvoice().getStateClient(), INVALID_STATE_CLIENT_INVOICE);
		Validate.notEmpty(object.getInvoice().getTaxCodeClient(), INAVLID_TAX_CODE_CLIENT_INVOICE);
		Validate.notEmpty(object.getInvoice().getTransport(), INVALID_TRANSPORT_INVOICE);
		Validate.notEmpty(object.getInvoice().getVatNumber(), INVALID_VAT_NUMBER_INVOICE);
		Validate.notEmpty(object.getInvoice().getVatNumClient(), INVALID_VAT_NUM_CLIENT_INVOICE);
		Validate.notEmpty(object.getInvoice().getZipCode(), INVALID_ZIP_CODE_INVOICE);
		Validate.notEmpty(object.getInvoice().getZipCodeClient(), INVALID_ZIP_CODE_CLIENT_INVOICE);
		Validate.notNull(object.getInvoiceItems(), INVALID_ID_INVOICE_ITEMS);

		// Creo righe nel DB
		retval += this.invoiceDao.create(object.getInvoice());
		for (InvoiceItem item : object.getInvoiceItems()) {
			item.setInvoice(object.getInvoice());
			retval += this.invoiceItemDao.create(item);
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
		int retval = 0;
		
		// Verifico correttezza dati
		
		
		// Elimino righe nel DB
		DeleteBuilder<Invoice, Long> deleteQuery = this.invoiceDao.deleteBuilder();
		deleteQuery.where().eq(Invoice.ADDRESS_FIELD_NAME, object.getId());
		retval += deleteQuery.delete();
		retval += this.invoiceDao.delete(object.getInvoice());
		
		return retval;
	}

}
