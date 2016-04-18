package it.netgrid.erp.rest;

public interface PersistenceTestHandler {

	void setup();
	void destroy();
	void loadData();
	
}