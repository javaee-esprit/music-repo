package org.esprit.javaee.persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Address implements Serializable{
	
	private static final long serialVersionUID = -4533867204761471196L;
	
	
	private String street;
	private String city;
	private String zipCode;
	
	public Address() {
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	

}
