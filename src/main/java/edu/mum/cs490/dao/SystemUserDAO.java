package edu.mum.cs490.dao;

import java.util.List;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;

public interface SystemUserDAO {

	public SystemUser checkLogin(String userName, String userPassword);

	public void addUser(SystemUser user);

	public void updateUser(SystemUser user);

	public List<SystemUser> allUsers();

	public List<Customer> allCustomerUsers();

	public List<Vendor> allVendorUsers();

	public SystemUser getUserById(int id);

	public void removeUser(int id);
}
