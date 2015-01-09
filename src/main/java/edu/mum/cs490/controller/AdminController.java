package edu.mum.cs490.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.cs490.model.Admin;
import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Order;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.OrderService;
import edu.mum.cs490.service.SystemUserService;
import edu.mum.cs490.service.VendorService;
import edu.mum.cs490.validator.RegistrationUser;

@Controller
@SessionAttributes({ "user"})
public class AdminController {

	@Autowired
	private SystemUserService customerService;

	@Autowired
	private VendorService vendorService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/admin/system")
	public String showAdminPage(ModelMap map) {

		return "redirect:/admin/system/vendors";
	}

	@RequestMapping("/customers")
	public String allCustomers(Model model) {
		List<Customer> customers = customerService.allCustomerUsers();
		model.addAttribute("customers", customers);
		return "manageCustomers";
	}


	@RequestMapping("/admin/system/vendors")
	public String allVendors(Model model, HttpServletRequest request, HttpSession session) {

		
		try {
			Admin admin = (Admin)session.getAttribute("user");
			if(admin!=null){
				
				if (admin.getRole().equals("admin")){
			
					List<Vendor> vendors = vendorService.allVendors();
			
						
					model.addAttribute("vendors", vendors);

					return "manageVendors";
				}else return "/";
			}else return "/";
		} catch (Exception e1) {
			
			return "redirect:/";
		}
		
		
	}
	
	
	@RequestMapping("/admin/system/disable")
	public String disableVendor(Model model, @ModelAttribute("vendor") Vendor vendor, BindingResult result, @RequestParam("vid") String vendorId, HttpServletRequest request) {
		
		int id = Integer.parseInt(vendorId);
		Vendor v = vendorService.getVendorById(id);
		v.setStatus(2);
	
		vendorService.updateVendor(v);
		return "redirect:/admin/system/vendors";
	}
	
	
	@RequestMapping("/admin/system/activate")
	public String activateVendor(Model model, @ModelAttribute("vendor") Vendor vendor, BindingResult result, @RequestParam("vid") String vendorId, HttpServletRequest request) {
		
		int id = Integer.parseInt(vendorId);
		Vendor v = vendorService.getVendorById(id);
		v.setStatus(1);
	
		vendorService.updateVendor(v);
		return "redirect:/admin/system/vendors";
	}
	
	@RequestMapping(value = "/admin/system/viewHistory", method = RequestMethod.GET)
	public String viewCustomerHistory(Model model, HttpSession session) {
		
		SystemUser vendor = (SystemUser) session.getAttribute("user");
		System.out.println("*********"+vendor.getEmail());
		int id= vendor.getUserId();
		ArrayList<Order> orders= orderService.getAllOrders();
		model.addAttribute("orders", orders);
		System.out.println("orders" + orders.size());
//		System.out.println("customer");
		return "/admin/system/viewOrderHistory";
	}
	
}
