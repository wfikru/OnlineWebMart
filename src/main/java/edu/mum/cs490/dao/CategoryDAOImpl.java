package edu.mum.cs490.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cs490.model.Category;
import edu.mum.cs490.model.Customer;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public ArrayList<Category> listCategories() {

		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<Category> cList = (ArrayList<Category>) session.createCriteria(Category.class).list();
		System.out.print(cList);
		return cList;

	}
}
