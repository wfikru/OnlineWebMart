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
public class CategoryDAOImpl implements CategoryDAO,  java.io.Serializable {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public ArrayList<Category> listCategories() {

		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<Category> cList = (ArrayList<Category>) session.createCriteria(Category.class).list();
		System.out.print(cList);
		return cList;

	}
	

	@Override
	public void addCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(category);
	}

	@Override
	public List<Category> getAllCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createCriteria(Category.class).list();

		return categoryList;
	}

	@Override
	public void deleteCategory(int pid) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Category p = (Category) session.load(Category.class, new Integer(pid));
		if (null != p) {
			session.delete(p);
		}
		
				
	}

	@Override
	public Category getCategoryById(int pid) {
		Session session = this.sessionFactory.getCurrentSession();
		Category p = (Category) session.load(Category.class, new Integer(pid));
		System.out.println(p.getName());
		return p;
		
	}

	@Override
	public void updateCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(category);
		
	}
}
