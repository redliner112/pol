package report.umwoosung.common;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

public class BoardDao {
	Connection con;
	public void setConnection() throws Exception{
		con = DBConn.getCon();
	}
	
	public boolean insertBoard() {
		String sql = "insert into board(title, content, writer, reg_Date)values('게시판제목3','게시판내용3',3,now())";
		//user_info의 num이 3까지밖에없고, board의 writer와 연동되므로 3이상의 숫자를 쓰면 무조건 에러난다.
		try{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result==1){
				con.commit();
				st.close();
				st = null;
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateBoard(){
		String sql = "update board set title='으하하하하' where num='12'";
		try{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result==1){
				con.commit();
				st.close();
				st = null;
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		BoardDao bdao = new BoardDao();
		try {
			bdao.setConnection();
			bdao.insertBoard();
			bdao.updateBoard();
			System.out.println("정상동작 했고 저장까지 완료 했수다!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
//왜 try catch 에 try catch가 들어가있는건가?
//foreign key

//st.close();
//st = null; 하는이유

