package edu.mum.cs490.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;

@Repository
@Transactional
public class SystemUserDAOImpl implements SystemUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SystemUser checkLogin(String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		boolean userFound = false;
		// Query using Hibernate Query Language
		String SQL_QUERY = " from SystemUser u where u.email=? and u.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, email);
		query.setParameter(1, password);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			return (SystemUser) list.get(0);
		}

		// session.close();
		return null;
	}

	@Override
	public void addUser(SystemUser user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
	}

	@Override
	public void updateUser(SystemUser user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);

	}

	@Override
	public SystemUser getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.load(SystemUser.class, new Integer(id));
		return null;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SystemUser user = (SystemUser) session.load(SystemUser.class,
				new Integer(id));
		if (user != null) {
			session.delete(user);
		}
	}

	@Override
	public List<SystemUser> allUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(SystemUser.class).list();

	}

	@Override
	public List<Customer> allCustomerUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(Customer.class).list();
	}

	@Override
	public List<Vendor> allVendorUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(Vendor.class).list();
	}

}
