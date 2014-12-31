package edu.mum.cs490.service;

import java.util.List;

import edu.mum.cs490.dao.Customerdoa;
import edu.mum.cs490.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private Customerdoa customerdoa;

	public void setPersonDAO(Customerdoa customerdoa) {
		this.customerdoa = customerdoa;
	}

	@Override
	public void addCustomer(Customer c) {
		this.customerdoa.addCustomer(c);

	}

	@Override
	public void updateCustomer(Customer c) {
		this.customerdoa.updateCustomer(c);

	}

	@Override
	public List<Customer> allCustomers() {
		return this.customerdoa.allCustomers();
	}

	@Override
	public Customer getCustomerById(int id) {
		return this.customerdoa.getCustomerById(id);
	}

	@Override
	public void removeCustomer(int id) {
		this.customerdoa.removeCustomer(id);
	}

}
