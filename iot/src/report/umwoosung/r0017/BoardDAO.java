package report.umwoosung.r0017;


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

public class BoardDAO {
	Connection con;

	public void setConnection() throws Exception {
		con = DBConn.getCon();
	}

//	public boolean insertBoard() throws SQLException {
//		
//		String sql = "insert into board(title,content,writer,reg_date) values('게시물제목3','게시판내용3',3,new())";
//		
//		Statement st = con.createStatement();
//		int result = st.executeUpdate(sql);
//		if (result == 1) {
//			st.close();
//			st = null;
//			return true;
//		}
//		return false;
//	}

	public List<Map> selectBoard() throws SQLException {
		String sql = "select title,content,writer,reg_date from board";
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		ArrayList boardList = new ArrayList();
		while (rs.next()) {
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

	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAO();
		try {
			bdao.setConnection();
			List<Map> boardList = bdao.selectBoard();
			CommentDAO dao = new CommentDAO();
			for (Map m : boardList) {
				System.out.println(m);
//				List<Map> commentList = dao.getCommentList(Integer.parseInt((String) m.get("writer")));
//				for (Map m2 : commentList) {
//					System.out.println(m2);
//				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
