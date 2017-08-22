package com.test.service;

import java.util.List;

import com.test.dto.Vendor;

public interface VendorService {
	List<Vendor> selectVendorList(Vendor pVendor);
	Vendor selectVendor(Vendor pVendor);
	int deleteVendor(Vendor pVendor);
	int  getTotalCount(Vendor pVendor);
	int insertVendor(Vendor pVendor);
	int updateVendor(Vendor pVendor);
}
