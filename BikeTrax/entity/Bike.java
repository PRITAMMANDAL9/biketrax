package com.BikeTrax.entity;

import java.time.LocalDate;

import com.BikeTrax.enums.Brand;
import com.BikeTrax.enums.Model;
import com.BikeTrax.enums.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bike_table")
public class Bike {
	@Enumerated(value = EnumType.STRING)
	@Column(name = "vehical_Type", nullable = false)
	private Type vehicalType;
	@Id
	@Column(name = "registration_Id", nullable = false, unique = true)
	private int registrationId;
	@Column(name = "bike_Purches_Date", nullable = false)
	private LocalDate bikePurchesDate;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "model", nullable = false)
	private Model model;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "brand", nullable = false)
	private Brand brand;
	@Column(name = "color", nullable = false)
	private String color;
	@Column(name = "manufacturing_Year", nullable = false)
	private LocalDate manufacturingYear;
	@ManyToOne(optional = false)
	@JoinColumn(name = "coustomer_Id", referencedColumnName = "coustomerId", nullable = false)
	private Coustomer coustomer;

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

	public Coustomer getCoustomer() {
		return coustomer;
	}

	public void setCoustomer(Coustomer coustomer) {
		this.coustomer = coustomer;
	}

	@Override
	public String toString() {
		return "Bike [vehicalType=" + vehicalType + ", registrationId=" + registrationId + ", bikePurchesDate="
				+ bikePurchesDate + ", model=" + model + ", brand=" + brand + ", color=" + color
				+ ", manufacturingYear=" + manufacturingYear + ", coustomer=" + coustomer + "]";
	}

}
