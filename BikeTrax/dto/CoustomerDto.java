package com.BikeTrax.dto;

import java.util.List;
import java.util.Objects;

import com.BikeTrax.enums.Gender;

public class CoustomerDto {
	private int coustomerId;
	private String firstName;
	private String lastName;
	private Gender gender;
	private String city;
	private String state;
	private String mobileNumber;
	private String emailId;
	private List<BikeDto> bikeDtoList;

	public List<BikeDto> getBikeDtoList() {
		return bikeDtoList;
	}

	public void setBikeDtoList(List<BikeDto> bikeDtoList) {
		this.bikeDtoList = bikeDtoList;
	}

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

	@Override
	public String toString() {
		if (Objects.isNull(bikeDtoList)) {
			return "CoustomerDto [coustomerId=" + coustomerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", gender=" + gender + ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber
					+ ", emailId=" + emailId + "]";
		} else {
			return "CoustomerDto [coustomerId=" + coustomerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", gender=" + gender + ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber
					+ ", emailId=" + emailId + ", bikeDtoList=" + bikeDtoList + "]";

		}
	}

}
