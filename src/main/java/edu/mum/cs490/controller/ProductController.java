package edu.mum.cs490.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.h2.constant.SysProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs490.model.Category;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.CategoryService;
import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.ProductService;
import edu.mum.cs490.service.VendorService;


@Controller
@SessionAttributes({ "user", "shoppingCart"})
public class ProductController {
	


	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private VendorService vendorService;
	
	
	
	@RequestMapping(value = "/product/search")
	public String doSearch(@ModelAttribute("query") String query,
			BindingResult result, ModelMap map) {
		ArrayList<Product> products = productService.find(query);
		ArrayList<Category> categories = new ArrayList<Category>();
		categories = categoryService.listCategories();
		
		map.addAttribute("products", products);
		map.addAttribute("query", query);
		map.addAttribute("categories", categories);
		
		return "/product/result";

	}
	@RequestMapping(value = "/product/search_by_cat")
	public String doSearchByCat(@ModelAttribute("id") int catid,
			BindingResult result, ModelMap map) {
		ArrayList<Product> products = productService.listProductsByCriteria(catid);
		ArrayList<Category> categories = new ArrayList<Category>();
		categories = categoryService.listCategories();
		
		
		map.addAttribute("products", products);
		map.addAttribute("query", "");
		map.addAttribute("categories", categories);
		
		return "/product/result";

	}
	
	@RequestMapping(value = "/product/search_all")
	public String doSearchAll(ModelMap map) {
		ArrayList<Product> products = productService.allProducts();
		ArrayList<Category> categories = new ArrayList<Category>();
		categories = categoryService.listCategories();
		
		
		map.addAttribute("products", products);
		map.addAttribute("query", "");
		map.addAttribute("categories", categories);
		
		return "/product/result";
	}
	
	@RequestMapping("/admin/vendor/product")
	public String showProducList(Model model, HttpSession session){
		SystemUser user = (SystemUser) session.getAttribute("user");
		Vendor v = vendorService.getVendorById(user.getUserId());
		if (v.getStatus()!=1) return "/admin/vendor/waiting";
		model.addAttribute("products", productService.getAllProducts());
		return "/admin/vendor/product";
	}
	@RequestMapping(value="/admin/vendor/product/edit", method = RequestMethod.GET)
	public String showProductEdit(Model model, @RequestParam("pid") String productId, HttpSession session){				
		SystemUser user = (SystemUser) session.getAttribute("user");
		Vendor v = vendorService.getVendorById(user.getUserId());
		if (v.getStatus()!=1) return "/admin/vendor/waiting";
		
		
		int id = Integer.parseInt(productId);
		model.addAttribute("product",productService.getProductById(id));
		model.addAttribute("categories", categoryService.listCategories());	
		
		
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
