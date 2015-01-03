package edu.mum.cs490.dao;

import edu.mum.cs490.model.SystemUser;

public interface SystemUserDAO {
	public SystemUser checkLogin(String userName, String userPassword) ;

}
