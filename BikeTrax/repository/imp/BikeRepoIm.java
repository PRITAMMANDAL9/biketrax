package com.BikeTrax.repository.imp;

import java.util.Objects;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.BikeTrax.config.DatabaseConfig;
import com.BikeTrax.entity.Bike;
import com.BikeTrax.repository.BikeRepo;

public class BikeRepoIm implements BikeRepo {
	private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

	@Override
	public Bike findBike(int registationId) {
		try (Session session = sessionFactory.openSession();) {
			return session.find(Bike.class, registationId);
		}

	}

	@Override
	public Bike findBikewithoutCoustomer(int registationId) {
		try (Session session = sessionFactory.openSession();) {
			Bike bike = session.find(Bike.class, registationId);
			if (Objects.nonNull(bike)) {
				Hibernate.initialize(bike.getCoustomer());
			}
			return bike;
		}

	}

}
