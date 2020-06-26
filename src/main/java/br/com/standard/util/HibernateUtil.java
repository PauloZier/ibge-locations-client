package br.com.standard.util;

import java.util.Properties;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;
import br.com.standard.AppConfig;

public class HibernateUtil {
	
	private HibernateUtil() {
		
	}
	
	private static EntityManagerFactory entityManagerFactory = null;
	
	public static EntityManager getEntityManager() {
		
		if (entityManagerFactory == null) {
			
			verifyConfigurations();
			
			hibernateInit();
			
		}
		
		return entityManagerFactory.createEntityManager();
		
	}
	
	private static void verifyConfigurations() {
		
		if (AppConfig.getHibernateProperties() == null) {

			Properties prop = new Properties();
			
			prop.put("hibernate.connection.driver_class", "org.h2.Driver");
	        prop.put("hibernate.connection.url", "jdbc:h2:~/localdb/locationsDB");
	        prop.put("hibernate.connection.username", "root");
	        prop.put("hibernate.connection.password", "12345");
	        prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	        prop.put("hibernate.hbm2ddl.auto", "update");
	        prop.put("hibernate.show_sql", "true");
	        
	        AppConfig.setHibernateProperties(prop);
		}
		
	}
	
	private static void hibernateInit() {
		
		Configuration configuration = new Configuration();
		
		configuration.setProperties(AppConfig.getHibernateProperties());
		
		getEntities().forEach(x -> configuration.addAnnotatedClass(x));
		
		entityManagerFactory = configuration
				.buildSessionFactory()
				.openSession()
				.getEntityManagerFactory();
	}
	
	public static Set<Class<?>> getEntities() {
		
		return new Reflections("").getTypesAnnotatedWith(Entity.class);
		
	}
}
