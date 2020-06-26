package br.com.standard;

import java.util.Properties;

public class AppConfig {
	
	private AppConfig() {
		
	} 
	
	private static Properties hibernateProperties = null;

	public static Properties getHibernateProperties() {
		return hibernateProperties;
	}

	public static void setHibernateProperties(Properties hibernateProperties) {
		AppConfig.hibernateProperties = hibernateProperties;
	}
}
