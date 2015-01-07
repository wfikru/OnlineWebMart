package edu.mum.cs490.dao;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs490.model.Product;

public interface ProductDao {

	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public List<Product> getAllProductsByVendor(int vid);
	public void deleteProduct(int pid);
	public Product getProductById(int pid);
	public void updateProduct(Product product);
	public ArrayList<Product> listProductsByCategory(int catId);
	public ArrayList<Product> getProductsByName(String name);
	public List<Product> getAvailableProducts();
	public ArrayList<Product> allProducts();
	
}
