package com.BikeTrax.util;

import java.util.List;
import java.util.stream.Collectors;

import com.BikeTrax.dto.BikeDto;
import com.BikeTrax.dto.CoustomerDto;
import com.BikeTrax.entity.Bike;
import com.BikeTrax.entity.Coustomer;

public class MapperUtil {

	public static CoustomerDto convertCoustomerEntityToDto(Coustomer coustomer) {
		CoustomerDto coustomerDto = new CoustomerDto();
		coustomerDto.setCoustomerId(coustomer.getCoustomerId());
		coustomerDto.setFirstName(coustomer.getFirstName());
		coustomerDto.setLastName(coustomer.getLastName());
		coustomerDto.setGender(coustomer.getGender());
		coustomerDto.setCity(coustomer.getCity());
		coustomerDto.setState(coustomer.getState());
		coustomerDto.setMobileNumber(coustomer.getMobileNumber());
		coustomerDto.setEmailId(coustomer.getEmailId());
		List<BikeDto> bikeDtoList = coustomer.getBikeList().stream()
				.map(MapperUtil::convertBikeEntityToDtoWithoutCoustomer).collect(Collectors.toList());
		coustomerDto.setBikeDtoList(bikeDtoList);
		return coustomerDto;
	}

	public static BikeDto convertBikeEntityToDtoWithoutCoustomer(Bike bike) {
		BikeDto bikeDto = new BikeDto();
		bikeDto.setVehicalType(bike.getVehicalType());
		bikeDto.setRegistrationId(bike.getRegistrationId());
		bikeDto.setBikePurchesDate(bike.getBikePurchesDate());
		bikeDto.setModel(bike.getModel());
		bikeDto.setBrand(bike.getBrand());
		bikeDto.setColor(bike.getColor());
		bikeDto.setManufacturingYear(bike.getManufacturingYear());
		return bikeDto;
	}

	public static BikeDto convertBikeEntityToDto(Bike bike) {
		BikeDto bikeDto = new BikeDto();
		bikeDto.setVehicalType(bike.getVehicalType());
		bikeDto.setRegistrationId(bike.getRegistrationId());
		bikeDto.setBikePurchesDate(bike.getBikePurchesDate());
		bikeDto.setModel(bike.getModel());
		bikeDto.setBrand(bike.getBrand());
		bikeDto.setColor(bike.getColor());
		bikeDto.setManufacturingYear(bike.getManufacturingYear());

		CoustomerDto coustomerDto = convertCoustomerEntityToDtoWithoutBike(bike.getCoustomer());
		bikeDto.setCoustomerDto(coustomerDto);
		return bikeDto;
	}

	public static CoustomerDto convertCoustomerEntityToDtoWithoutBike(Coustomer coustomer) {
		CoustomerDto coustomerDto = new CoustomerDto();
		coustomerDto.setCoustomerId(coustomer.getCoustomerId());
		coustomerDto.setFirstName(coustomer.getFirstName());
		coustomerDto.setLastName(coustomer.getLastName());
		coustomerDto.setGender(coustomer.getGender());
		coustomerDto.setCity(coustomer.getCity());
		coustomerDto.setState(coustomer.getState());
		coustomerDto.setMobileNumber(coustomer.getMobileNumber());
		coustomerDto.setEmailId(coustomer.getEmailId());
		return coustomerDto;
	}

	public static Coustomer convertCoustomerDtoToEntity(CoustomerDto coustomerDto) {
		Coustomer coustomer = new Coustomer();
		coustomer.setCoustomerId(coustomerDto.getCoustomerId());
		coustomer.setFirstName(coustomerDto.getFirstName());
		coustomer.setLastName(coustomerDto.getLastName());
		coustomer.setGender(coustomerDto.getGender());
		coustomer.setCity(coustomerDto.getCity());
		coustomer.setState(coustomerDto.getState());
		coustomer.setMobileNumber(coustomerDto.getMobileNumber());
		coustomer.setEmailId(coustomerDto.getEmailId());
		List<Bike> bikeList = coustomerDto.getBikeDtoList().stream().map(bikeDto -> {
			Bike bike = convertBikeDtoToEntity(bikeDto);
			bike.setCoustomer(coustomer);
			return bike;
		}).collect(Collectors.toList());
		coustomer.setBikeList(bikeList);
		return coustomer;
	}

	public static Bike convertBikeDtoToEntity(BikeDto bikeDto) {
		Bike bike = new Bike();
		bike.setVehicalType(bikeDto.getVehicalType());
		bike.setRegistrationId(bikeDto.getRegistrationId());
		bike.setBikePurchesDate(bikeDto.getBikePurchesDate());
		bike.setModel(bikeDto.getModel());
		bike.setBrand(bikeDto.getBrand());
		bike.setColor(bikeDto.getColor());
		bike.setManufacturingYear(bikeDto.getManufacturingYear());
		return bike;
	}

}
