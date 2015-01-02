package edu.mum.cs490.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs490.model.Address;
import edu.mum.cs490.model.Customer;
import edu.mum.cs490.service.CustomerService;

@Controller
public class CustomerColtroller {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	
	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/customer/add")
	public String addCustomeraction(@ModelAttribute Customer customer){//, HttpServletRequest request) {
		
//		Address address = new Address();
//		address.setEmail(request.getParameter("email"));
//		address.setState(request.getParameter("state"));
//		address.setStreet(request.getParameter("street"));
//		address.setZip(request.getParameter("zip"));
		
//		customer.setAddress(address);
		customerService.addCustomer(customer);
		return "redirect:/";
	}

	@RequestMapping("/customer")
	public String addCustomerpage(Model model) {
		model.addAttribute("customer", new Customer());
		return "saveCustomer";
	}
}
