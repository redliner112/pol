package report.umwoosung.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exam {
	public List<String> getUserIDLists(String name) {
		//String result = "";
		List<String> userlist = new ArrayList<String>();
		try {
			Connection con = DBConn.getCon();//db에 연결.
			
			String sql = "select ID,PWD,NAME from user";
			if(!name.equals("")){
				sql += " WHERE NAME =?";
			}
			
			PreparedStatement prestmt = con.prepareStatement(sql);//select*from user;까지 입력한상태.
			if(!name.equals("")){
				prestmt.setString(1, name);
			}
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {//해당하는 로우가 없을때가지 계속돈다.
				userlist.add(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));//첫번째값 두번째깞 세번째값
			}
			DBConn.closeCon();//연결을 끊고
			return userlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertUser(){
		try{
		Connection con = DBConn.getCon();
		Scanner scan = new Scanner(System.in);
		HashMap<String,String> hm = new HashMap<String,String>();
		System.out.println("id를 입력해주세요");
		hm.put("id", scan.nextLine());
		System.out.println("pwd를 입력해주세요");
		hm.put("pwd", scan.nextLine());
		System.out.println("name를 입력해주세요");
		hm.put("name", scan.nextLine());
		System.out.println("age를 입력해주세요");
		hm.put("age", scan.nextLine());
		String sql = "insert into user(id,pwd,name,age)"
				+ "values(?,?,?,?)";
		PreparedStatement prestmt = con.prepareStatement(sql);//con.prepareStatement(sql)로 쓸수있는 판을 넣어서 prestmt변수에 넣어준다.
		prestmt.setString(1,hm.get( "id"));
		prestmt.setString(2,hm.get( "pwd"));
		prestmt.setString(3,hm.get( "name"));
		prestmt.setString(4, hm.get( "age"));
		int  result = prestmt.executeUpdate();//prestmt.executeUpdate실행하면 1나온다는것.
		DBConn.closeCon();
		if(result==1){
			return true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
	}
	
	public boolean deleteUser(int num){
		try{
			Connection con = DBConn.getCon();
			String sql = "delete from user where num=;"+num;
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn.closeCon();
			if(result==1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}



public static void main(String[]args){
	Exam e = new Exam();
	//if(e.insertUser()){
	//	System.out.println("잘들어갔다.");	
//	}
		
	//}
	List<String> userList = e.getUserIDLists("");
	for(int i = 0;i<userList.size();i++)
	System.out.println(userList.get(i));
}
}


//con.prepareStatement(sql)
//PreparedStatement
//ResultSet
//executeQuery 메쏘드는 하나의 result set을 만드는 SQL문들에서 사용된다. 
// executeQuery 메쏘드는 ResultSet 객체를 리턴한다. 
//executeUpdate INSERT, UPDATE, DELETE 문의 결과는 테이블내의 0 이나 많은 열들내에서 하나이상의 행을 수정하는 것이다. 



