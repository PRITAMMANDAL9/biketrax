package com.BikeTrax.entity;

import java.util.ArrayList;
import java.util.List;

import com.BikeTrax.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "coustomer_table")
public class Coustomer {
	@Id
	private int coustomerId;
	@Column(name = "frist_name", nullable = false, updatable = false, insertable = true)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "state", nullable = false)
	private String state;
	@Column(name = "mobile_Number", nullable = false, length = 10)
	private String mobileNumber;
	@Column(name = "email_Id", nullable = false)
	private String emailId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "coustomer", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Bike> bikeList = new ArrayList<Bike>();

	public int getCoustomerId() {
		return coustomerId;
	}

	public void setCoustomerId(int coustomerId) {
		this.coustomerId = coustomerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Bike> getBikeList() {
		return bikeList;
	}

	public void setBikeList(List<Bike> bikeList) {
		this.bikeList = bikeList;
	}

	@Override
	public String toString() {
		return "Coustomer [coustomerId=" + coustomerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + "]";
	}

}
