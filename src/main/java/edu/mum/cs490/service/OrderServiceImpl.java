package edu.mum.cs490.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.dao.OrderDao;
import edu.mum.cs490.model.Order;

@Service
public class OrderServiceImpl implements OrderService{
@Autowired
OrderDao orderDao;

	@Override
	@Transactional
	public ArrayList<Order> getOrdersByCustomer(int custId)
	{
		return orderDao.getOrdersByCustomer(custId);
	}

}
