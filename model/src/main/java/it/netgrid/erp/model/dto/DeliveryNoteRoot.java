package it.netgrid.erp.model.dto;

import javax.persistence.Entity;

import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.DeliveryNote;

@Entity(name="dtoroot")
public class DeliveryNoteRoot implements CrudObject<Long>{
	
	private DeliveryNote deliveryNote;
	public DeliveryNoteRoot(){
		
	}
	
	public void DeliveryRoot(DeliveryNote deliveryNote){
		this.deliveryNote = deliveryNote;
	}
	
	public DeliveryNote getdelivery(){
		return deliveryNote;
	}
	
	public void setdelivery(DeliveryNote deliveryNote){
		this.deliveryNote =deliveryNote;
	}
	
	@Override
	public Long getId(){
		return null;
	}
}
