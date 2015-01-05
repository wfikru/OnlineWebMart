package edu.mum.cs490.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.h2.constant.SysProperties;
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
import edu.mum.cs490.model.Product;
import edu.mum.cs490.service.CategoryService;
import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.ProductService;


@Controller
public class ProductController {
	

	//private static final Logger logger = LoggerFactory
	//		.getLogger(ProductController.class);
	

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/admin/vendor/product")
	public String showProducList(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "/admin/vendor/product";
	}
	@RequestMapping(value="/admin/vendor/product/edit", method = RequestMethod.GET)
	public String showProductEdit(Model model, @RequestParam("pid") String productId, HttpServletRequest request){				
		System.out.println("prodddddd+++++"+productId);
		int id = Integer.parseInt(productId);
		model.addAttribute("product",productService.getProductById(id));
		model.addAttribute("categories", categoryService.listCategories());	
		
		System.out.println("PPPPP+++"+productService.getProductById(id).getName());
		return "/admin/vendor/product_edit";
	}
	@RequestMapping("/admin/vendor/product/add")
	public String showProductAdd(Model model){
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryService.listCategories());	
		return "/admin/vendor/product_add";
	}
	@RequestMapping(value="/admin/vendor/product/update")
	public String doUpdateProduct(Model model,
			@Valid @ModelAttribute("product") Product product, BindingResult result,
			@RequestParam("pid") String productId,
			HttpServletRequest request){	
		MultipartFile productImage = product.getProductImage();
	
		
		try {
			product.setImage(productImage.getBytes());
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		
		if (result.hasErrors()) {
			System.out.println("/admin/vendor/product/edit?pid="+productId);
			return "redirect:/admin/vendor/product/edit?pid="+productId;
			
			
		} else {
			product.setId(Integer.parseInt(productId));
			productService.updateProduct(product);
			return "redirect:/admin/vendor/product";
		}
		

	}
	@RequestMapping("/admin/vendor/product/doAdd")
	public String doAddProduct( @Valid @ModelAttribute Product product, BindingResult result, HttpServletRequest request){
		
		
		MultipartFile productImage = product.getProductImage();
		try {
			product.setImage(productImage.getBytes());
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}

	/*	String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");

		
		if (productImage != null && !productImage.isEmpty()) {
			try {
				
				Random random = new Random();
				//Math.abs(random.nextInt())
				
				productImage.transferTo(new File(rootDirectory
						+ "\\resources\\images\\" + product.getId() + ".png"));

			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		*/
		
		if (result.hasErrors()) {
			return "/admin/vendor/product_add";
		} else {
			productService.addProduct(product);
			
			return "redirect:/admin/vendor/product";
		}
		
		
		
	}

	
	@RequestMapping(value="/admin/vendor/product/pic")
	public void getPic(Model model,
			@ModelAttribute("product") Product product,
			@RequestParam("pid") String productId,
			HttpServletRequest request, HttpServletResponse response){
		
		Product p = productService.getProductById(Integer.parseInt(productId));
		
		try {
			byte[] bytes = p.getImage();
			if (bytes != null && bytes.length > 0) {

				 response.setContentType("image/jpg");
				 response.getOutputStream().write(bytes); 
				 response.getOutputStream().flush();
				 response.getOutputStream().close();
				}
	
			
			
		} catch (IOException e1) {
			System.out.print("eeeee msg"+ e1);
			//e1.printStackTrace();
		}
		
	
		
		
	}
	
	
	@RequestMapping("/admin/vendor/product/delete")
	public String deleteProduct(@RequestParam("pid") String productId)
	{
		int id = Integer.parseInt(productId);
		productService.deleteProduct(id);
		return "redirect:/admin/vendor/product";
	}

}
