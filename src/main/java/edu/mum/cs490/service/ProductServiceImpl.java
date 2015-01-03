package edu.mum.cs490.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




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
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
		
	}

}
