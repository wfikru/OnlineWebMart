package edu.mum.cs490.dao;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs490.model.Category;
import edu.mum.cs490.model.Product;

public interface CategoryDAO {
	public ArrayList<Category> listCategories();

	public void addCategory(Category category);

	public List<Category> getAllCategories();

	public void deleteCategory(int pid);

	public Category getCategoryById(int pid);

	public void updateCategory(Category category);
}
