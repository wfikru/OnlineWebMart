package edu.mum.cs490.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.CustomerService;

@Controller
@SessionAttributes("productList")
public class CustomerColtroller {

	private CustomerService customerService;

	List<Customer> productList = new ArrayList<Customer>();
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/customer/add")
	public String addCustomeraction(@ModelAttribute("customer") Customer customer) {

		customerService.addCustomer(customer);
		
		productList = customerService.allCustomers();
		return "redirect:/";
	}

	@RequestMapping("/customer")
	public String addCustomerpage(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("vendor", new Vendor());

		return "registerCustomer";
	}
}
