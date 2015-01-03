package edu.mum.cs490.dao;

import java.util.List;

import edu.mum.cs490.model.Product;

public interface ProductDao {

	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public void deleteProduct(int pid);
	public Product getProductById(int pid);
	public void updateProduct(Product product);
	
}
