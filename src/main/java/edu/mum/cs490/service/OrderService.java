package edu.mum.cs490.service;

import java.util.ArrayList;

import edu.mum.cs490.model.Order;

public interface OrderService {
public ArrayList<Order> getOrdersByCustomer(int custId);
public ArrayList<Order> getAllOrders();

}
