package it.netgrid.erp.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.Invoice;
import it.netgrid.erp.model.InvoiceItem;

@XmlRootElement
public class InvoiceRoot implements CrudObject<Long>{

	private Invoice invoice;
	private List<InvoiceItem> invoiceItems; 
	
	public InvoiceRoot() {}

	public InvoiceRoot(Invoice invoice) {
		super();
		this.invoice = invoice;
		this.invoiceItems = new ArrayList<InvoiceItem>();
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	@Override
	public Long getId() {
		return this.invoice == null ? null : this.invoice.getId();
	}

	
	
}
