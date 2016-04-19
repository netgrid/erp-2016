package it.netgrid.erp.rest.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ForeignCollection;

import io.codearte.jfairy.Fairy;
import it.netgrid.erp.model.Invoice;
import it.netgrid.erp.model.InvoiceItem;
import it.netgrid.erp.model.dto.InvoiceRoot;
import it.netgrid.erp.rest.Erp2016TestEnv;
import it.netgrid.erp.rest.PersistenceTestHandler;

public class InvoiceRootCrudServiceTest {
	@Rule
	public final GuiceBerryRule guiceBerry = new GuiceBerryRule(Erp2016TestEnv.class);

	@Inject
	private Fairy fairy;

	@Inject
	private PersistenceTestHandler persistence;

	@Inject
	private InvoiceRootCrudService classUnderTest;

	@Inject
	private Dao<Invoice, Long> invoiceDao;

	
	

	@Before
	public void setUp() {
		persistence.setup();
		persistence.loadData();
	}

	@After
	public void tearDown() {
		persistence.destroy();
	}

	@Test
	public void testCreate() throws SQLException {
		Invoice invoice = new Invoice();
		InvoiceItem invoiceItem= new InvoiceItem();
		List<InvoiceItem> items = new ArrayList<InvoiceItem>();
		
		InvoiceRoot input = new InvoiceRoot(invoice, items);
		
		
		// Creazione Invoice		
		invoice.setAddress(null);
		invoice.setAddressClient(null);
		invoice.setBank(null);
		invoice.setCity(null);
		invoice.setCityClient(null);
		invoice.setClient(null);
		invoice.setConsign(null);
		invoice.setCurrency(null);
		invoice.setDateInv(null);
		invoice.setFinalAmount(null);
		invoice.setHolder(null);
		invoice.setInvoiceItem(null);
		invoice.setNameProduct(null);
		invoice.setNumber(null);
		invoice.setPhone(null);
		invoice.setRegistry(null);
		invoice.setState(null);
		invoice.setStateClient(null);
		invoice.setTaxCodeClient(null);
		invoice.setTransport(null);
		invoice.setVatNumber(null);
		invoice.setVatNumClient(null);
		invoice.setZipCode(null);
		invoice.setZipCodeClient(null);
		
		// Creazione singolo item
		invoiceItem.setAmount(null);
		invoiceItem.setDescription(null);
		invoiceItem.setDimension(null);
		invoiceItem.setDiscount(null);
		invoiceItem.setInvoice(null);
		invoiceItem.setMeasureUnit(null);
		invoiceItem.setOnePrice(null);
		invoiceItem.setProduct(null);
		invoiceItem.setQuantity(null);
		invoiceItem.setThickness(null);
		invoiceItem.setVatCodeProduct(null);
		
		// Aggiungo elementi nella List
		items.add(invoiceItem);
		items.add(invoiceItem);
		
		this.classUnderTest.create(input);
		
		
		assertThat("created id is not null", input.getId(), not(equalTo(null)));
		
		Invoice current = this.invoiceDao.queryForId(input.getId());
		assertThat("current is not null", current, not(equalTo(null)));
		assertThat("", invoice.getAddress(), equalTo(current.getAddress()));
		assertThat("", invoice.getAddressClient(), equalTo(current.getAddressClient()));
		assertThat("", invoice.getBank(), equalTo(current.getBank()));
		assertThat("", invoice.getCity(), equalTo(current.getCity()));
		assertThat("", invoice.getCityClient(), equalTo(current.getCityClient()));
		assertThat("", invoice.getClient(), equalTo(current.getClient()));
		assertThat("", invoice.getConsign(), equalTo(current.getConsign()));
		assertThat("", invoice.getCurrency(), equalTo(current.getCurrency()));
		assertThat("", invoice.getDateInv(), equalTo(current.getDateInv()));
		assertThat("", invoice.getFinalAmount(), equalTo(current.getFinalAmount()));
		assertThat("", invoice.getHolder(), equalTo(current.getHolder()));
	}
}
