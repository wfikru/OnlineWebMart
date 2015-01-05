package edu.mum.cs490.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String cardholderName;
	private String SecurityCode;
	private double amount;

	@Transient
	private String first;
	@Transient
	private String second;
	@Transient
	private String third;
	@Transient
	private String fourth;
	
	private String cardNo;
	
	@Transient
	private String month;
	@Transient
	private String year;
	
	private Date expDate;
	
	
	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(String month, String year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, Integer.parseInt(month));
		calendar.set(Calendar.YEAR, Integer.parseInt(year));
		this.expDate = calendar.getTime();
//		this.expDate = month+""+year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String fn, String sn, String tn, String fon) {
		this.cardNo = fn + sn + tn + fon;
		
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getThird() {
		return third;
	}

	public void setThird(String third) {
		this.third = third;
	}

	public String getFourth() {
		return fourth;
	}

	public void setFourth(String fourth) {
		this.fourth = fourth;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSecurityCode() {
		return SecurityCode;
	}

	public void setSecurityCode(String securityCode) {
		SecurityCode = securityCode;
	}

}
