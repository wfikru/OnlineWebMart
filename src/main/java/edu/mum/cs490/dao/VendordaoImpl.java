package edu.mum.cs490.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Vendor;

@Repository
@Transactional
public class VendordaoImpl implements Vendordao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addVendor(Vendor v) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(v);

	}

	@Override
	public void updateVendor(Vendor v) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(v);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> allVendors() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Vendor> vendorList = session.createCriteria(Vendor.class).list();
		return vendorList;
	}

	@Override
	public Vendor getVendorById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Vendor v = (Vendor) session.get(Vendor.class, new Integer(id));

		return v;
	}

	@Override
	public void removeVendor(int id) {
		// TODO Auto-generated method stub

	}

}
