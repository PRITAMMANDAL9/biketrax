package com.BikeTrax.repository;

import com.BikeTrax.entity.Bike;
import com.BikeTrax.entity.Coustomer;
import com.BikeTrax.enums.Model;

public interface CoustomerRepo {
	void saveCoustomer(Coustomer cooustomer);

	Coustomer findCoustomer(int coustomerId);

	Coustomer findCoustomewithoutBike(int coustomerId);

	void updateBikeDetails(int coustomerId, int registrationId, Model model);

	void deleteCoustomer(int coustomerId);

	void addBike(int coustomerId, Bike bike);

	void deleteBike(int coustomerId, int registrationId);

}
