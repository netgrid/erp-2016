package it.netgrid.erp.utils;

import java.util.Properties;

public interface Configuration {

	String getJdbcConnectionUrl();

	Properties getProperties();

	String getJdbcUsername();

	String getJdbcPassword();

}
