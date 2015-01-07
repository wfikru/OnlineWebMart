package edu.mum.cs490.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;

public interface SystemUserService {

	public SystemUser checkLogin(String userName, String userPassword);

	public void addUser(SystemUser user);

	public void updateUser(SystemUser user);

	public List<SystemUser> allUsers();
	public List<Customer> allCustomerUsers();

	public List<Vendor> allVendorUsers();
	public SystemUser getUserById(int id);

	public void removeUser(int id);
}
