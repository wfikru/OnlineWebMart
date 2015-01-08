package edu.mum.cs490.service;

import java.util.List;

import edu.mum.cs490.model.Guest;

public interface Guestservice {

	public void addGuest(Guest g);

	public void updateGuest(Guest g);

	public List<Guest> allGuest();

	public Guest getGuestById(int id);

	public void removeGuest(int id);
}
