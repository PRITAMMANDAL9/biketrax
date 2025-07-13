package com.BikeTrax.service;

import com.BikeTrax.dto.BikeDto;
import com.BikeTrax.exception.BikeDetailsNotFoundException;

public interface BikeService {
	BikeDto findBike(int registationId) throws BikeDetailsNotFoundException;

	BikeDto findBikewithoutCoustomer(int registationId) throws BikeDetailsNotFoundException;

}
