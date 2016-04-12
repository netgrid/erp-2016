package it.netgrid.erp.model.api;

public interface DataCopyAdapter<S, T> {

	void copyData(S source, T target);
	
}
