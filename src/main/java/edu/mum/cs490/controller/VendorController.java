package edu.mum.cs490.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.ProductService;
import edu.mum.cs490.service.VendorService;

@Controller
@SessionAttributes({ "user" })
public class VendorController {
	
	@Autowired
	private VendorService vendorService;

	@RequestMapping("/admin/vendor/profile")
	public String showProducList(Model model, HttpSession session){
		SystemUser user = (SystemUser)session.getAttribute("user");
		model.addAttribute("profile", user);
		return "/admin/vendor/profile";
	}


	@RequestMapping(value = "/vendor/add", method = RequestMethod.POST)
	public String addVendoraction(
			@ModelAttribute("vendor") @Valid Vendor vendor, BindingResult result) {


		if (result.hasErrors()) {
			return "registerVendor";
		}
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


	@RequestMapping(value = "/vendor/add", method = RequestMethod.GET)
	public String addVendorpage(Model model) {


		model.addAttribute("vendor", new Vendor());
		return "registerVendor";
	}

}
