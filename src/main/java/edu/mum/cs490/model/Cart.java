package edu.mum.cs490.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@OneToMany
	private List<Product> products = new ArrayList<Product>();
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	private double grandTotal;
	
	
	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (Id != other.Id)
			return false;
		return true;
	}

}
