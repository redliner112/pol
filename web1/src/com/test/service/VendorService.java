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

public class VendorService {


	public List<Vendor> selectVendorsList(String viName){
		//List<Vendor>을 가진 selectVendorsList 파라미터 viName를 받으면
		Connection con = null;//접속신호가없고,
		PreparedStatement ps = null;//sql도 써지지않았다면
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone from vendor_info where 1=1";
			//vendor_info에서 vinum,viname,videsc,viaddress,viphon을 검색
			if(viName!=null){
				//하는데 만약 viName이 null이 아니라면
				sql += " and viname like ?";
				//sql에 +and viname like 해서 ?를 바인딩 해준다.
			}
			con = DBConn.getCon();
			//DBConn에 접속한걸 변수명 con으로 대입
			ps = con.prepareStatement(sql);
			//접속한 상태에서 prepareStatement(sql)로 미리 sql을 써놓고 변수명 ps로 대입.
			if(viName!=null){
				//만약 viname이 null이아니면 
				ps.setString(1, "%" + viName + "%");
				//ps에 String을 입력한다(바인딩한다.) key는 1이고 "%viname%"으로
			}
			ResultSet rs = ps.executeQuery();
			//select쿼리를 실행하는것을 rs에 대입하고
			List<Vendor> vendorList = new ArrayList<Vendor>();
			//Vendor로된 List를 vendorList라고 이름짓고 하나만든다.
			while(rs.next()){
				//while()함수로false가 나올떄까지 반복하여  rs의 next()함수를 
				Vendor vendor = new Vendor();
				//Vendor타입으로 vendor변수를 만들고 (Vendor타입이란 결국 DTO)
				vendor.setViNum(rs.getInt("vinum"));
				//vendor의 setViNum 함수에 executeQuery로 나온key와 valu들을  rs의 getInt("vinum")로 value값을 꺼내 vendorsetViNum함수에 파라메터로 넣고(DTO)
				//,아래 4개 마찬가지.
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				vendorList.add(vendor);
				//vendorList에 vendor타입의 vendor를 삽입한다.
			}
			return vendorList;
			//그리고 vendorList의를 리턴해준다.
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
}
