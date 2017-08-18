package com.test.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;

public class GoodsService {
	public List<Vendor> selectVendorsList(){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname from vendor_info";
			//vendor DTO에서 vinum과 viname호출.
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			//Vendor타입으로 구성된 List vendorList 생성
			while(rs.next()){
				//false날때까지 또돌리면서 value입력해
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendorList.add(vendor);
				//vendorList에 DTO에 넣은 vinum,viname .add()시키고
			}
			return vendorList;
			//vendorList servlet으로 리턴해주자.
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
	public List<Goods> selectGoodsList(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname "
					+ " from goods_info as gi, vendor_info as vi "
					+ " where gi.vinum=vi.vinum";
			//ginum.giname,gidesc,vinum,viname 을 gi.vinum과 vi.num이 같은것들중 구하겠다는것.
			int idx=0;
			//int idx초기화.
			if(pGoods.getViNum()!=0){
				//만약 getViNum()가 하나라도 존제하면
				sql += " and gi.vinum=?";
				// and gi.vinum=? 추가.
				idx++;
				//idx++ idx가 하는일은?
				//3번
				
			}
			if(pGoods.getGiName()!=null){
				//만약 getGiname()가 하나라도 존제할시
				sql += " and gi.giname like ?";
				//sql추가하겠다는건데 왜죠?? 이건 그냥 내일 통째로 물어볼꺼임
				//<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>
				idx++;
			}
			sql += " order by gi.ginum";
			sql += " limit ?,?";
			Page page = pGoods.getPage();
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			
			if(pGoods.getViNum()!=0 && pGoods.getGiName()==null){
				ps.setInt(1, pGoods.getViNum());
				
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()==0){
				ps.setString(1, "%" + pGoods.getGiName() + "%");
				
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()!=0 ){
				ps.setInt(1, pGoods.getViNum());
				ps.setString(2, "%" + pGoods.getGiName() + "%");
			}
			ps.setInt(++idx, page.getStartRow()); 
			//(nowPage-1)*rowCnt니 지금 페이지가 47페이지면 (47-1)*10이니 460번쨰 로우부터 시작한다.
			ps.setInt(++idx, page.getRowCnt());
			//rowcnt는 10이고
			ResultSet rs = ps.executeQuery();
			List<Goods> goodsList = new ArrayList<Goods>();
			//Goods타입의 List  goodsList생성.
			while(rs.next()){
				//while()로 false가 나올떄까지 rs.next()로 로우들을 하나씩 읽어들인다.
				Goods goods = new Goods();
				//Goods타입의 goods변수 생성
				goods.setGiNum(rs.getInt("ginum"));
				//goods에 sql에서 읽어들인 ginum을 rs.getInt로value들을  DTO(goods.setGiNum)에 넣는다.
				goods.setGiName(rs.getString("giname"));
				goods.setGiDesc(rs.getString("gidesc"));
				goods.setViNum(rs.getInt("vinum"));
				goods.setViName(rs.getString("viname"));
				goodsList.add(goods);
				//goodsList에  rs.next()로 읽어들인 value들을 넣고 
			}
			return goodsList;
			//goodsList를 servlet에 리턴.
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

	public int deleteGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "delete from goods_info where  ginum=?";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setInt(1, pGoods.getGiNum());
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
	
	public int insertGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into goods_info(giname,gidesc,vinum,gicredat,gicretim)";
			sql+=" values(?,?,?,DATE_FORMAT(NOW(),'%Y%m%d'),DATA_FORMAT(NOW(),'%H%i%s'))";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, pGoods.getGiName());
			ps.setString(2, pGoods.getGiDesc());
			ps.setInt(3, pGoods.getViNum());
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
	
	public int updateGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "update goods_info";
			sql+=" set giname=?,";
			sql+=" gidesc = ?,";
			sql+="vinum=?";
			sql+="where giname=?";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, pGoods.getGiName());
			ps.setString(2, pGoods.getGiDesc());
			ps.setInt(3, pGoods.getViNum());
			ps.setInt(4, pGoods.getGiNum());
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
	
	public Goods selectGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname "
					+ " from goods_info as gi, vendor_info as vi "
					+ " where gi.vinum=vi.vinum and gi.ginum=?";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pGoods.getGiNum());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setGiNum(rs.getInt("ginum"));
				goods.setGiName(rs.getString("giname"));
				goods.setGiDesc(rs.getString("gidesc"));
				goods.setViNum(rs.getInt("vinum"));
				goods.setViName(rs.getString("viname"));
				return goods;
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
		return null;
	}
	public int getTotalCount(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select count(1) "
					+ " from goods_info as gi, vendor_info as vi "
					+ " where gi.vinum=vi.vinum";
			//goods_info와 vendor_info의 vinum이 동일한 DB를 표시(총갯수.)
			if(pGoods.getViNum()!=0){
				//만약 Goods_info DTO의  getViNum()의 value가 하나라도 존제할때 
				sql += " and gi.vinum=?";
			}
			if(pGoods.getGiName()!=null){
				//만약 Goods_info DTO의  getViName()의 value가 하나라도 존제할때 
				sql += " and gi.giname like ?";
			}
			//총갯수 구할려고 하는것같은데 위 두개의 and sql을 뭐때문에 추가해주는지 모르겠네요.
			//2번
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			if(pGoods.getViNum()!=0 && pGoods.getGiName()==null){
				ps.setInt(1, pGoods.getViNum());
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()==0){
				ps.setString(1, "%" + pGoods.getGiName() + "%");
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()!=0 ){
				ps.setInt(1, pGoods.getViNum());
				ps.setString(2, "%" + pGoods.getGiName() + "%");
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
}