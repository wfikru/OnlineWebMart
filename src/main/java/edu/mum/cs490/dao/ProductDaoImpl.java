package edu.mum.cs490.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cs490.model.Category;
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
	public List<Product> getAvailableProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Product.class);
		List<Product> productList  = cr.add(Restrictions.gt("quantity", 0)).list();

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
	
	
	@Override
	public ArrayList<Product> listProductsByCategory(int catId) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.openSession();
		Criteria cr = session.createCriteria(Product.class);
		Criteria cr2 = session.createCriteria(Category.class);
		ArrayList<Category> categories =(ArrayList<Category>) cr2.add(Restrictions.eq("id", catId)).list();
		Category cat = categories.get(0);

		Criteria cr3 = cr.add(Restrictions.eq("category", cat));
		Criteria cr4 = cr.add(Restrictions.gt("quantity", 0));
		 ArrayList<Product> list= (ArrayList<Product>) cr3.add(Restrictions.gt("quantity", 0)).list();
//		List<Customer> customerList = session.createCriteria(Customer.class)
//				.list();
//
//		String SQL_QUERY = " from Product p where p.category.id=?";
//		Query query = session.createQuery(SQL_QUERY);
//		query.setParameter(0, catId);
//		ArrayList<Product> list = (ArrayList<Product>) query.list();
		System.out.print("+++" + list.size());
		if ((list != null) && (list.size() > 0)) {
			return  list;
		}

		session.close();
		return null;
	}
	
	@Override
	public ArrayList<Product> getProductsByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Product.class);
		ArrayList<Product> products =(ArrayList<Product>) cr.add(Restrictions.eq("name", name).ignoreCase()).add(Restrictions.gt("quantity", 0)).list();
		return products;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Product> allProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<Product> productList = (ArrayList<Product>) session.createCriteria(Product.class)
				.list();

		return productList;
	}

	@Override
	public List<Product> getAllProductsByVendor(int vid) {
		Session session = this.sessionFactory.getCurrentSession();
		
		
			//List list = new ArrayList();
			//list.add(2);
		
			String sql = "SELECT p FROM PRODUCT p WHERE p.vendor.userId = :vid";
			//String sql = "Select vendor_id FROM PRODUCT WHERE vendor_id = :vid";
			Query query = session.createQuery(sql).setParameter("vid", vid);
	
			
			
			//String s = "SELECT p FROM PRODUCT p WHERE p.vendor.userId IN (:list)";
			//String s = "FROM PRODUCT WHERE vendor_id IN :list";
			//Query q = session.createQuery(s).setParameterList("list", list);
			//for (Product pr : (List<Product>)q.list())
			//	System.out.println("AAAAA+"+pr.getName());
			
			
	        return (List<Product>) query.list();
	        
	}


}
