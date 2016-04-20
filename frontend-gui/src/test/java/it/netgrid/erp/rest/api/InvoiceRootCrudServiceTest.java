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
	public void testCreateRaw() throws SQLException {
		Invoice invoice = new Invoice();
		InvoiceItem item= new InvoiceItem();
		List<InvoiceItem> expected = new ArrayList<InvoiceItem>();
		InvoiceRoot input = new InvoiceRoot(invoice);		
		
		// Creazione Invoice		
		invoice.setAddress(fairy.person().getAddress().street());
		invoice.setAddressClient(fairy.person().getAddress().street());
		invoice.setBank("sasas");
		invoice.setCity(fairy.person().getAddress().getCity());
		invoice.setCityClient(fairy.person().getAddress().getCity());
		invoice.setClient("fdfd");
		invoice.setConsign("dfdf");
		invoice.setCurrency("rfrfr");
		invoice.setDateInv(new Date(2015/05/05));
		invoice.setFinalAmount("hyht");
		invoice.setHolder("gfrd");
		invoice.setNameProduct("jujg");
		invoice.setNumber("rgrg");
		invoice.setPhone(fairy.person().telephoneNumber());
		invoice.setState("frfer");
		invoice.setStateClient("dfd");
		invoice.setTaxCodeClient("dffd");
		invoice.setTransport("rrr");
		invoice.setVatNumber("fd");
		invoice.setVatNumClient("fdfd");
		invoice.setZipCode(fairy.person().getAddress().getPostalCode());
		invoice.setZipCodeClient(fairy.person().getAddress().getPostalCode());
		/*
		// Creazione singolo item
		item.setAmount(new BigDecimal(10));
		item.setDescription("");
		item.setDimension(new BigDecimal(10));
		item.setDiscount(new BigDecimal(10));
		item.setInvoice(null);
		item.setMeasureUnit("");
		item.setOnePrice(new BigDecimal(10));
		item.setProduct("");
		item.setQuantity(new BigDecimal(10));
		item.setThickness(new BigDecimal(10));
		item.setVatCodeProduct("");
		*/
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
		assertThat("", invoice.getNameProduct(), equalTo(current.getNameProduct()));
		assertThat("", invoice.getNumber(), equalTo(current.getNumber()));
		assertThat("", invoice.getPhone(), equalTo(current.getPhone()));
		assertThat("", invoice.getState(), equalTo(current.getState()));
		assertThat("", invoice.getStateClient(), equalTo(current.getStateClient()));
		assertThat("", invoice.getTaxCodeClient(), equalTo(current.getTaxCodeClient()));
		assertThat("", invoice.getTransport(), equalTo(current.getTransport()));
		assertThat("", invoice.getVatNumber(), equalTo(current.getVatNumber()));
		assertThat("", invoice.getVatNumClient(), equalTo(current.getVatNumClient()));
		assertThat("", invoice.getZipCode(), equalTo(current.getZipCode()));
		assertThat("", invoice.getZipCodeClient(), equalTo(current.getZipCodeClient()));
	}
}
