package it.netgrid.erp.model.api;

public interface DataFormatAdapter<S, T> {

	T getFormattedData(S source);
	
}