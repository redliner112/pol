package report.umwoosung.r0019;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import report.umwoosung.common.CommentDAO;
import report.umwoosung.r0016.DBConn;

public class BoardDAO {
	Connection con;
	
	public void setConnection() throws Exception{
		con = DBConn.getCon();
	}
	public List<Map> selectBoard() throws SQLException{
		String sql = "select title,content,writer,reg_date from board";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		ArrayList boardList = new ArrayList();
		while(rs.next()){
			HashMap hm = new HashMap();
			hm.put("title", rs.getString("title"));
			hm.put("content", rs.getString("content"));
			hm.put("writer", rs.getString("writer"));
			hm.put("reg_date", rs.getString("reg_date"));
			boardList.add(hm);
		}
		rs.close();
		rs = null;
		ps.close();
		ps = null;
		return boardList;
	}
	public static void main(String[]args) {
		BoardDAO bdao = new BoardDAO();
		try{
			bdao.setConnection();
		
		List<Map>boardList = bdao.selectBoard();
		CommentDAO dao = new CommentDAO();
		for(Map m:boardList){
			System.out.println(m);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
