package it.netgrid.erp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesConfigurationImpl implements Configuration {

	private static final Logger log = LoggerFactory.getLogger(Configuration.class);

	private static final String DEFAULT_CONFIG_PROPERTIES_PATH = "/etc/erp/core/config.properties";
	private static final String DEFAULT_CONFIG_PROPERTIES_RESOURCE = "/config.properties";
	
	private static final String KEY_JDBC_CONNECTION_URL = "jdbcConnection";
	private static final String KEY_JDBC_USERNAME = "jdbcUsername";
	private static final String KEY_JDBC_PASSWORD = "jdbcPassword";
	
	private static final String DEFAULT_JDBC_CONNECITON_URL = "jdbc:mysql://localhost/nrp_persistence?zeroDateTimeBehavior=convertToNull";
	private static final String DEFAULT_JDBC_USERNAME = "root";
	private static final String DEFAULT_JDBC_PASSWORD = "root";
	
	private Properties properties;	
	
	public PropertiesConfigurationImpl() {
		this(null);
	}
	
	public PropertiesConfigurationImpl(String propertiesFilePathOrResourceName) {
		if(propertiesFilePathOrResourceName != null) {
			// Try to load argument as File Properties
			if(loadPropertiesFromFile(propertiesFilePathOrResourceName)) return;
			// Try to load argument as Resource Properties
			if(loadPropertiesAsResource(propertiesFilePathOrResourceName)) return;
		}
		// Try to load properties from Default Path
		if(loadPropertiesFromFile(DEFAULT_CONFIG_PROPERTIES_PATH)) return;
		loadPropertiesAsResource(DEFAULT_CONFIG_PROPERTIES_RESOURCE);
	}

	@Override
	public String getJdbcConnectionUrl() {
		return this.getProperties().getProperty(KEY_JDBC_CONNECTION_URL, DEFAULT_JDBC_CONNECITON_URL);
	}
	
	@Override
	public Properties getProperties() {
		return properties;
	}
	
	private boolean loadPropertiesAsResource(String propertiesResourceName) {
		if(properties == null) {
			try(InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(propertiesResourceName); ) {
				properties = new Properties();
				properties.load(resourceStream);
			} catch (NullPointerException e) {
				log.warn("Unable to load properties");
			} catch (IOException e) {
				log.warn(String.format("Unable to load config resource: %s", propertiesResourceName), e);
			}
		}
		return properties != null;
	}
	
	private boolean loadPropertiesFromFile(String filePath) {
		if(properties == null) {
			FileInputStream in = null;
			try {
				in = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				log.warn(String.format("Unable to load config file: %s", filePath), e);
			}
			
			if(in != null) {
				try {
					properties = new Properties();
					properties.load(in);
				} catch (IOException e) {
					log.warn("Invalid properties file format", e);
				} finally {
					try {
						in.close();
					} catch (IOException e) {
						log.debug("Input stream already closed");
					}	
				}
			}
		}
		return properties != null;
	}

	@Override
	public String getJdbcUsername() {
		return this.getProperties().getProperty(KEY_JDBC_USERNAME, DEFAULT_JDBC_USERNAME);
	}

	@Override
	public String getJdbcPassword() {
		return this.getProperties().getProperty(KEY_JDBC_PASSWORD, DEFAULT_JDBC_PASSWORD);
	}
}