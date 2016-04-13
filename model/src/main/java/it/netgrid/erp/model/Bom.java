package it.netgrid.erp.model;



public class Bom {
	
	private int idProduct = -1;
	private int idComponent = -1;
	private String componentName = " ";
	

	
	public Bom(){
		
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}

	public String getNomeComponente() {
		return componentName;
	}

	public void setNomeComponente(String componentName) {
		this.componentName = componentName;
	}
	
	
}
