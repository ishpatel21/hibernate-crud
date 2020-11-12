package com.example.hibernatecrud.config;

import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class SessionFactoryConfig {
	@Value("${db.driverclass}")
	String driverClass;
	@Value("${db.dialect}")
	String dialect;
	@Value("${db.username}")
	String username;
	@Value("${db.password}")
	String password;
	@Value("${db.url}")
	String url;
	@Value("${entityPackage}")
	String entityPackage;
	
	public static SessionFactory sf = null;

	@Bean
	public void saveSessionFactory() throws Exception {

		Reflections reflections = new Reflections(new ConfigurationBuilder()
	            .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
	            .addUrls(ClasspathHelper.forJavaClassPath()) 
	            .filterInputsBy(new FilterBuilder()
	            .include(FilterBuilder.prefix(entityPackage))));

		Set<Class<? extends Object>> classes = reflections.getSubTypesOf(Object.class);

		Configuration config = new Configuration()
				.setProperty("hibernate.connection.driver_class", driverClass)
				.setProperty("hibernate.dialect", dialect)
				.setProperty("hibernate.connection.username", username)
				.setProperty("hibernate.connection.password", password)
				.setProperty("hibernate.connection.url", url);
		
		for(Class<?> classz : classes) { 
			config.addAnnotatedClass(classz);
		}
		
		sf = config.buildSessionFactory();
		
		if(sf == null) {
			throw new Exception("Database not connected");
		}
		
	}
	
	
}
