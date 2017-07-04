package report.umwoosung.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentDAO {

	Connection con;
	public CommentDAO() throws Exception{
		con = DBConn.getCon();
	}
	public List<Map> getCommentList(int boardNum) throws SQLException{
		String sql = "select num, content, reg_Date, b_num, ui_num from comment_info";
		sql += " where b_num=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNum);
		
		ResultSet rs = ps.executeQuery();
		ArrayList commentList = new ArrayList();
		while(rs.next()){
			HashMap hm = new HashMap();
			hm.put("content", rs.getString("content"));
			hm.put("reg_date", rs.getString("reg_date"));
			hm.put("b_num", rs.getString("b_num"));
			hm.put("ui_num", rs.getString("ui_num"));
			commentList.add(hm);
		}
		rs.close();
		rs = null;
		ps.close();
		ps = null;
		return commentList;
	}
	public void closeCon(){
		try{
			DBConn.closeCon();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception{
		try {
			CommentDAO cdao = new CommentDAO();
			List<Map> commentList = cdao.getCommentList(Integer.parseInt("2"));
			for(Map m2 : commentList){
				System.out.println(m2);
			}
			DBConn.closeCon();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
	}
}
