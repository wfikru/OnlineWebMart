package edu.mum.cs490.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.cs490.model.Cart;
import edu.mum.cs490.model.Product;


@Controller
@SessionAttributes("productList")
public class CartController {
//
//	private List<String> productList ;
//	
//	@RequestMapping("/cart")
//	public String addToCart()
//	{
//		Cart cart = new Cart();
//		cart.getProductList().add("product1");
//		productList = cart.getProductList();
//		return "redirect:/";
//		
//	}
	
	
}
