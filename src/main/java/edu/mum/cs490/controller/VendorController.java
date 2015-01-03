package edu.mum.cs490.controller;

import java.io.File;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.VendorService;

@Controller
public class VendorController {

	private VendorService vendorService;

	@Autowired
	public void setVendorService(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	@RequestMapping("/vendor/add")
	public String addVendoraction(@ModelAttribute("vendor") Vendor vendor,
			BindingResult result, HttpServletRequest request) {

		MultipartFile productImage = vendor.getProductImage();
		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				
				Random random = new Random();
				//Math.abs(random.nextInt())
				
				productImage.transferTo(new File(rootDirectory
						+ "\\resources\\images\\" + vendor.getUserId() + ".png"));

			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		vendorService.addVendor(vendor);
		vendor.setRole("vendor");
		return "redirect:/";
	}

	@RequestMapping("/vendor")
	public ModelAndView addVendorpage() {

		ModelAndView model = new ModelAndView();
		model.addObject("vendor", new Vendor());
		model.setViewName("registerVendor");
		return model;
	}

}
