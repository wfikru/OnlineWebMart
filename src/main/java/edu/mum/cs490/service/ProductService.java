package edu.mum.cs490.service;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs490.model.Product;

public interface ProductService {

	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public void deleteProduct(int pid);
	public Product getProductById(int pid);
	public void updateProduct(Product product);
	public ArrayList<Product> listProductsByCriteria(int id);
	public ArrayList<Product> getProductsByName(String name);
	public ArrayList<Product> allProducts();
	public List<Product> getAvailableProducts();
	public ArrayList<Product> find(String name);
	
}
