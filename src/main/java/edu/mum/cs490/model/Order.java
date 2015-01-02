package edu.mum.cs490.model;

public class Order {

	private int id;
	private double total;
	private double profit_total;
	private double profit_for_mycompany;
	private String customer_address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getProfit_total() {
		return profit_total;
	}
	public void setProfit_total(double profit_total) {
		this.profit_total = profit_total;
	}
	public double getProfit_for_mycompany() {
		return profit_for_mycompany;
	}
	public void setProfit_for_mycompany(double profit_for_mycompany) {
		this.profit_for_mycompany = profit_for_mycompany;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	
	
}
