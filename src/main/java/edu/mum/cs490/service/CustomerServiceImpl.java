package edu.mum.cs490.service;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public void addCustomer(Customer c) {
		this.customerdoa.addCustomer(c);

	}

	@Override
	@Transactional
	public void updateCustomer(Customer c) {
		this.customerdoa.updateCustomer(c);

	}

	@Override
	@Transactional
	public List<Customer> allCustomers() {
		return this.customerdoa.allCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerdoa.getCustomerById(id);
	}

	@Override
	@Transactional
	public void removeCustomer(int id) {
		this.customerdoa.removeCustomer(id);
	}

}
