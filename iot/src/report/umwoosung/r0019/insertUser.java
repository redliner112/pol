package report.umwoosung.r0019;

import java.sql.Connection;
import java.sql.Statement;

import report.umwoosung.common.DBConn;

public class insertUser {
	Connection con;
	public void setConnection() throws Exception{
		con = DBConn.getCon();
	}
	public boolean insertBoard(){
		String sql = "insert into board(title,contnet,writer,reg_date) valuess('게시판제목4','게시판내용4',3,new())";
		try{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
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
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return false;
	}
	public static void main(String[]args){
		insertUser iu = new insertUser();
		try{
			iu.setConnection();
			iu.insertBoard();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
