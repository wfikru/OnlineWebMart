package edu.mum.cs490.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ADMIN")
public class Admin {//extends SystemUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	
}
