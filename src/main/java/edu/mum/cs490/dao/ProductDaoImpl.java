package edu.mum.cs490.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productList = session.createCriteria(Product.class).list();

		return productList;
	}

	@Override
	public void deleteProduct(int pid) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Product p = (Product) session.load(Product.class, new Integer(pid));
		if (null != p) {
			session.delete(p);
		}
		
				
	}

	@Override
	public Product getProductById(int pid) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(pid));
		System.out.println("CATID: "+p.getCategory().getId());
		return p;
		
	}

	@Override
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		
	}
	
	
	

}
