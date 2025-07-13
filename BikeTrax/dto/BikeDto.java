package com.BikeTrax.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.BikeTrax.enums.Brand;
import com.BikeTrax.enums.Model;
import com.BikeTrax.enums.Type;

public class BikeDto {
	private Type vehicalType;
	private int registrationId;
	private LocalDate bikePurchesDate;
	private Model model;
	private Brand brand;
	private String color;
	private LocalDate manufacturingYear;
	private CoustomerDto coustomerDto;

	public CoustomerDto getCoustomerDto() {
		return coustomerDto;
	}

	public void setCoustomerDto(CoustomerDto coustomerDto) {
		this.coustomerDto = coustomerDto;
	}

	public Type getVehicalType() {
		return vehicalType;
	}

	public void setVehicalType(Type vehicalType) {
		this.vehicalType = vehicalType;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public LocalDate getBikePurchesDate() {
		return bikePurchesDate;
	}

	public void setBikePurchesDate(LocalDate bikePurchesDate) {
		this.bikePurchesDate = bikePurchesDate;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDate getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(LocalDate manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	@Override
	public String toString() {
		if (Objects.isNull(coustomerDto)) {
			return "BikeDto [vehicalType=" + vehicalType + ", registrationId=" + registrationId + ", bikePurchesDate="
					+ bikePurchesDate + ", model=" + model + ", brand=" + brand + ", color=" + color
					+ ", manufacturingYear=" + manufacturingYear + "]";
		} else {
			return "BikeDto [vehicalType=" + vehicalType + ", registrationId=" + registrationId + ", bikePurchesDate="
					+ bikePurchesDate + ", model=" + model + ", brand=" + brand + ", color=" + color
					+ ", manufacturingYear=" + manufacturingYear + ", coustomerDto=" + coustomerDto + "]";
		}

	}

}
