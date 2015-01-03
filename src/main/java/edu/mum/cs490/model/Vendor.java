package edu.mum.cs490.model;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Vendor extends SystemUser {

	private String vendorName;
//	private Byte[] image;
	private Address address;
	private double vendorCharge;

	@JsonIgnore
	@Transient
	private MultipartFile productImage;

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public Address getAddress() {
		return address;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	public Byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(Byte[] image) {
//		this.image = image;
//	}

	public double getVendorCharge() {
		return vendorCharge;
	}

	public void setVendorCharge(double vendorCharge) {
		this.vendorCharge = vendorCharge;
	}

}
