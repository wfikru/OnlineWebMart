package edu.mum.cs490.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity(name = "CUSTOMER")
public class Customer extends SystemUser {
	
	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;

	@Embedded
	private Address address;
	
	@OneToOne
	private Cart cart;
	
//	@OneToMany
//
//	ArrayList<Order> orders= new ArrayList<Order>();
//	
//	
//	public ArrayList<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(ArrayList<Order> orders) {
//		this.orders = orders;
//	}

	@OneToOne(cascade = CascadeType.PERSIST)
	private CreditCard creditCard;

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}	

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
