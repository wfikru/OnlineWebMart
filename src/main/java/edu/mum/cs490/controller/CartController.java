/** 
 * Authors: Hiwot & Fikru
 * 
 **/
package edu.mum.cs490.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.codehaus.groovy.control.messages.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import edu.mum.cs490.service.Guestservice;
import edu.mum.cs490.service.MailService;
import edu.mum.cs490.service.OrderService;
import edu.mum.cs490.service.ProductService;
import edu.mum.cs490.service.SystemUserService;

@Controller
@SessionAttributes({ "productList", "searchProduct", "shoppingCart", "total",
		"listCategories", "size", "cartProducts", "user", "status", "result" })
public class CartController implements Serializable {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private HomeController homeController;

	@Autowired
	private SystemUserService systemService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private Guestservice guestservice;

	@Autowired
	private MailService mailService;

	@Autowired
	ProductService productService;

	@Autowired
	private OrderService orderService;


	@RequestMapping(value = "/product/cart")
	public String doShowCart(ModelMap map) {
		return "/product/cart";
	}

	@RequestMapping(value = "/product/addtocart")
	public String addItemToCart(@ModelAttribute("id") int id,
			BindingResult result, ModelMap map, HttpSession session) {
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
				p.setQuantity(p.getQuantity() - 1);
				p.setCartQuantity(p.getCartQuantity() + 1);
				productService.updateProduct(p);
				double total = (Double) session.getAttribute("total");
				int size = (Integer) session.getAttribute("size");
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
		double total = (Double) session.getAttribute("total");
		int size = (Integer) session.getAttribute("size");
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
			BindingResult result, ModelMap map, HttpSession session) {

		List<Product> cartProducts = homeController.shoppingCart.getProducts();

		Product product = new Product();
		for (Product p : cartProducts) {
			if (p.getId() == id) {
				product = p;
				break;
			}
		}
		double total = (Double) session.getAttribute("total");
		int size = (Integer) session.getAttribute("size");
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
			BindingResult result, ModelMap map, HttpSession session) {
		
		double total = (Double) session.getAttribute("total");
		int size = (Integer) session.getAttribute("size");
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
			BindingResult result, ModelMap map, HttpSession session) {
		
		double total = (Double) session.getAttribute("total");
		int size = (Integer) session.getAttribute("size");

		List<Product> cartProducts = homeController.shoppingCart.getProducts();

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
			BindingResult bindresult, HttpServletRequest request, ModelMap map, HttpSession session) {
		
		double total = (Double) session.getAttribute("total");
		int size = (Integer) session.getAttribute("size");

		if (bindresult.hasErrors()) {
			return "payment";
		}

		double getGrandTotal = (Double) request.getSession().getAttribute(
				"total");

		double profit = getGrandTotal * 0.2;
		double myprofit = profit * 0.1;

		creditCard.setCardNo(creditCard.getFirst(), creditCard.getSecond(),
				creditCard.getThird(), creditCard.getFourth());
		creditCard.setExpDate(creditCard.getMonth(), creditCard.getYear());

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/gateway/validate?ccn="
				+ creditCard.getCardNo() + "&amount=" + (int) getGrandTotal
				+ "";

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

			SystemUser user = (SystemUser) request.getSession().getAttribute(
					"user");
			boolean is_guest = true;
			if (user != null) {
				if (user.getUserId() != 0) {
					if (user.getRole().equalsIgnoreCase("customer")) {
						is_guest = false;
					}
				}
			}

			if (!is_guest) {

				Customer customer = customerService.getCustomerById(user
						.getUserId());

				customer.setAddress(creditCard.getAddress());
				customer.setCreditCard(creditCard);
				customerService.updateCustomer(customer);

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

				order.setCustomer_address(creditCard.getAddress());
				order.setTotal(getGrandTotal);
				order.setProfit_total(profit);
				order.setProfit_for_mycompany(myprofit);

				List<Product> cartProducts = homeController.shoppingCart
						.getProducts();

				order.setProducts(cartProducts);
				order.setSystemUser((SystemUser) request.getSession()
						.getAttribute("user"));
				order.setDate(new Date());
				orderService.addOrder(order);
				cartProducts.clear();
				map.addAttribute("cartProducts", cartProducts);
				total = 0;
				map.addAttribute("total", total);
				size = 0;
				map.addAttribute("size", size);

			} else {
				System.out.println("guest is here ##########################");
				request.getSession().removeAttribute("user");
				Guest guest = new Guest();
				guest.setAddress(creditCard.getAddress());
				guest.setCreditCard(creditCard);
				guestservice.addGuest(guest);
				Order order = new Order();

				order.setCustomer_address(creditCard.getAddress());
				order.setTotal(getGrandTotal);
				order.setProfit_total(profit);
				order.setProfit_for_mycompany(myprofit);

				List<Product> cartProducts = homeController.shoppingCart
						.getProducts();

				order.setProducts(cartProducts);
				order.setSystemUser((SystemUser) request.getSession()
						.getAttribute("user"));
				order.setDate(new Date());
				orderService.addOrder(order);
				cartProducts.clear();
				map.addAttribute("cartProducts", cartProducts);
				total = 0;
				map.addAttribute("total", total);
				size = 0;
				map.addAttribute("size", size);
			}

			String strAddress = creditCard.getAddress().getZip();

			String url2 = "http://localhost:8080/myfinance/finance?ccn="
					+ creditCard.getCardNo() + "&address=" + strAddress
					+ "&profit=" + profit + "&total=" + getGrandTotal
					+ "&myprofit=" + myprofit + "";

			System.out.println(url2
					+ "*********************************************");
			// String url2 =
			// "http://localhost:8080/myfinance/finance?ccn=111&address=456&profit=100&total=1000&myprofit=50";

			try {
				restTemplate.postForObject(url2, null, String.class);
			} catch (Exception e) {
				return "serviceError";
			}

			return "paymentSucces";
		} else {
			return "paymentFailure";
		}
	}
}
