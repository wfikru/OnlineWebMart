package edu.mum.cs490.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.VendorService;

@Controller
public class AdminController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private VendorService vendorService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/customers")
	public String allCustomers(Model model) {
		List<Customer> customers = customerService.allCustomers();
		model.addAttribute("customers", customers);
		return "manageCustomers";
	}

	@RequestMapping("/vendors")
	public String allVendors(Model model, HttpServletRequest request) {
		List<Vendor> vendors = vendorService.allVendors();

		for (Vendor vendor : vendors) {

			String path = request.getSession().getServletContext()
					.getRealPath("/");
			path +="\\resources\\images\\"+vendor.getVendorName()+".png";

			InputStream in = new ByteArrayInputStream(vendor.getImage()); 
			BufferedImage bImageFromConvert;
			try {
			   bImageFromConvert = ImageIO.read(in);
			   ImageIO.write(
			      bImageFromConvert, "png", new File(path));
			} catch (Exception e) {
			   return e.getMessage();
			}

			vendor.setFilePath(path);
		}
		
		model.addAttribute("vendors", vendors);

		return "manageVendors";
	}
}
