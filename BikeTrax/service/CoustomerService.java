package com.BikeTrax.service;

import com.BikeTrax.dto.BikeDto;
import com.BikeTrax.dto.CoustomerDto;
import com.BikeTrax.enums.Model;
import com.BikeTrax.exception.BikeDetailsNotFoundException;
import com.BikeTrax.exception.OwnerNotFoundException;

public interface CoustomerService {
	void saveCoustomer(CoustomerDto coustomerDto);

	CoustomerDto findCoustomer(int coustomerId) throws OwnerNotFoundException;

	CoustomerDto findCoustomewithoutBike(int coustomerId) throws OwnerNotFoundException;

	void updateBikeDetails(int coustomerId, int registationtId, Model model)
			throws OwnerNotFoundException, BikeDetailsNotFoundException;

	void deleteCoustomer(int coustomerId) throws OwnerNotFoundException;

	void addBike(int coustomerId, BikeDto bikeDto) throws OwnerNotFoundException;

	void removeBike(int coustomerId, int registationtId) throws OwnerNotFoundException, BikeDetailsNotFoundException;

}