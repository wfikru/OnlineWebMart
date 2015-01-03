package edu.mum.cs490.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.cs490.model.Admin;
import edu.mum.cs490.model.Registered;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.SystemUserService;

@Controller

public class UserController {
	
	@Autowired
    SystemUserService userService;
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute("user") SystemUser user,
			BindingResult result, ModelMap map) {
		
		SystemUser authUser = userService.loginCheck(user.getUsername(), user.getPassword());
			

		
		if(authUser !=null){
			if(authUser.getRole().equals("customer"))
				authUser = (Registered) authUser;
//			else if (authUser.getRole().equals("admin"))
//				authUser = (Admin) authUser;
			else
				authUser = (Vendor) authUser;

			authUser.setStatus(true);			
			map.addAttribute("user",authUser);
			return "special_offers";
			}
		else
			{
				map.addAttribute("status", "false");
				return "home";
			}
		
	}
	

}
