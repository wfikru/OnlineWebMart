package edu.mum.cs490.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.dao.SystemUserDAO;
import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;

@Service
@Transactional
public class SystemUserServiceImpl implements SystemUserService {

	@Autowired
	private SystemUserDAO userDAO;

	@Override
	public SystemUser checkLogin(String userName, String userPassword) {
		return userDAO.checkLogin(userName, userPassword);
	}

	@Override
	public void addUser(SystemUser user) {
		this.userDAO.addUser(user);

	}

	@Override
	public void updateUser(SystemUser user) {
		this.userDAO.updateUser(user);

	}

	@Override
	public List<SystemUser> allUsers() {
		return this.userDAO.allUsers();
	}

	@Override
	public SystemUser getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	public void removeUser(int id) {
		this.userDAO.removeUser(id);

	}

	@Override
	public List<Customer> allCustomerUsers() {
		return this.userDAO.allCustomerUsers(); 
	}

	@Override
	public List<Vendor> allVendorUsers() {
		return this.userDAO.allVendorUsers();
	}

}
