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
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.ProductService;
import edu.mum.cs490.service.SystemUserService;

@Controller
@SessionAttributes({ "user" })
public class VendorController {

	@Autowired
	private SystemUserService vendorService;

	@RequestMapping("/admin/vendor/profile")
	public String showProducList(Model model, HttpSession session) {
		Vendor user = (Vendor) session.getAttribute("user");
		System.out.println("profile : " + user.getUserId());
		model.addAttribute("vendor", user);
		return "/admin/vendor/profile";
	}

	@RequestMapping("/admin/vendor/profile/edit")
	public String showProfileEdit(Model model, HttpSession session) {
		Vendor user = (Vendor) session.getAttribute("user");
		System.out.println("edit profile : " + user.getVendorName());
		model.addAttribute("vendor", user);
		return "/admin/vendor/profile_edit";
	}

	@RequestMapping("/admin/vendor/profile/update")
	public String doUpdate(Model model,
			@Valid @ModelAttribute("profile") Vendor profile,
			BindingResult result, HttpSession session) {
		Vendor user = (Vendor) session.getAttribute("user");
		MultipartFile productImage = profile.getProductImage();

		try {
			profile.setImage(productImage.getBytes());
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		if (result.hasErrors()) {
			return "redirect:/admin/vendor/profile_edit";

		} else {
			profile.setUserId(user.getUserId());
			vendorService.updateUser(profile);
			return "redirect:/admin/vendor/profile";
		}
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
		vendorService.addUser(vendor);

		return "vendorRegSuccess";
	}

	@RequestMapping(value = "/vendor/add", method = RequestMethod.GET)
	public String addVendorpage(Model model) {

		model.addAttribute("vendor", new Vendor());
		return "registerVendor";
	}

}
