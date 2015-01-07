package edu.mum.cs490.model;

import javax.persistence.Entity;

@Entity
public class Visitor extends SystemUser {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
