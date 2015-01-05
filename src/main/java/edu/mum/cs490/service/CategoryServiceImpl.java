package edu.mum.cs490.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.dao.CategoryDAO;
import edu.mum.cs490.model.Category;
import edu.mum.cs490.model.Product;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO categoryDao;
	
	@Override
	@Transactional
	public ArrayList<Category> listCategories() {
		// TODO Auto-generated method stub
		System.out.println("step service");
		return categoryDao.listCategories();
	}
	

	@Override
	@Transactional
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	@Override
	@Transactional
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

	@Override
	@Transactional
	public void deleteCategory(int pid) {
		categoryDao.deleteCategory(pid);
		
	}

	@Override
	@Transactional
	public Category getCategoryById(int pid) {
		
		return categoryDao.getCategoryById(pid);
	}

	@Override
	@Transactional
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
		
	}
}
