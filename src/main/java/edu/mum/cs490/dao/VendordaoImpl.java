package edu.mum.cs490.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.model.Vendor;

@Repository
@Transactional
public class VendordaoImpl implements Vendordao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addVendor(Vendor v) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(v);

	}

	@Override
	public void updateCustomer(Vendor v) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vendor> allVendors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendor getVendorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeVendor(int id) {
		// TODO Auto-generated method stub

	}

}
