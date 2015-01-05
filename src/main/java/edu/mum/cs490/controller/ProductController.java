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

import edu.mum.cs490.model.Product;
import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.ProductService;


@Controller
public class ProductController {
	

	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);
	
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	

	@RequestMapping("/admin/vendor/product")
	public String showProducList(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "/admin/vendor/product";
	}
	@RequestMapping(value="/admin/vendor/product/edit", method = RequestMethod.GET)
	public String showProductEdit(Model model, @RequestParam("pid") String productId, HttpServletRequest request){				
		
		int id = Integer.parseInt(productId);
		model.addAttribute("product",productService.getProductById(id));
		return "/admin/vendor/product_edit";
	}
	@RequestMapping("/admin/vendor/product/add")
	public String showProductAdd(Model model){
		model.addAttribute("product", new Product());
		return "/admin/vendor/product_add";
	}
	@RequestMapping(value="/admin/vendor/product/update")
	public String doUpdateProduct(Model model,
			@ModelAttribute("product") Product product,
			@RequestParam("pid") String productId,
			HttpServletRequest request){	
		product.setId(Integer.parseInt(productId));
		productService.updateProduct(product);
		return "redirect:/admin/vendor/product";
	}
	@RequestMapping("/admin/vendor/product/doAdd")
	public String doAddProduct(@ModelAttribute Product product, BindingResult result, HttpServletRequest request){
		
		
		MultipartFile productImage = product.getProductImage();
		try {
			product.setImage(productImage.getBytes());
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		productService.addProduct(product);
		
		return "redirect:/admin/vendor/product";
		
	}
	@RequestMapping("/admin/vendor/product/delete")
	public String deleteProduct(@RequestParam("pid") String productId)
	{
		int id = Integer.parseInt(productId);
		productService.deleteProduct(id);
		return "redirect:/admin/vendor/product";
	}
}
