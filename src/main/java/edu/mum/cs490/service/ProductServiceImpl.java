package edu.mum.cs490.service;

import java.util.ArrayList;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.dao.ProductDao;
import edu.mum.cs490.model.Product;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public void addProduct(Product product) {
		
		productDao.addProduct(product);
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	@Transactional
	public void deleteProduct(int pid) {
		productDao.deleteProduct(pid);
		
	}

	@Override
	@Transactional
	public Product getProductById(int pid) {
		return productDao.getProductById(pid);
	}
	
	@Override
	@Transactional
	public List<Product> getAvailableProducts() {
		return productDao.getAvailableProducts();
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
		
	}
	@Override
	@Transactional
	public ArrayList<Product> listProductsByCriteria(int id) {
		// TODO Auto-generated method stub
		return productDao.listProductsByCategory(id);
	}
	
	@Override
	@Transactional
	public ArrayList<Product> getProductsByName(String name) {
		// TODO Auto-generated method stub
		return productDao.getProductsByName(name);
	}
	
	@Override
	@Transactional
	public ArrayList<Product> allProducts(){
		return productDao.allProducts();
	}
	
	@Override
	@Transactional
	public ArrayList<Product> find(String query) {
		// TODO Auto-generated method stub
		return productDao.find(query);
	}

	@Override
	@Transactional
	public List<Product> getAllProductsByVendor(int vid) {
		return productDao.getAllProductsByVendor(vid);
	}

}
