package report.umwoosung.r0018;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import report.umwoosung.common.CommentDAO;
import report.umwoosung.common.DBConn;
import report.umwoosung.r0017.BoardDAO;

public class BoadDAO{
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
			hm.put("title",rs.getString("title"));
			hm.put("content",rs.getString("content"));
			hm.put("writer",rs.getString("writer"));
			hm.put("reg_date",rs.getString("reg_date"));
			boardList.add(hm);
		}
		rs.close();
		rs =null;
		ps.close();
		ps=null;
		return boardList;
	}
	public static void main(String[]args){
		BoardDAO bdao = new BoardDAO();
		try{
			bdao.setConnection();
			List<Map>boardList = bdao.selectBoard();
			CommentDAO dao = new CommentDAO();//여기서 왜 commentDAO를 해준것인가?
			for(Map m :boardList){
				System.out.println(m);
				List<Map> commentList = dao.getCommentList(Integer.parseInt((String) m.get("writer")));//왜 user num과 writer 가 reference된것을 써야하는지 설명좀
				for(Map m2 : commentList){
					System.out.println(m2);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	}

