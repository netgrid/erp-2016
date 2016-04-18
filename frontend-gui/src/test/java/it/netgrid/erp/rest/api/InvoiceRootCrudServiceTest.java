package it.netgrid.erp.rest.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.SQLException;
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
	public void testCreateRawPersonalRegistry() throws SQLException {
		Invoice expected = new Invoice();

		InvoiceItem ie = new InvoiceItem();
		List<InvoiceItem> items = null;

		InvoiceRoot input = new InvoiceRoot(expected, items);
		/*
		 * ie.setAmount(amount); ie.setDescription(description);
		 * ie.setDimension(dimension); ie.setDiscount(discount);
		 * ie.setInvoice(invoice); ie.setMeasureUnit(measureUnit);
		 * ie.setOnePrice(onePrice); ie.setProduct(product);
		 * ie.setQuantity(quantity); ie.setThickness(thickness);
		 * ie.setVatCodeProduct(vatCodeProduct);
		 * 
		 * for(int i=0;i<10;i++) { items.add(ie); }
		 * 
		 * expected.setAddress(fairy.person().getAddress().street());
		 * expected.setAddressClient(fairy.person().getAddress().street());
		 * expected.setBank(bank);
		 * expected.setCity(fairy.person().getAddress().getCity());
		 * expected.setCityClient(fairy.person().getAddress().getCity());
		 * expected.setClient(client); expected.setConsign(consign);
		 * expected.setCurrency(currency); expected.setDateInv(dateInv);
		 * expected.setFinalAmount(finalAmount); expected.setHolder(holder);
		 * expected.setInvoiceItem(invoiceItem);
		 * expected.setNameProduct(nameProduct); expected.setNumber(number);
		 * expected.setVatNumber(vatNumber);
		 * expected.setVatNumClient(vatNumClient); expected.setZipCode(zipCode);
		 * expected.setZipCodeClient(zipCodeClient);
		 */
		this.classUnderTest.create(input);

		assertThat("created id is not null", input.getId(), not(equalTo(null)));

		Invoice current = this.invoiceDao.queryForId(input.getId());
		assertThat("current is not null", current, not(equalTo(null)));

		assertThat("", expected.getAddress(), equalTo(current.getAddress()));
		assertThat("", expected.getAddressClient(), equalTo(current.getAddressClient()));
		assertThat("", expected.getBank(), equalTo(current.getBank()));
		assertThat("", expected.getCity(), equalTo(current.getCity()));
		assertThat("", expected.getCityClient(), equalTo(current.getCityClient()));
		assertThat("", expected.getId(), equalTo(current.getId()));
		assertThat("", expected.getConsign(), equalTo(current.getConsign()));
		assertThat("", expected.getCurrency(), equalTo(current.getCurrency()));
		assertThat("", expected.getDateInv(), equalTo(current.getDateInv()));
		assertThat("", expected.getFinalAmount(), equalTo(current.getFinalAmount()));
		assertThat("", expected.getHolder(), equalTo(current.getHolder()));

	}
}
