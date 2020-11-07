package com.sow.template2.model;

import lombok.Data;

@Data
public class Address {

	private String line1;
	private String line2;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
	public Address() {	
	}
	
	public Address(String line1, String line2, String city, String state, String zipcode, String country) {	
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;		
	}
}
