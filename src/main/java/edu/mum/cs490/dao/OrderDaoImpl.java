package edu.mum.cs490.dao;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.asn1.isismtt.x509.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Order;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.SystemUser;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public SystemUser getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SystemUser c = (SystemUser) session.load(SystemUser.class, new Integer(id));

		return c;
	}
	
	@Override
	public ArrayList<Order> getOrdersByCustomer(int custId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Order.class);
//		Criteria cr2 = session.createCriteria(SystemUser.class);
		SystemUser c = getCustomerById(custId);

		return (ArrayList<Order>) cr.add(Restrictions.eq("user", c)).list();
	}
	
	@Override
	public ArrayList<Order> allOrders() {
		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<Order> orders = (ArrayList<Order>) session.createCriteria(Order.class).list();
		System.out.print("&&&&&&&&"+orders.get(0).getTotal());
		return orders;
	}


}
