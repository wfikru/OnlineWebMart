package edu.mum.cs490.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cs490.model.SystemUser;

@Repository
public class SystemUserDAOImpl implements SystemUserDAO{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public SystemUser checkLogin(String userName, String password) {
	      Session session = sessionFactory.openSession();
	      boolean userFound = false;
	      //Query using Hibernate Query Language
	      String SQL_QUERY =" from SystemUser u where u.username=? and u.password=?";
	      Query query = session.createQuery(SQL_QUERY);
	      query.setParameter(0,userName);
	      query.setParameter(1,password);
	      List list = query.list();

	      if ((list != null) && (list.size() > 0)) {
	              return (SystemUser) list.get(0);
	      }

	      session.close();
	      return null;
//		SystemUser user = new SystemUser();
//		user.setId(1);
//		user.setUsername("a");
//		System.out.print(user.getUsername());
//		user.setPassword("a");
//		user.setRole("customer");
//		if(userName.equals(user.getUsername()) && password.equals(user.getPassword())){
//		return user;
//		}
//		else
//			return new SystemUser();
	}
}
