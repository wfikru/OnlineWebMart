package edu.mum.cs490.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.cs490.model.Category;
import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.CategoryService;


@Controller
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	

	@RequestMapping("/admin/vendor/category")
	public String showProducList(Model model){
		model.addAttribute("categories", categoryService.getAllCategories());
		return "/admin/vendor/category";
	}
	@RequestMapping(value="/admin/vendor/category/edit", method = RequestMethod.GET)
	public String showCategoryEdit(Model model, @RequestParam("pid") String categoryId, HttpServletRequest request){				
		
		int id = Integer.parseInt(categoryId);
		
		model.addAttribute("category",categoryService.getCategoryById(id));
		return "/admin/vendor/category_edit";
	}
	@RequestMapping("/admin/vendor/category/add")
	public String showCategoryAdd(Model model){
		model.addAttribute("category", new Category());
		return "/admin/vendor/category_add";
	}
	@RequestMapping(value="/admin/vendor/category/update")
	public String doUpdateCategory(Model model,
			@ModelAttribute("category") Category category,
			@RequestParam("pid") String categoryId,
			HttpServletRequest request){	
		category.setId(Integer.parseInt(categoryId));
		categoryService.updateCategory(category);
		return "redirect:/admin/vendor/category";
	}
	@RequestMapping("/admin/vendor/category/doAdd")
	public String doAddCategory(@ModelAttribute Category category, BindingResult result, HttpServletRequest request){
		
		
		categoryService.addCategory(category);
		
		return "redirect:/admin/vendor/category";
		
	}
	@RequestMapping("/admin/vendor/category/delete")
	public String deleteCategory(@RequestParam("pid") String categoryId)
	{
		int id = Integer.parseInt(categoryId);
		categoryService.deleteCategory(id);
		return "redirect:/admin/vendor/category";
	}
}
