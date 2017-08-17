package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.Vendor;

public class VendorService {

	Connection con = null;// 접속신호가없고,
	PreparedStatement ps = null;// sql도 써지지않았다면

	public List<Vendor> selectVendorsList(String viName){
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone from vendor_info where 1=1";
			if(viName!=null){
				sql += " and viname like ?";
			}
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
				if(viName!=null){
				ps.setString(1, "%" + viName + "%");
			}
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				vendorList.add(vendor);
			}
			return vendorList;
			}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Vendor> selectVendor(String viNum) {
		try {
			String sql = "select vinum,viname,videsc,viaddress,viphone from vendor_info" + " where vinum=?";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, viNum);
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while (rs.next()) {
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("viDesc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viPhone"));
				vendorList.add(vendor);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
