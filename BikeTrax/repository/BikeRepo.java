package com.BikeTrax.repository;

import com.BikeTrax.entity.Bike;

public interface BikeRepo {
	Bike findBike(int registationId);

	Bike findBikewithoutCoustomer(int registationId);

}
