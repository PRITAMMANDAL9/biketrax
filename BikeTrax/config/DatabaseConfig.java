package com.BikeTrax.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.BikeTrax.entity.Bike;
import com.BikeTrax.entity.Coustomer;

public class DatabaseConfig {
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private DatabaseConfig() {

	}

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration().addAnnotatedClass(Coustomer.class)
				.addAnnotatedClass(Bike.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}