package edu.mum.cs490.service;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs490.model.Category;

public interface CategoryService {
	public void addCategory(Category category);
	public List<Category> getAllCategories();
	public void deleteCategory(int cid);
	public Category getCategoryById(int cid);
	public void updateCategory(Category category);
	public ArrayList<Category> listCategories();
	
}
