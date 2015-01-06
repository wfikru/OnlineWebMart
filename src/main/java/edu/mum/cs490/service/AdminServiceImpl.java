package edu.mum.cs490.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.dao.AdminDao;
import edu.mum.cs490.dao.Customerdao;
import edu.mum.cs490.model.Admin;
import edu.mum.cs490.model.Customer;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public void addAdmin(Admin c) {
		this.adminDao.addAdmin(c);

	}
}
