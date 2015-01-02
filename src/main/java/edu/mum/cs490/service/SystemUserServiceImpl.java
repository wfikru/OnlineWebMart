package edu.mum.cs490.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs490.dao.SystemUserDAO;
import edu.mum.cs490.model.SystemUser;

@Service
public class SystemUserServiceImpl implements SystemUserService {
	
	@Autowired
	SystemUserDAO userDAO;
	
	public SystemUser loginCheck(String userName, String password) {
		return userDAO.checkLogin(userName, password);
	}
}
