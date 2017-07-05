package report.umwoosung.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import report.umwoosung.common.DBConn;

public class TestBoardDAO {
	Connection con;
	public void setConnection() throws Exception{
		con = DBConn.getCon();
	}
	
	
	public boolean insertBoard()	{
		
		String sql = "insert into board(title,content,writer,reg_date) values('게시판제목5','게시판내용5',3,now())";
			try{
				Statement st = con.createStatement();
				int result =st.executeUpdate(sql);
				if(result==1){
					con.commit();
					st.close();
					st=null;
					return true;
				}
			}catch(Exception e){
				e.printStackTrace();
				try{
					con.rollback();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		return false;
	}
//	public boolean updateBoard(){
//		String sql ="update board set content='니들이 게맛을알아' where num ='13'";
//		try{
//			Statement st = con.createStatement();
//			int result = st.executeUpdate(sql);
//			if(result==1){
//				con.commit();
//				st.close();
//				st = null;
//				return true;
//			}
//		}catch(Exception e){
//			try{
//				con.rollback();
//			}catch(Exception e1){
//				e1.printStackTrace();			}
//			e.printStackTrace();
//		}
//		return false;
//	}
//	public boolean deleteBoard(){
//		String sql ="delete from board where num='13'";
//		try{
//			Statement st = con.createStatement();
//			int result = st.executeUpdate(sql);
//			if (result==1){
//				con.commit();
//				st.close();
//				st = null;
//			}
//			return true;
//		}catch(Exception e){
//			try{
//				con.rollback();
//			}catch(Exception e1){
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//		return false;
//	}
	

	
	
	public static void main(String[]args) throws Exception{
		TestBoardDAO tbd = new TestBoardDAO();
		try{
			tbd.setConnection();
			tbd.insertBoard();
//			tbd.updateBoard();
//			tbd.deleteBoard();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
	}

}
