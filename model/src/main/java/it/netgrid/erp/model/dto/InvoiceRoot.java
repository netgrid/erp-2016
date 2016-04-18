package it.netgrid.erp.model.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.Invoice;
import it.netgrid.erp.model.InvoiceItem;

@XmlRootElement
public class InvoiceRoot implements CrudObject<Long>{

	private Invoice invoice;
	private List<InvoiceItem> invoiceGroup; 
	
	public InvoiceRoot() {}

	public InvoiceRoot(Invoice invoice, List<InvoiceItem> invoiceGroup) {
		super();
		this.invoice = invoice;
		this.invoiceGroup = invoiceGroup;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public List<InvoiceItem> getInvoiceGroup() {
		return invoiceGroup;
	}

	public void setInvoiceGroup(List<InvoiceItem> invoiceGroup) {
		this.invoiceGroup = invoiceGroup;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.invoice == null ? null : this.invoice.getId();
	}

	
	
}
