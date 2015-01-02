package edu.mum.cs490.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs490.dao.Vendordao;
import edu.mum.cs490.model.Vendor;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private Vendordao vendordao;
	
	public void setVendordao(Vendordao vendordao) {
		this.vendordao = vendordao;
	}

	@Override
	public void addVendor(Vendor v) {
		vendordao.addVendor(v);

	}

	@Override
	public void updateVendor(Vendor v) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vendor> allVendors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendor getVendorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeVendor(int id) {
		// TODO Auto-generated method stub

	}

}
