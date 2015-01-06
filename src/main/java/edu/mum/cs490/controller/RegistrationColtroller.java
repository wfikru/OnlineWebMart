package edu.mum.cs490.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.SystemUserService;
import edu.mum.cs490.validator.RegistrationUser;
import edu.mum.cs490.validator.RegistrationValidator;

@Controller
public class RegistrationColtroller {

	@Autowired
	SystemUserService userService;
	@Autowired
	CustomerService customerService;

	
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

			user.setStatus(true);
			session.setAttribute("user", user);
			map.addAttribute("user", user);
			map.addAttribute("status", true);

			System.out.print("++++++++++++");

			System.out.print(user.getUsername());
			
			return "redirect:/admin/vendor/product";
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
	public String doRegister(ModelMap map, @ModelAttribute RegistrationUser reg_user, BindingResult result, HttpServletRequest request){
		
		RegistrationValidator userValidator = new RegistrationValidator();
        userValidator.validate(reg_user, result);
		if (result.hasErrors()) {
			SystemUser user = new SystemUser();
			map.addAttribute("user", user);
			map.addAttribute("reg_user", reg_user);
			return "/registration/login_reg";
		} else {
			return "redirect:/admin/vendor/product";
		}
	}
}
