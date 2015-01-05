package edu.mum.cs490.controller;

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
public class RegistrationColtroller {

	private CustomerService customerService;

	// List<Customer> productList = new ArrayList<Customer>();
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	/*

	@RequestMapping("/registration/customer/add")
	public String addCustomeraction(
			@ModelAttribute("customer") Customer customer) {

		System.out.println("/customer/add****************");

		customer.setRole("customer");
		customerService.addCustomer(customer);

		return "customerRegSuccess";
	}
	*/

	@RequestMapping("/registration")
	public String showRegistrationPage(Model model) {
		System.out.println("/customer****************");
		model.addAttribute("customer", new Customer());

		return "/registration/login_reg";
	}
}
