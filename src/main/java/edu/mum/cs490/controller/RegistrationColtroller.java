package edu.mum.cs490.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.cs490.model.Cart;
import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.MailService;
import edu.mum.cs490.service.ProductService;
import edu.mum.cs490.service.SystemUserService;
import edu.mum.cs490.validator.RegistrationUser;
import edu.mum.cs490.validator.RegistrationValidator;

@Controller
@SessionAttributes({ "user", "status", "listCategories", "searchProduct",
		"size", "shoppingCart", "cartProducts", "total", "loggedIn" })
public class RegistrationColtroller {

	@Autowired
	private HomeController homeController;
	
	@Autowired
	SystemUserService userService;
	
	@Autowired
	ProductService productService;

	@Autowired
	CustomerService customerService;

	@Autowired
	private MailService mailService;

	@Autowired
	private SystemUserService systemUserService;

	@RequestMapping("/registration")
	public String showRegistrationPage(ModelMap map) {
		System.out.println("/registration ****************");
		SystemUser user = new SystemUser();
		RegistrationUser reg_user = new RegistrationUser();
		map.addAttribute("user", user);
		map.addAttribute("reg_user", reg_user);

		return "/registration/login_reg";
	}

	@RequestMapping(value = "/registration/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("user") SystemUser userLogin,
			BindingResult result, ModelMap map, HttpSession session) {

		SystemUser user = userService.checkLogin(userLogin.getEmail(),
				userLogin.getPassword());
		boolean status;
		boolean login_error;
		if (user != null) {
			status = true;
			// if (authUser.getRole().equals("customer"))
			// authUser = (Customer) authUser;
			// else
			// authUser = (Vendor) authUser;

			session.setAttribute("user", user);

			map.addAttribute("user", user);
			map.addAttribute("status", true);

			System.out.print(user.getUsername());

			if (user.getRole().equals("customer")) {
				session.setAttribute("status", true);
				// Customer c =
				// customerService.getCustomerById(user.getUserId());
				// map.addAttribute("loggedIn", c);
				return "redirect:/product/search_all";
			} else if (user.getRole().equals("vendor")) {
				return "redirect:/admin/vendor/product";
			} else {
				return "redirect:/admin/system";
			}
		} else {
			System.out.println("User name and password are not correct ");
			status = false;
			map.addAttribute("status", false);
			login_error = true;
			map.addAttribute("login_error", true);
			map.addAttribute("reg_user", new RegistrationUser());
			return "registration/login_reg";
		}

	}

	@RequestMapping(value = "/registration/logout", method = RequestMethod.GET)
	public String logout(Locale locale, ModelMap map, HttpSession session) {
		boolean status;
		SystemUser user = new SystemUser();
		// newUser.setRole("default");
		map.put("user", user);
		map.remove("status");
		map.put("status", false);

		// List<Product> cartProducts = (List<Product>) ;
		// cartProducts.clear();
//		Cart shoppingCart = (Cart) session.getAttribute("shoppingCart");
//		List<Product> cartProducts = productService.getAllProducts();

	
		Cart shoppingCart = new Cart();
		List<Product> cartProducts = new ArrayList<Product>();
		homeController.shoppingCart = new Cart();
		map.addAttribute("cartProducts", cartProducts);
		session.setAttribute("user", user);
		session.setAttribute("status", false);
		session.removeAttribute("shoppingCart");
		session.setAttribute("shoppingCart", shoppingCart);
		session.setAttribute("total", 0.0);
		session.setAttribute("size", 0);
		map.addAttribute("user", user);
		map.addAttribute("status", false);
		map.addAttribute("shoppingCart", shoppingCart);
		map.addAttribute("total", 0.0);
		map.addAttribute("size", 0);

		status = false;
		return "redirect:/";

		// session.setAttribute("user", null);
		// session.setAttribute("status", false);
		//
		//
		// status = false;
		// return "home2";

	}

	@RequestMapping(value = "/registration/register", method = RequestMethod.POST)
	public String doRegister(ModelMap map,
			@Valid @ModelAttribute RegistrationUser reg_user,
			BindingResult result, HttpSession session) {

		String rootDirectory = session.getServletContext().getRealPath("/");
		String message = null;
		FileInputStream fisTargetFile = null;
		try {
			fisTargetFile = new FileInputStream(new File(rootDirectory
					+ "\\resources\\message\\greeting"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			message = IOUtils.toString(fisTargetFile, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		RegistrationValidator userValidator = new RegistrationValidator();
		userValidator.validate(reg_user, result);
		if (result.hasErrors()) {
			SystemUser user = new SystemUser();
			map.addAttribute("user", user);
			// map.addAttribute("reg_user", reg_user);
			map.put(BindingResult.class.getName() + ".reg_user", result);
			return "/registration/login_reg";
		} else {
			if (reg_user.getRole().equals("customer")) {
				Customer c = new Customer();
				c.setEmail(reg_user.getEmail());
				c.setPassword(reg_user.getPassword());
				c.setRole("customer");
				systemUserService.addUser(c);
				map.addAttribute("user", c);
				session.setAttribute("user", c);
				session.setAttribute("status", true);
				mailService.sendMail(reg_user.getEmail(), "Greeting", message);

				return "redirect:/product/search_all";
			} else {
				Vendor c = new Vendor();
				c.setEmail(reg_user.getEmail());
				c.setPassword(reg_user.getPassword());
				c.setRole("vendor");
				c.setVendorName(reg_user.getEmail());

				systemUserService.addUser(c);
				map.addAttribute("user", c);
				session.setAttribute("user", c);

				mailService.sendMail(reg_user.getEmail(), "Greeting", message);

				return "redirect:/admin/vendor/product";
			}

		}
	}
}
