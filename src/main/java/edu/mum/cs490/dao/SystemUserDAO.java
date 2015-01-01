package edu.mum.cs490.dao;

import org.springframework.stereotype.Repository;

import edu.mum.cs490.model.SystemUser;

public interface SystemUserDAO {
	public SystemUser checkLogin(String userName, String userPassword) ;

}
