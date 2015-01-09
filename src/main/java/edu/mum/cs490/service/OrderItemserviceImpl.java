package edu.mum.cs490.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.dao.OrderItemdao;
import edu.mum.cs490.model.OrderItem;

@Service
@Transactional
public class OrderItemserviceImpl implements OrderItemservice{
	@Autowired
	private OrderItemdao orderItemDao;
	
	public void addOrderItem(OrderItem o){
		orderItemDao.addOrderItem(o);
	}
}
