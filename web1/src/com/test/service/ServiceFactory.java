package com.test.service;

import com.test.service.Implement.VendorServiceImpl;

public class ServiceFactory {
	
	public static VendorServiceImpl vendorService = new VendorServiceImpl();
	
	public static VendorServiceImpl getVendorService(){
		return vendorService;
	}

}
