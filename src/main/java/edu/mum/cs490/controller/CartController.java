package edu.mum.cs490.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import edu.mum.cs490.model.Cart;
import edu.mum.cs490.model.CreditCard;
import edu.mum.cs490.model.Customer;
import edu.mum.cs490.model.Product;

@Controller
@SessionAttributes("productList")
@RequestMapping("/cart")
public class CartController {

	// private List<String> productList ;

	@RequestMapping
	public String addToCart() {
		// Cart cart = new Cart();
		// cart.getProductList().add("product1");
		// productList = cart.getProductList();
		return "cart";

	}

	@RequestMapping("/payment")
	public String makePayment(Model model) {
		model.addAttribute("creditCard", new CreditCard());
		return "payment";
	}

	@RequestMapping("/payment/validate")
	public String validateCard(
			@ModelAttribute("creditCard") CreditCard creditCard) {

		Cart cart = new Cart();
		creditCard.setCardNo(creditCard.getFirst(), creditCard.getSecond(),
				creditCard.getThird(), creditCard.getFourth());
		System.out.println(creditCard.getCardNo());

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/gateway/validate?ccn="
				+ creditCard.getCardNo() + "&amount=" + cart.getGrandTotal()
				+ "";

		String result = restTemplate.postForObject(url, null, String.class);

		if (result.equals("y")) {
			
			Customer customer = new Customer();
			String address = "State_" + customer.getAddress().getState()
					+ "_Street" + customer.getAddress().getStreet() + "_"
					+ customer.getAddress().getZip();
			
			double profit = cart.getGrandTotal() * 0.2;
			double myprofit = profit*0.1;
			
			String url2 = "http://localhost:8080/payment/finance?ccn=111&address="
					+ address + "&profit="+profit+"&total="+cart.getGrandTotal()+"&myprofit="+myprofit+"";
			
			return "paymentSucces";
		} else
			return "payment";

	}

}
