package edu.mum.cs490.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity(name = "CUSTOMER")
public class Customer extends SystemUser {

	@Column(name = "firstname")
	@Size(max = 10, min = 2, message = "first name length should be between 2 and 10")
	private String firstName;

	@Column(name = "lastname")
	@Size(max = 10, min = 2, message = "last name length should be between 2 and 10")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;

	@Embedded
	private Address address;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
