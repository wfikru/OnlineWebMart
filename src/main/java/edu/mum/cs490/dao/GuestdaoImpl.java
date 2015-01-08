package edu.mum.cs490.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Guest;

@Repository
@Transactional
public class GuestdaoImpl implements Guestdao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addGuestr(Guest g) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(g);
		
	}

	@Override
	public void updateGuest(Guest g) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(g);
		
	}

	@Override
	public List<Guest> allGuest() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Guest> guestList = session.createCriteria(Guest.class)
				.list();

		return guestList;
	}

	@Override
	public Guest getGuestById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Guest g = (Guest) session.load(Guest.class, new Integer(id));

		return g;
	}

	@Override
	public void removeGuest(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Guest c = (Guest) session.load(Guest.class, new Integer(id));
		if (null != c) {
			session.delete(c);
		}
		
	}

	
}
