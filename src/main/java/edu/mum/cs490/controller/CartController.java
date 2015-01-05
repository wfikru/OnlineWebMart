package edu.mum.cs490.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.cs490.model.Cart;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.service.ProductService;

@Controller
@SessionAttributes({ "productList", "searchProduct", "shoppingCart", "total",
		"listCategories", "size", "cartProducts" })
public class CartController {
	//
	// private List<String> productList ;
	//
	// @RequestMapping("/cart")
	// public String addToCart()
	// {
	// Cart cart = new Cart();
	// cart.getProductList().add("product1");
	// productList = cart.getProductList();
	// return "redirect:/";
	//
	// }

	@Autowired
	HomeController homeController;

	@Autowired
	ProductService productService;
	double total = 0;
	int size;

	@RequestMapping(value = "/addToCart")
	public String addItemToCart(@ModelAttribute("id") int id,
			BindingResult result, ModelMap map) {
		Product product = productService.getProductById(id);
		map.addAttribute("product", product);
		System.out.println(product.getName());
		List<Product> searchProducts;
		Product searchProduct = new Product();

		map.addAttribute("searchProduct", searchProduct);
		List<Product> cartProducts = homeController.shoppingCart.getProducts();
		int cartQuantity = 0;
		for (Product p : cartProducts) {
			if (p.getId() == product.getId()) {
				if (product.getQuantity() > 0) {
					p.setQuantity(p.getQuantity() - 1);
					p.setCartQuantity(p.getCartQuantity() + 1);
					productService.updateProduct(p);
					total = total + p.getPrice();
					System.out.println("+++++++++" + total + "++++++++");
					map.addAttribute("cartProducts", cartProducts);
					map.addAttribute("total", total);
					size++;
					map.addAttribute("size", size);
					return "product_summary";
				} else {
					return "outOfStoke";
				}
			}

		}
		product.setQuantity(product.getQuantity() - 1);
		product.setCartQuantity(product.getCartQuantity() + 1);
		productService.updateProduct(product);
		cartProducts.add(product);
		total = total + product.getPrice();
		map.addAttribute("cartProducts", cartProducts);
		size++;
		map.addAttribute("size", size);
		map.addAttribute("total", total);
		
		return "product_summary";
	}

	@RequestMapping(value = "/removeFromCart")
	public String removeItemFromCart(@ModelAttribute("id") int id,
			BindingResult result, ModelMap map) {
		List<Product> cartProducts = homeController.shoppingCart.getProducts();
		Product product = new Product();
		for (Product p : cartProducts) {
			if (p.getId() == id) {
				product = p;
				break;
			}
		}
		size-=product.getCartQuantity();
		cartProducts.remove(product);
		total -= product.getPrice()*product.getCartQuantity();
		map.addAttribute("cartProducts", cartProducts);
		map.addAttribute("size", size);
		map.addAttribute("total", total);

		return "product_summary";

	}

	@RequestMapping(value = "/minusOne")
	public String minusOneItem(@ModelAttribute("id") int id,
			BindingResult result, ModelMap map) {

		List<Product> cartProducts = homeController.shoppingCart.getProducts();
		Product product = new Product();
		for (Product p : cartProducts) {
			if (p.getId() == id) {
				if (p.getCartQuantity() > 0) {
					p.setQuantity(p.getQuantity() + 1);
					p.setCartQuantity(p.getCartQuantity() - 1);
					productService.updateProduct(p);
					total = total - p.getPrice();
					System.out.println("+++++++++" + total + "++++++++");
					map.addAttribute("cartProducts", cartProducts);
					map.addAttribute("total", total);
					size--;
					map.addAttribute("size", size);
					return "product_summary";
				} else
					cartProducts.remove(p);
				total -= p.getPrice();
				map.addAttribute("cartProducts", cartProducts);
				size=homeController.size-1;
				map.addAttribute("size", size);
				map.addAttribute("total", total);

				return "product_summary";

			}
		}

		return "product_summary";

	}

	@RequestMapping(value = "/plusOne")
	public String plusOneItem(@ModelAttribute("id") int id,
			BindingResult result, ModelMap map) {

		List<Product> cartProducts = homeController.shoppingCart.getProducts();
		Product product = new Product();
		for (Product p : cartProducts) {
			if (p.getId() == id) {
				if(productService.getProductById(p.getId()).getQuantity()-p.getCartQuantity()>0){
				p.setQuantity(p.getQuantity() - 1);
				p.setCartQuantity(p.getCartQuantity() + 1);
				productService.updateProduct(p);
				total = total + p.getPrice();
				System.out.println("+++++++++" + total + "++++++++");
				map.addAttribute("cartProducts", cartProducts);
				map.addAttribute("total", total);
				size++;
				map.addAttribute("size", size);
				return "product_summary";
				}
				else
					return "outOfStoke";
			}
		}

		return "product_summary";

	}
	// @RequestMapping(value = "/productPerCategory")
	// public String listProducts(@ModelAttribute("catId") int categoryId,
	// BindingResult result, ModelMap map) {
	// ArrayList<Product> listOfProducts = productService
	// .listProductsByCriteria(categoryId);
	// map.addAttribute("productsByCat", listOfProducts);
	// return "listProductsByCategory";
	//
	// }
}
