package it.netgrid.erp.model;

import java.util.Properties;

public interface Configuration {

	String getJdbcConnectionUrl();

	Properties getProperties();

	String getJdbcUsername();

	String getJdbcPassword();

}
