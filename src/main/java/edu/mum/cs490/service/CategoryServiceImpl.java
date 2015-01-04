package edu.mum.cs490.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs490.dao.CategoryDAO;
import edu.mum.cs490.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	@Transactional
	public ArrayList<Category> listCategories() {
		// TODO Auto-generated method stub
		System.out.println("step service");
		return categoryDAO.listCategories();
	}

}
