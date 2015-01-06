package edu.mum.cs490.controller;

import groovyx.gpars.remote.netty.NettyTransportProvider.Client;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.h2.constant.SysProperties;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import antlr.collections.List;
import edu.mum.cs490.model.Cart;
import edu.mum.cs490.model.Category;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.service.CategoryService;
import edu.mum.cs490.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "listCategories", "searchProduct", "name", "allProducts",
		"shoppingCart", "size", "cartProducts" })
public class HomeController {

	CategoryService categoryService;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	Cart shoppingCart = new Cart();
	int size;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		SystemUser user;
		try{
			user = (SystemUser)session.getAttribute("user");	
			System.out.println("User role is : " + user.getRole());
			if (user.getRole().equals("vendor")){
				
				return "redirect:/admin/vendor/product";
			}else if (user.getRole().equals("admin")){
				return "redirect:/admin/system";
			}else{
				return "redirect:/admin/customer";
			}
		}catch(Exception ex){
			
		}
		

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("category", new Category());
		Product searchProduct = new Product();
		ArrayList<Product> allProducts = new ArrayList<Product>();
		allProducts = productService.allProducts();
		model.addAttribute("allProducts", allProducts);
		String name;
		session.setAttribute("searchProduct", searchProduct);
		model.addAttribute("searchProduct", searchProduct);
		ArrayList<Category> listCategories = new ArrayList<Category>();
		listCategories = categoryService.listCategories();
		model.addAttribute("listCategories", categoryService.listCategories());
		// Session session;
		// session.s
//		size = shoppingCart.getProducts().size();
		System.out.println("+++++++++" + size);
		model.addAttribute("size", size);
		return "home2";

	}

	@RequestMapping("/back")
	public String backToHome() {

		return "home2";
	}
}
