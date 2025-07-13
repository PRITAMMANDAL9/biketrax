package com.BikeTrax.service.imp;

import java.util.Objects;

import com.BikeTrax.config.PropertiesConfig;
import com.BikeTrax.dto.BikeDto;
import com.BikeTrax.dto.CoustomerDto;
import com.BikeTrax.entity.Bike;
import com.BikeTrax.entity.Coustomer;
import com.BikeTrax.enums.Model;
import com.BikeTrax.exception.BikeDetailsNotFoundException;
import com.BikeTrax.exception.OwnerNotFoundException;
import com.BikeTrax.repository.CoustomerRepo;
import com.BikeTrax.repository.imp.CoustomerRpoIm;
import com.BikeTrax.service.CoustomerService;
import com.BikeTrax.util.MapperUtil;

public class CoustomerServiceImp implements CoustomerService {
	private CoustomerRepo coustomerRepo;
	private static final String Coustomer_NOT_FOUND = "coustomer.not.found";
	private static final String Bike_NOT_FOUND = "bike.not.found";
	private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();

	public CoustomerServiceImp() {

		this.coustomerRepo = new CoustomerRpoIm();
	}

	@Override
	public void saveCoustomer(CoustomerDto coustomerDto) {
		Coustomer coustomer = MapperUtil.convertCoustomerDtoToEntity(coustomerDto);
		coustomerRepo.saveCoustomer(coustomer);

	}

	@Override
	public CoustomerDto findCoustomer(int coustomerId) throws OwnerNotFoundException {
		Coustomer coustomer = coustomerRepo.findCoustomer(coustomerId);
		if (Objects.isNull(coustomer)) {
			throw new OwnerNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Coustomer_NOT_FOUND), coustomerId));
		}
		return MapperUtil.convertCoustomerEntityToDto(coustomer);
	}

	@Override
	public CoustomerDto findCoustomewithoutBike(int coustomerId) throws OwnerNotFoundException {
		Coustomer coustomer = coustomerRepo.findCoustomewithoutBike(coustomerId);
		if (Objects.isNull(coustomer)) {
			throw new OwnerNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Coustomer_NOT_FOUND), coustomerId));
		}
		return MapperUtil.convertCoustomerEntityToDtoWithoutBike(coustomer);
	}

	@Override
	public void updateBikeDetails(int coustomerId, int registationtId, Model model)
			throws OwnerNotFoundException, BikeDetailsNotFoundException {
		Coustomer coustomer = coustomerRepo.findCoustomer(coustomerId);
		if (Objects.isNull(coustomer)) {
			throw new OwnerNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Coustomer_NOT_FOUND), coustomerId));
		} else if (coustomer.getBikeList().stream().filter(bike -> bike.getRegistrationId() == registationtId)
				.findFirst().isEmpty()) {
			throw new BikeDetailsNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Bike_NOT_FOUND), registationtId));
		} else {
			coustomerRepo.updateBikeDetails(coustomerId, registationtId, model);
		}

	}

	@Override
	public void deleteCoustomer(int coustomerId) throws OwnerNotFoundException {
		Coustomer coustomer = coustomerRepo.findCoustomer(coustomerId);
		if (Objects.isNull(coustomer)) {
			throw new OwnerNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Coustomer_NOT_FOUND), coustomerId));
		}
		coustomerRepo.deleteCoustomer(coustomerId);
	}

	@Override
	public void addBike(int coustomerId, BikeDto bikeDto) throws OwnerNotFoundException {
		Coustomer coustomer = coustomerRepo.findCoustomer(coustomerId);
		if (Objects.isNull(coustomer)) {
			throw new OwnerNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Coustomer_NOT_FOUND), coustomerId));
		}
		Bike bike = MapperUtil.convertBikeDtoToEntity(bikeDto);
		bike.setCoustomer(coustomer);
		coustomerRepo.addBike(coustomerId, bike);

	}

	@Override
	public void removeBike(int coustomerId, int registationtId)
			throws OwnerNotFoundException, BikeDetailsNotFoundException {
		Coustomer coustomer = coustomerRepo.findCoustomer(coustomerId);
		if (Objects.isNull(coustomer)) {
			throw new OwnerNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Coustomer_NOT_FOUND), coustomerId));
		} else if (coustomer.getBikeList().stream().filter(bike -> bike.getRegistrationId() == registationtId)
				.findFirst().isEmpty()) {
			throw new BikeDetailsNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(Bike_NOT_FOUND), registationtId));
		} else {
			coustomerRepo.deleteBike(coustomerId, registationtId);
		}

	}

}
