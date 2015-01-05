package edu.mum.cs490.controller;

import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs490.model.Admin;
import edu.mum.cs490.model.Category;
import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.CategoryService;
import edu.mum.cs490.service.ProductService;
import edu.mum.cs490.service.SystemUserService;

@Controller
@SessionAttributes({ "user", "status", "listCategories", "searchProduct" })
public class UserController {

	@Autowired
	SystemUserService userService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	Product searchProduct = new Product();

	// public ModelMap model= new ModelMap();

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute("user") SystemUser userLogin,
			BindingResult result, ModelMap map, HttpSession session) {

		SystemUser user = userService.loginCheck(userLogin.getUsername(),
				userLogin.getPassword());
		boolean status;
		boolean error;
		if (user != null) {
			status = true;
			// if (authUser.getRole().equals("customer"))
			// authUser = (Customer) authUser;
			// else
			// authUser = (Vendor) authUser;

			user.setStatus(true);
			session.setAttribute("user", user);
			map.addAttribute("user", user);
			map.addAttribute("status", true);

			System.out.print("++++++++++++");

			System.out.print(user.getUsername());
			return "redirect:/allProducts";
		} else {
			System.out.print(userLogin.getUsername());
			status = false;
			map.addAttribute("status", false);
			error = true;
			map.addAttribute("error", true);
			return "login";
		}

	}


	@RequestMapping(value = "/home")
	public String home(ModelMap map) {
		
		return "home2";
	}

	@RequestMapping(value = "/login")
	public String login(ModelMap map) {
		System.out.print("+++++++++");
		SystemUser user = new SystemUser();
		map.addAttribute("user", user);
		// model.addAttribute("searchProduct", new Product());
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, ModelMap map) {
		boolean status;
		SystemUser user = new SystemUser();
		// newUser.setRole("default");
		map.put("user", user);
		map.remove("status");
		map.put("status", false);
		status = false;
		return "home2";

	}

	@RequestMapping(value = "/productPerCategory")
	public String listProducts(@ModelAttribute("catId") int categoryId,
			BindingResult result, ModelMap map) {
		ArrayList<Product> listOfProducts = productService
				.listProductsByCriteria(categoryId);
		map.addAttribute("productsByCat", listOfProducts);
		return "listProductsByCategory";

	}

	@RequestMapping(value = "/productByName", method = RequestMethod.POST)
	public String searchProductsByName(
			@ModelAttribute("searchProduct") Product p, BindingResult result,
			ModelMap map) {
		ArrayList<Product> products = productService.getProductsByName(p
				.getName());
		map.addAttribute("products", products);
		if (products.size() == 0)
			return "noItem";
		else
			return "searchProductsByName";
	}

	@RequestMapping(value = "/allProducts", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		ArrayList<Product> allProducts = productService.allProducts();
		model.addAttribute("allProducts", allProducts);
		return "allProducts";
	}
	// @RequestMapping(value = "/listCategories", method = RequestMethod.GET)
	// public List<Category> listOfCategories(Model model) {
	// // model.addAttribute("category", new Category());
	// System.out.print("+++++++++++++++++++");
	// // model.addAttribute("listCategories",
	// categoryService.listCategories());
	// return categoryService.listCategories();
	// }
}
