package edu.mum.cs490.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.model.OrderItem;

@Repository
@Transactional
public class OrderItemdaoImpl implements OrderItemdao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addOrderItem(OrderItem o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(o);
		
	}

}
