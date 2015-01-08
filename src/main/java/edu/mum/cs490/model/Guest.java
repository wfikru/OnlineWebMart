package edu.mum.cs490.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "GUEST")
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Embedded
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	@OneToOne//(cascade = CascadeType.PERSIST)
//	@Embedded
//	private CreditCard creditCard;
//
//	public CreditCard getCreditCard() {
//		return creditCard;
//	}
//
//	public void setCreditCard(CreditCard creditCard) {
//		this.creditCard = creditCard;
//	}
}
