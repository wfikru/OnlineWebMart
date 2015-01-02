package edu.mum.cs490.service;

import java.util.List;

import edu.mum.cs490.model.Vendor;;

public interface VendorService {

	public void addVendor(Vendor v);

	public void updateVendor(Vendor v);

	public List<Vendor> allVendors();

	public Vendor getVendorById(int id);

	public void removeVendor(int id);
}
