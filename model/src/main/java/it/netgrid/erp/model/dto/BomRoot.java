package it.netgrid.erp.model.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import it.netgrid.erp.model.Bom;
import it.netgrid.erp.model.Component;
import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.Invoice;
import it.netgrid.erp.model.InvoiceItem;

@XmlRootElement
public class BomRoot implements CrudObject<Long> {

	private Bom bom;
	private List<Component> component;

	public BomRoot() {
	}

	public BomRoot(Bom bom, List<Component> component) {
		super();
		this.bom = bom;
		this.component = component;
	}

	public Bom getBom() {
		return bom;
	}

	public void setBom(Bom bom) {
		this.bom = bom;
	}

	public List<Component> getComponent() {
		return component;
	}

	public void setComponent(List<Component> component) {
		this.component = component;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}