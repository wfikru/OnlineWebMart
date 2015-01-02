package edu.mum.cs490.model;

import javax.persistence.Entity;

@Entity(name = "VENDOR")
public class Vendor extends SystemUser {
	private String name;
	private Byte[] image;
	private String address;
	private double vendorCharge;

}
