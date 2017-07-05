package report.umwoosung.r0017;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import report.umwoosung.common.DBConn;

public class SelectDao {
	
	Connection con;
	
	public void setConnection() throws Exception{
		con = DBConn.getCon();
		
	}
	public List<Map> selectBoard() throws SQLException{
		String sql = "select title,content,writer,reg_date from board";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		ArrayList selectList = new ArrayList();
		while(rs.next()){
			HashMap hm = new HashMap();
			hm.put("title", rs.getString("title"));
			hm.put("content",rs.getString("content"));
			hm.put("writer",rs.getString("writer"));
			hm.put("reg_date",rs.getString("reg_date"));
			selectList.add(hm);
		}
		rs.close();
		rs=null;
		ps.close();
		ps=null;
		return selectList;
		
	}
	public static void main(String[]args){
		SelectDao sd = new SelectDao();
		try{
			sd.setConnection();
			List<Map>selectList = sd.selectBoard();
			for(Map m : selectList){
				System.out.println(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
