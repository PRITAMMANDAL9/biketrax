package com.BikeTrax.service.imp;

import java.util.Objects;

import com.BikeTrax.config.PropertiesConfig;
import com.BikeTrax.dto.BikeDto;
import com.BikeTrax.entity.Bike;
import com.BikeTrax.exception.BikeDetailsNotFoundException;
import com.BikeTrax.repository.BikeRepo;
import com.BikeTrax.repository.imp.BikeRepoIm;
import com.BikeTrax.service.BikeService;
import com.BikeTrax.util.MapperUtil;

public class BikeServiceImp implements BikeService {
	private BikeRepo bikeRpo;
	private static final String Bike_NOT_FOUND = "pet.not.found";
	private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();

	public BikeServiceImp() {

		this.bikeRpo = new BikeRepoIm();
	}

	@Override
	public BikeDto findBike(int registationId) throws BikeDetailsNotFoundException {
		Bike bike = bikeRpo.findBike(registationId);
		if (Objects.isNull(bike)) {
			throw new BikeDetailsNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Bike_NOT_FOUND), registationId));
		}
		return MapperUtil.convertBikeEntityToDto(bike);
	}

	@Override
	public BikeDto findBikewithoutCoustomer(int registationId) throws BikeDetailsNotFoundException {
		Bike bike = bikeRpo.findBike(registationId);
		if (Objects.isNull(bike)) {
			throw new BikeDetailsNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Bike_NOT_FOUND), registationId));
		}
		return MapperUtil.convertBikeEntityToDtoWithoutCoustomer(bike);
	}
}
