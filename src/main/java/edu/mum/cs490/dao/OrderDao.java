package edu.mum.cs490.dao;

import java.util.ArrayList;

import edu.mum.cs490.model.Order;

public interface OrderDao {
	public ArrayList<Order> getOrdersByCustomer(int custId);

	public ArrayList<Order> allOrders();

	public void addOrder(Order o);
	
	public ArrayList<Order> getOrdersByVendor(int vendorId);
}
