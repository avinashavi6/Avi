package com.capgeminijpa.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String houseNo;
	private String streetName;
	private String city;
	private long pincode;

	public Address() {
	}

	public Address(String houseNo, String streetName, String city, long pincode) {
		super();
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", streetName=" + streetName + ", city=" + city + ", pincode=" + pincode
				+ "]";
	}

}
