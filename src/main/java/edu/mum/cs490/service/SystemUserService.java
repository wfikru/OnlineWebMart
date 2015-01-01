package edu.mum.cs490.service;

import org.springframework.stereotype.Service;

import edu.mum.cs490.model.SystemUser;


public interface SystemUserService {
	public SystemUser loginCheck(String userName, String password);
	
}
