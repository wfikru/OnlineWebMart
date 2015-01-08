package edu.mum.cs490.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.dao.Guestdao;
import edu.mum.cs490.model.Guest;

@Service
@Transactional
public class GuestserviceImpl implements Guestservice {

	@Autowired
	private Guestdao guestDao;

	@Override
	public void addGuestr(Guest g) {
		guestDao.addGuestr(g);

	}

	@Override
	public void updateGuest(Guest g) {
		guestDao.updateGuest(g);

	}

	@Override
	public List<Guest> allGuest() {
		return guestDao.allGuest();
	}

	@Override
	public Guest getGuestById(int id) {
		return guestDao.getGuestById(id);
	}

	@Override
	public void removeGuest(int id) {
		guestDao.removeGuest(id);
	}

}
