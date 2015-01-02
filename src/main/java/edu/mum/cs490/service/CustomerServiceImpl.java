package edu.mum.cs490.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import edu.mum.cs490.dao.Customerdao;
import edu.mum.cs490.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private Customerdao customerdoa;

	public void setPersonDAO(Customerdao customerdoa) {
		this.customerdoa = customerdoa;
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public void addCustomer(Customer c) {
		this.customerdoa.addCustomer(c);

	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public void updateCustomer(Customer c) {
		this.customerdoa.updateCustomer(c);

	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public List<Customer> allCustomers() {
		return this.customerdoa.allCustomers();
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public Customer getCustomerById(int id) {
		return this.customerdoa.getCustomerById(id);
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public void removeCustomer(int id) {
		this.customerdoa.removeCustomer(id);
	}

}
