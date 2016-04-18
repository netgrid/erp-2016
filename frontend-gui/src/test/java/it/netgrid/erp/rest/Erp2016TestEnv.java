package it.netgrid.erp.rest;

import java.util.Properties;

import io.codearte.jfairy.Fairy;

import com.google.guiceberry.GuiceBerryEnvMain;
import com.google.guiceberry.GuiceBerryModule;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import it.netgrid.erp.model.Configuration;
import it.netgrid.erp.model.DaoModule;
import it.netgrid.erp.rest.api.CrudServicesModule;

public class Erp2016TestEnv extends AbstractModule {

		@Override
		protected void configure() {
			install(new GuiceBerryModule());
			install(new DaoModule());
			install(new CrudServicesModule());
			bind(GuiceBerryEnvMain.class).to(Erp2016EnvMain.class);
		}
		
		@Provides
		@Singleton
		public Configuration getConfiguration() {
			return new Configuration() {
				
				@Override
				public String getJdbcConnectionUrl() {
					return "jdbc:h2:mem:erp2016";
				}

				@Override
				public String getJdbcUsername() {
					return null;
				}

				@Override
				public String getJdbcPassword() {
					return null;
				}

				@Override
				public Properties getProperties() {
					return null;
				}
				
			};
		}
		
		@Provides
		public Fairy getFairy() {
			return Fairy.create();
		}
		
		static class Erp2016EnvMain implements GuiceBerryEnvMain {
			
			@Override
			public void run() {
				//NOTHING TO DO
			}
			
		}
	}
