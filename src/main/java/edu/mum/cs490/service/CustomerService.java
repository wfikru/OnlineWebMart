package edu.mum.cs490.service;

import java.util.List;

import edu.mum.cs490.model.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer c);

	public void updateCustomer(Customer c);

	public List<Customer> allCustomers();

	public Customer getCustomerById(int id);

	public void removeCustomer(int id);
}
