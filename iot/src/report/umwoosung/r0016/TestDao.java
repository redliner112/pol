package report.umwoosung.r0016;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import report.umwoosung.common.DBConn;

public class TestDao {

	public boolean insertTest() {
		try {
			Connection con = DBConn.getCon();
			String sql = "insert into test(title,content,writer,reg_date)";
					sql+="values (?,?,?,now())";
			PreparedStatement prestmt = con.prepareStatement(sql);
			prestmt.setString(1, "게시물3");
			prestmt.setString(2, "내용3");
			prestmt.setString(3, "6");
			int  result = prestmt.executeUpdate();
			DBConn.closeCon();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	 public List<Map> selectTest(){
		 List<Map> testList = new ArrayList<Map>();
			try {
				Connection con = DBConn.getCon();
				
				String sql = "select t.*,ui.id,ui.name from test as t, user_info as ui";
						sql+= " where t.writer = ui.num;";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Map hm = new HashMap();
					hm.put("num", rs.getString("num"));
					hm.put("title", rs.getString("title"));
					hm.put("content", rs.getString("content"));
					hm.put("writer", rs.getString("writer"));
					hm.put("reg_date", rs.getString("reg_date"));
					hm.put("id", rs.getString("id"));
					hm.put("name", rs.getString("name"));
					testList.add(hm);
				}
				DBConn.closeCon();
				return testList;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		 
//		 
//	
//	 }
//	 public boolean updateTest(){
//	 try{
//	 Connection con = DBConn.getCon();
//	 String sql =
//	 PreparedStatement prestmt = con.prepareStatement(sql);
//	 int result = prestmt.executeUpdate();
//	 DBConn.closeCon();
//	 }
//	 return true;
//	 }
	 
//	public boolean deleteTest(int num) {
//		try {
//			Connection con = DBConn.getCon();
//			String sql = "delete from test where num =" + num;
//			PreparedStatement prestmt = con.prepareStatement(sql);
//			int result = prestmt.executeUpdate();
//			DBConn.closeCon();
//			if (result > 0) {
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	public static void main(String[] args) {
		TestDao td = new TestDao();
		if (td.insertTest()) {
			System.out.println("입력완료");
		}
////		boolean dt = td.deleteTest(1);
////		if (dt) {
////			System.out.println("삭제완료");
//			
//			List<Map> list = td.selectTest();
//			for(Map m:list){
//				System.out.println(m);
//			}
		}
	}

}
