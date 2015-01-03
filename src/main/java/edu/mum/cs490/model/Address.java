package edu.mum.cs490.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String state;
	private String street;
	private String zip;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
}