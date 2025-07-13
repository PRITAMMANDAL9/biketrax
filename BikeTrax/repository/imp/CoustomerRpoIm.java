package com.BikeTrax.repository.imp;

import java.util.Objects;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.BikeTrax.config.DatabaseConfig;
import com.BikeTrax.entity.Bike;
import com.BikeTrax.entity.Coustomer;
import com.BikeTrax.enums.Model;
import com.BikeTrax.repository.CoustomerRepo;

public class CoustomerRpoIm implements CoustomerRepo {
	private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

	@Override
	public void saveCoustomer(Coustomer coustomer) {
		try (Session session = sessionFactory.openSession();) {
			Transaction transection = session.beginTransaction();
			session.persist(coustomer);
			transection.commit();
		}
	}

	@Override
	public Coustomer findCoustomer(int coustomerId) {
		try (Session session = sessionFactory.openSession();) {
			return session.find(Coustomer.class, coustomerId);
		}

	}

	@Override
	public void updateBikeDetails(int coustomerId, int registrationId, Model model) {
		try (Session session = sessionFactory.openSession();) {
			Transaction transection = session.beginTransaction();
			Coustomer coustomer = session.find(Coustomer.class, coustomerId);
			coustomer.getBikeList().stream().filter(bike -> bike.getRegistrationId() == registrationId).findFirst()
					.ifPresent(bike -> bike.setModel(model));
			session.merge(coustomer);
			transection.commit();

		}

	}

	@Override
	public Coustomer findCoustomewithoutBike(int coustomerId) {
		try (Session session = sessionFactory.openSession();) {
			Coustomer coustomer = session.find(Coustomer.class, coustomerId);
			if (Objects.nonNull(coustomer)) {
				Hibernate.initialize(coustomer.getBikeList());
			}
			return coustomer;
		}
	}

	@Override
	public void addBike(int coustomerId, Bike bike) {
		try (Session session = sessionFactory.openSession();) {
			Transaction transection = session.beginTransaction();
			session.persist(bike);
			transection.commit();
		}
	}

	@Override
	public void deleteBike(int coustomerId, int registrationId) {
		try (Session session = sessionFactory.openSession();) {
			Transaction transection = session.beginTransaction();
			Coustomer coustomer = session.find(Coustomer.class, coustomerId);
			coustomer.getBikeList().removeIf(bike -> bike.getRegistrationId() == registrationId);
			session.merge(coustomer);
			transection.commit();
		}

	}

	@Override
	public void deleteCoustomer(int coustomerId) {
		try (Session session = sessionFactory.openSession();) {
			Transaction transection = session.beginTransaction();
			Coustomer coustomer = session.find(Coustomer.class, coustomerId);
			session.remove(coustomer);
			transection.commit();
		}

	}

}
