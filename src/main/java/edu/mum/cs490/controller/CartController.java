/** 
 * Authors: Hiwot & Fikru
 * 
 **/
package edu.mum.cs490.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.codehaus.groovy.control.messages.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import edu.mum.cs490.model.Address;
import edu.mum.cs490.model.Cart;
import edu.mum.cs490.model.CreditCard;
import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Guest;
import edu.mum.cs490.model.Order;
import edu.mum.cs490.model.Product;
import edu.mum.cs490.model.Registered;
import edu.mum.cs490.model.SystemUser;
import edu.mum.cs490.service.CustomerService;
import edu.mum.cs490.service.MailService;
import edu.mum.cs490.service.ProductService;
import edu.mum.cs490.service.SystemUserService;

@Controller
@SessionAttributes({ "productList", "searchProduct", "shoppingCart", "total",
		"listCategories", "size", "cartProducts", "user", "result" })
public class CartController {

	@Autowired
	private HomeController homeController;

	@Autowired
	private SystemUserService systemService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private MailService mailService;

	@Autowired
	ProductService productService;
	double total;
	int size;

	@RequestMapping(value = "/product/cart")
	public String doShowCart(ModelMap map) {
		return "/product/cart";
	}

	@RequestMapping(value = "/product/addtocart")
	public String addItemToCart(@ModelAttribute("id") int id,
			BindingResult result, ModelMap map) {
		Product product = productService.getProductById(id);
		map.addAttribute("product", product);
		System.out.println(product.getName());
		List<Product> searchProducts;
		Product searchProduct = new Product();

		map.addAttribute("searchProduct", searchProduct);
		List<Product> cartProducts = homeController.getShoppingCart().getProducts();
		int cartQuantity = 0;
		for (Product p : cartProducts) {
			if (p.getId() == product.getId()) {
				p.setQuantity(p.getQuantity() - 1);
				p.setCartQuantity(p.getCartQuantity() + 1);
				productService.updateProduct(p);
				total = total + p.getPrice();
				System.out.println("+++++++++" + total + "++++++++");
				map.addAttribute("cartProducts", cartProducts);
				map.addAttribute("total", total);
				size++;
				map.addAttribute("size", size);
				return "/product/cart";
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

		return "/product/cart";
	}

	@RequestMapping(value = "/continue", method = RequestMethod.GET)
	public String continueShopping() {
		return "redirect:/";
	}

	@RequestMapping(value = "/product/removeFromCart")
	public String removeItemFromCart(@ModelAttribute("id") int id,
			BindingResult result, ModelMap map) {
		List<Product> cartProducts = homeController.getShoppingCart().getProducts();
		Product product = new Product();
		for (Product p : cartProducts) {
			if (p.getId() == id) {
				product = p;
				break;
			}
		}
		size -= product.getCartQuantity();
		cartProducts.remove(product);
		total -= product.getPrice() * product.getCartQuantity();
		map.addAttribute("cartProducts", cartProducts);
		map.addAttribute("size", size);
		map.addAttribute("total", total);

		return "/product/cart";

	}

	@RequestMapping(value = "/product/minusOne")
	public String minusOneItem(@ModelAttribute("id") int id,
			BindingResult result, ModelMap map) {

		List<Product> cartProducts = homeController.getShoppingCart().getProducts();
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
					return "/product/cart";
				} else
					cartProducts.remove(p);
				// total -= p.getPrice();
				map.addAttribute("cartProducts", cartProducts);
				// size=homeController.size-1;

				map.addAttribute("size", size);
				map.addAttribute("total", total);

				return "/product/cart";

			}
		}

		return "/product/cart";

	}

	@RequestMapping(value = "/product/plusOne")
	public String plusOneItem(@ModelAttribute("id") int id,
			BindingResult result, ModelMap map) {

		List<Product> cartProducts = homeController.getShoppingCart().getProducts();
		Product product = new Product();
		for (Product p : cartProducts) {
			if (p.getId() == id) {
				p.setQuantity(p.getQuantity() - 1);
				p.setCartQuantity(p.getCartQuantity() + 1);
				productService.updateProduct(p);
				total = total + p.getPrice();
				System.out.println("+++++++++" + total + "++++++++");
				map.addAttribute("cartProducts", cartProducts);
				map.addAttribute("total", total);
				size++;
				map.addAttribute("size", size);
				return "/product/cart";
			}
		}

		return "/product/cart";

	}

	@RequestMapping("product_summary")
	public String showSummary() {
		return "product_summary";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String makePayment(Model model, HttpServletRequest request) {

		model.addAttribute("creditCard", new CreditCard());

		return "payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String validateCard(
			@ModelAttribute("creditCard") @Valid CreditCard creditCard,
			BindingResult bindresult, HttpServletRequest request, ModelMap map) {

		if (bindresult.hasErrors()) {
			return "payment";
		}

		Cart cart = (Cart) request.getSession().getAttribute("shoppingCart");

		double getGrandTotal = (Double) request.getSession().getAttribute(
				"total");

		creditCard.setCardNo(creditCard.getFirst(), creditCard.getSecond(),
				creditCard.getThird(), creditCard.getFourth());
		creditCard.setExpDate(creditCard.getMonth(), creditCard.getYear());

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/gateway/validate?ccn="
				+ creditCard.getCardNo() + "&amount=" + getGrandTotal + "";

		// String url =
		// "http://localhost:8082/gateway/validate?ccn=1111111111111111&amount=100";
		String result = null;
		try {
			result = restTemplate.postForObject(url, null, String.class);
			request.getSession().setAttribute("result", result);
		} catch (Exception e) {
			return "serviceError";
		}

		if (result.equals("y")) {

			Address address = new Address();
			address.setState(request.getParameter("state"));
			address.setStreet(request.getParameter("street"));
			address.setZip(request.getParameter("zip"));

			SystemUser user = (SystemUser) request.getSession().getAttribute(
					"user");

			// Customer user = customerService.getCustomerById(systemuser
			// .getUserId());

			// Customer user = (SystemUser) request.getSession()
			// .getAttribute("user");

			if (user != null) {

				Registered customer = (Registered) customerService
						.getCustomerById(user.getUserId());

				// .getUserById(user.getUserId());

				customer.setAddress(address);
				creditCard.setCustomer(customer);
				customer.setCreditCard(creditCard);
				customerService.addCustomer(customer);

				String rootDirectory = request.getSession().getServletContext()
						.getRealPath("/");
				String message = null;

				// read message file
				FileInputStream fisTargetFile = null;
				try {
					fisTargetFile = new FileInputStream(new File(rootDirectory
							+ "\\resources\\message\\confirmation"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				try {
					message = IOUtils.toString(fisTargetFile, "UTF-8");
				} catch (IOException e) {
					e.printStackTrace();
				}
				mailService.sendMail(customer.getEmail(), "Confirmation",
						message);

				Order order = new Order();
				order.setCustomer_address(address);
				List<Product> cartProducts = homeController.getShoppingCart()
						.getProducts();

				order.setProducts(cartProducts);
				cartProducts.clear();
				map.addAttribute("cartProducts", cartProducts);
				total = 0;
				map.addAttribute("total", total);
				size = 0;
				map.addAttribute("size", size);

			} else {
				Guest guest = new Guest();
				guest.setAddress(address);
				creditCard.setCustomer(guest);
				guest.setCreditCard(creditCard);
				customerService.addCustomer(guest);
				Order order = new Order();
				order.setCustomer_address(address);
				List<Product> cartProducts = homeController.getShoppingCart()
						.getProducts();

				order.setProducts(cartProducts);
				cartProducts.clear();
				map.addAttribute("cartProducts", cartProducts);
				total = 0;
				map.addAttribute("total", total);
				size = 0;
				map.addAttribute("size", size);
			}

			double profit = getGrandTotal * 0.2;
			double myprofit = profit * 0.1;

			String strAddress = "STATE:" + address.getState() + "_STREET:"
					+ address.getStreet() + "_ZIP:" + address.getZip();
			String url2 = "http://localhost:8080/payment/finance?ccn="
					+ creditCard.getCardNo() + "&address=" + strAddress
					+ "&profit=" + profit + "&total=" + getGrandTotal
					+ "&myprofit=" + myprofit + "";

			// String url2 =
			// "http://localhost:8082/payment/finance?ccn=111&address=456&profit=100&total=1000&myprofit=50";
			try {
				restTemplate.postForObject(url2, null, String.class);
			} catch (Exception e) {
				return "serviceError";
			}

			return "paymentSucces";
		} else if (result.equals("n")) {
			return "paymentFailure";
		} else {
			return "paymentFailure";
		}
	}
}
