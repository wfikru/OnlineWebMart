package edu.mum.cs490.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.cs490.dao.OrderDao;
import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Order;
import edu.mum.cs490.model.Registered;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;

import edu.mum.cs490.service.SystemUserService;

import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.OrderService;


@Controller
@SessionAttributes({ "user", "status", "listCategories", "searchProduct" ,"size","shoppingCart","cartProducts", "total"})
public class CustomerColtroller {


	private SystemUserService customerService;


	
	@Autowired
	OrderService orderService;


	// List<Customer> productList = new ArrayList<Customer>();
	@Autowired
	public void setCustomerService(SystemUserService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping("/admin/customer")
	public String showCustomerPage(ModelMap map) {

		return "/admin/customer/home";
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addCustomeraction(
			@ModelAttribute("customer") @Valid Registered customer,
			BindingResult result) {

		if (result.hasErrors()) {
			return "registerCustomer";
		}

		customer.setRole("customer");
		customerService.addUser(customer);

		return "customerRegSuccess";
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.GET)
	public String addCustomerpage(Model model) {
		
		model.addAttribute("customer", new Registered());

		return "registerCustomer";
	}
	@RequestMapping(value = "/admin/customer/viewHistory", method = RequestMethod.GET)
	public String viewCustomerHistory(Model model, HttpSession session) {
		
		SystemUser customer = (SystemUser) session.getAttribute("user");
		System.out.println("*********"+customer.getEmail());
		int id= customer.getUserId();
		ArrayList<Order> orders= orderService.getOrdersByCustomer(id);
		model.addAttribute("orders", orders);
		System.out.println("customer");
		return "/admin/customer/viewOrderHistory";
	}
}
