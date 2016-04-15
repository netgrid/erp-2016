package it.netgrid.erp.model.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.Invoice;
import it.netgrid.erp.model.InvoiceItem;

@XmlRootElement
public class InvoiceRoot implements CrudObject<Long>{

	private Invoice invoice;
	private List<InvoiceItem> invoiceItem; 
	
	public InvoiceRoot() {}

	public InvoiceRoot(Invoice invoice, List<InvoiceItem> invoiceItem) {
		super();
		this.invoice = invoice;
		this.invoiceItem = invoiceItem;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public List<InvoiceItem> getInvoiceItem() {
		return invoiceItem;
	}

	public void setInvoiceItem(List<InvoiceItem> invoiceItem) {
		this.invoiceItem = invoiceItem;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
