package edu.mum.cs490.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import edu.mum.cs490.model.Vendor;
import edu.mum.cs490.service.ProductService;
import edu.mum.cs490.service.SystemUserService;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.service.VendorService;

@Controller
@SessionAttributes({ "user" })
public class VendorController {

	@Autowired
	private SystemUserService systemService;
	
	@Autowired
	private VendorService vendorService;

	@RequestMapping("/admin/vendor/waiting")
	public String showWaiting(Model model) {
		return "/admin/vendor/waiting";
	}
	
	@RequestMapping("/admin/vendor/profile")
	public String showProducList(Model model, HttpSession session) {
		SystemUser user = (SystemUser) session.getAttribute("user");
		Vendor v = vendorService.getVendorById(user.getUserId());
		if (v.getStatus()!=1) return "/admin/vendor/waiting";
		System.out.println("profile : " + user.getUserId());
		model.addAttribute("vendor", v);
		return "/admin/vendor/profile";
	}

	@RequestMapping("/admin/vendor/profile/edit")
	public String showProfileEdit(Model model, HttpSession session) {
		SystemUser user = (SystemUser) session.getAttribute("user");
		Vendor v = vendorService.getVendorById(user.getUserId());
		if (v.getStatus()!=1) return "/admin/vendor/waiting";
		System.out.println("edit profile : " + v.getVendorName());
		model.addAttribute("vendor", v);
		return "/admin/vendor/profile_edit";
	}

	@RequestMapping(value = "/admin/vendor/profile/picture")
	public void getPic(Model model, HttpSession session,
			HttpServletResponse response) {

		SystemUser user = (SystemUser) session.getAttribute("user");
		Vendor v = vendorService.getVendorById(user.getUserId());

		try {
			byte[] bytes = v.getImage();
			if (bytes != null && bytes.length > 0) {

				response.setContentType("image/jpg");
				response.getOutputStream().write(bytes);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}

		} catch (IOException e1) {
			System.out.print("eeeee msg" + e1);
		}

	}

	@RequestMapping("/admin/vendor/profile/update")
	public String doUpdate(ModelMap map,
			@Valid @ModelAttribute("vendor") Vendor profile,
			BindingResult result, HttpSession session) {
		Vendor user = (Vendor) session.getAttribute("user");
		MultipartFile productImage = profile.getProductImage();

		try {
			profile.setImage(productImage.getBytes());
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		if (result.hasErrors()) {
			map.put(BindingResult.class.getName() + ".vendor", result);
			return "/admin/vendor/profile_edit";

		} else {
			Vendor v = vendorService.getVendorById(user.getUserId());
			v.setEmail(profile.getEmail());
			v.setPassword(profile.getPassword());
			v.setVendorName(profile.getVendorName());
			v.setAddress(profile.getAddress());
			byte[] ib = profile.getImage();
			if (ib.length>0) v.setImage(profile.getImage());

			vendorService.updateVendor(v);
			session.setAttribute("user", v);
			return "/admin/vendor/profile";
		}
	}
}
