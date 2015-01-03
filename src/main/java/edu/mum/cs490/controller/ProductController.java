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
@RequestMapping("/product")
public class ProductController {
	

	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);
	
	
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/addit")
	public String addProduct(@ModelAttribute Product product, BindingResult result, HttpServletRequest request){
		
		
		MultipartFile productImage = product.getProductImage();
	
		
		
		try {
			product.setImage(productImage.getBytes());
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");

	/*	
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
		
		
		productService.addProduct(product);
		
		return "redirect:/product/list";
		
	}
	
	@RequestMapping("/add")
	public String addProductPage(Model model){
		model.addAttribute("product", new Product());
		return "registerProduct";
	}
	
	@RequestMapping("/list")
	public String producList(Model model){
		model.addAttribute("products", productService.getAllProducts());
		//for(Product p: productService.getAllProducts())
		//	System.out.println(p.getCategory());
		return "products";
	}
	
	
	
	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam("pid") String productId)
	{
		int id = Integer.parseInt(productId);
		try{
			productService.deleteProduct(id);
		}
		catch(Exception ex)
		{
			System.out.print("eeeee msg"+ ex);
			return "home";
		}
		return "redirect:/product/list";
	}
	
	
	
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String editApplication(Model model, @RequestParam("pid") String productId,
			HttpServletRequest request){				
		
		int id = Integer.parseInt(productId);
		
		try{
			model.addAttribute("product",productService.getProductById(id));
			//System.out.println("PNAME: "+productService.getProductById(id).getName());
		}
		catch(Exception ex)
		{
			System.out.print("eeeee msg"+ ex);
			return "redirect:/product/list";
		}

		//return "redirect:/product/list";
		return "editProduct";
	}

	@RequestMapping(value="/update")
	public String updateProduct(Model model,
			@ModelAttribute("product") Product product,
			@RequestParam("pid") String productId,
			HttpServletRequest request){				

		product.setId(Integer.parseInt(productId));
		productService.updateProduct(product);
		return "redirect:/product/list";
	}
	
	
	
	
	

}
