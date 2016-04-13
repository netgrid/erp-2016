package it.netgrid.erp.model;

public class Component {
	private int idComponent = -1;
	private String Compnent = "";
	
	public Component(){
		
	}
	
	public Component(int id,String nome){
		this.idComponent = id;
		this.Compnent = nome;
	}

	public int getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}

	public String getCompnent() {
		return Compnent;
	}

	public void setCompnent(String compnent) {
		Compnent = compnent;
	}
	
}
