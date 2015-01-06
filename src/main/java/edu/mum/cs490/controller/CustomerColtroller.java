package edu.mum.cs490.controller;

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

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Registered;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.CustomerService;

@Controller
public class CustomerColtroller {

	private CustomerService customerService;

	// List<Customer> productList = new ArrayList<Customer>();
	@Autowired
	public void setCustomerService(CustomerService customerService) {
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
		customerService.addCustomer(customer);

		return "customerRegSuccess";
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.GET)
	public String addCustomerpage(Model model) {
		
		model.addAttribute("customer", new Registered());

		return "registerCustomer";
	}
}
