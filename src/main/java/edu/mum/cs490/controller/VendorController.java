package edu.mum.cs490.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.ProductService;
import edu.mum.cs490.service.VendorService;

@Controller
public class VendorController {

	private VendorService vendorService;
	private static final Logger logger = LoggerFactory.getLogger(VendorController.class);

	@Autowired
	public void setVendorService(VendorService vendorService) {
		this.vendorService = vendorService;
	}
	

	@RequestMapping("/add")
	public String addVendoraction(@ModelAttribute("vendor") Vendor vendor,
			BindingResult result, HttpServletRequest request) {

		MultipartFile productImage = vendor.getProductImage();

		if (productImage != null && !productImage.isEmpty()) {
			try {

				vendor.setImage(productImage.getBytes());
				
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		
		vendor.setRole("vendor");
		vendorService.addVendor(vendor);
		
		return "vendorRegSuccess";
	}

	@RequestMapping("/")
	public ModelAndView addVendorpage() {

		ModelAndView model = new ModelAndView();
		model.addObject("vendor", new Vendor());
		model.setViewName("registerVendor");
		return model;
	}

}
