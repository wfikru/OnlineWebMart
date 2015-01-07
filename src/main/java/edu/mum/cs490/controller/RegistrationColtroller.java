package edu.mum.cs490.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.SystemUserService;
import edu.mum.cs490.service.VendorService;
import edu.mum.cs490.validator.RegistrationUser;
import edu.mum.cs490.validator.RegistrationValidator;

@Controller
@SessionAttributes({ "user", "status", "listCategories", "searchProduct" ,"size","shoppingCart","cartProducts", "total"})
public class RegistrationColtroller {

	@Autowired
	SystemUserService userService;
	@Autowired
	CustomerService customerService;
	@Autowired
	VendorService vendorService;
	
	@RequestMapping("/registration")
	public String showRegistrationPage(ModelMap map) {
		System.out.println("/registration ****************");
		SystemUser user = new SystemUser();
		RegistrationUser reg_user = new RegistrationUser();
		map.addAttribute("user", user);
		map.addAttribute("reg_user", reg_user);

		return "/registration/login_reg";
	}
	@RequestMapping(value="/registration/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("user") SystemUser userLogin,
			BindingResult result, ModelMap map, HttpSession session) {
		
		SystemUser user = userService.loginCheck(userLogin.getEmail(),
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
			session.setAttribute("status", true);
			map.addAttribute("user", user);
			map.addAttribute("status", true);
			
			System.out.print(user.getUsername());
			
			if (user.getRole().equals("customer")){
				return "redirect:/admin/customer";
			}else if (user.getRole().equals("vendor")){
				return "redirect:/admin/vendor/product";
			}else {
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
	@RequestMapping("/registration/register")
	public String doRegister(ModelMap map, @Valid @ModelAttribute RegistrationUser reg_user, BindingResult result, HttpSession session){
		
		RegistrationValidator userValidator = new RegistrationValidator();
        userValidator.validate(reg_user, result);
		if (result.hasErrors()) {
			SystemUser user = new SystemUser();
			map.addAttribute("user", user);
			//map.addAttribute("reg_user", reg_user);
			map.put(BindingResult.class.getName() + ".reg_user", result);
			return "/registration/login_reg";
		} else {
			if (reg_user.getRole().equals("customer")){
				Customer c = new Customer();
				c.setEmail(reg_user.getEmail());
				c.setPassword(reg_user.getPassword());
				c.setRole("customer");
				customerService.addCustomer(c);
				session.setAttribute("user", c);
				return "redirect:/";
			}else{
				Vendor c = new Vendor();
				c.setEmail(reg_user.getEmail());
				c.setPassword(reg_user.getPassword());
				c.setRole("vendor");
				c.setVendorName(reg_user.getEmail());
				vendorService.addVendor(c);
				session.setAttribute("user", c);
				return "redirect:/admin/vendor/product";
			}
			
		}
	}
}
