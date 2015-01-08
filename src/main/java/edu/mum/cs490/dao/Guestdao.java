package edu.mum.cs490.dao;

import java.util.List;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Guest;

public interface Guestdao {

	public void addGuestr(Guest g);

	public void updateGuest(Guest g);

	public List<Guest> allGuest();

	public Guest getGuestById(int id);

	public void removeGuest(int id);
}
