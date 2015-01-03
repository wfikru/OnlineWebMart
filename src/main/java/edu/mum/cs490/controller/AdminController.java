package edu.mum.cs490.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.service.CustomerService;

@Controller
public class AdminController {

	@Autowired
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/customers")
	public String allCustomers(Model model) {
		List<Customer> customers = customerService.allCustomers();
		model.addAttribute("customers", customers);
		return "manageCustomers";
	}
}
