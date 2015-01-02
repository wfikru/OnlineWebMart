package edu.mum.cs490.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.VendorService;

@Controller
public class VendorController {

	private VendorService vendorService;

	@Autowired
	public void setVendorService(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	@RequestMapping("/vendor")
	public String addVendorpage(Model model) {
		model.addAttribute("vendor", new Vendor());
		return "registerVendor";
	}

	@RequestMapping("/vendor/add")
	public String addVendoraction(@ModelAttribute("vendor") Vendor vendor) {
		vendorService.addVendor(vendor);
		return "redirect:/";
	}
}
