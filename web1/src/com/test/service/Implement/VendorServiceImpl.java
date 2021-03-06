package com.test.service.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.VendorService;

public class VendorServiceImpl implements VendorService {

	Connection con = null;// 접속신호가없고,
	PreparedStatement ps = null;// sql도 써지지않았다면

	public List<Vendor> selectVendorList(Vendor pVendor){
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone from vendor_info where 1=1";
			int  idx=0;
			if(pVendor.getViName()!=null){
				sql += " and viname like ?";
				idx++;
			}
			sql +=" order by vinum";
			sql +=" limit ?,?";
			
			Page page = pVendor.getPage();
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			
			if(pVendor.getViName()!=null){
				ps.setString(1, "%" + pVendor.getViName() + "%");
			}
			ps.setInt(++idx, page.getStartRow());
			ps.setInt(++idx, page.getRowCnt());
			
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
	public Vendor selectVendor(Vendor pVendor) {
		try {
			String sql = "select vinum, viname,videsc,viaddress,viphone from vendor_info" 
							+ " where vinum=?";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pVendor.getViNum());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("viDesc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viPhone"));
				return vendor;
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
	
	public int  getTotalCount(Vendor pVendor){
		try{
			String sql = " select count(1)  from vendor_info "
					+"   where vinum";
			if (pVendor.getViName()!=null){
				sql += " and viname like ?";
			}
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			if(pVendor.getViName()!=null) {
				ps.setString(1,"%" + pVendor.getViName() + "%"	);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
			
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
		return 0;
	}
	public int deleteVendor(Vendor pVendor){
		try{
			String sql = "delete from vendor_info where vinum=?";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pVendor.getViNum());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int insertVendor(Vendor pVendor){
		try{
			String sql = "insert into vendor_info(viname,videsc,viaddress,viphone,vicredat,vicretim)"
					+" values(?,?,?,?,DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s'))";
			con=DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1,pVendor.getViName());
			ps.setString(2,pVendor.getViDesc());
			ps.setString(3,pVendor.getViAddress());
			ps.setString(4,pVendor.getViPhone());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int updateVendor(Vendor pVendor) {
		try {
			String sql = "update vendor_info";
					sql +=" set viName=?,";
					sql +=" viDesc=?,";
					sql +=" viaddRess=?,";
					sql +=" viPhone=?";
					sql +=" where vinum=?";
					con = DBConn.getCon();
					ps = con.prepareStatement(sql);
					ps.setString(1, pVendor.getViName());
					ps.setString(2, pVendor.getViDesc());
					ps.setString(3, pVendor.getViAddress());
					ps.setString(4, pVendor.getViPhone());
					ps.setInt(5, pVendor.getViNum());
					int result = ps.executeUpdate();
					con.commit();
					return result;
			
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
		return 0;
	}

}
