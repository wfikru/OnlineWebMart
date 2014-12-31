package edu.mum.cs490.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.mum.cs490.model.Customer;

public class CustomerdaoImpl implements Customerdoa{

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCustomer(Customer c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		}

	@Override
	public void updateCustomer(Customer c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> allCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createCriteria(Customer.class).list();
		
		return customerList;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Customer c = (Customer) session.load(Customer.class, new Integer(id));
		
		return c;
	}

	@Override
	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer c = (Customer) session.load(Customer.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		
	}
}
