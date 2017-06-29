package report.umwoosung.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Scanner;

public class InsertUser {
	try{
		Connection con = DBConn.getCon();
		Scanner scan = new Scanner(System.in);
		HashMap<String,Object> hm = new HashMap<String,Object>();
		System.out.println("num를 입력해주세요");
		hm.put("num", scan.nextLine());
		System.out.println("name를 입력해주세요");
		hm.put("name", scan.nextLine());
		System.out.println("age를 입력해주세요");
		hm.put("age",scan.nextLine());
		System.out.println("class_name를 입력해주세요");
		hm.put("class_name", scan.nextLine());
		System.out.println("class_num를 입력해주세요");
		hm.put("class_num", scan.nextLine());
		
		String sql = "insert into user(num,name,age,class_name,class_num)"
					+"values(?,?,?,?,?)";
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1,(String) hm.get("num"));
		prestmt.setString(2,(String)hm.get("name"));
		prestmt.setString(3, (String)hm.get("age"));
		prestmt.setString(4,(String)hm.get("class_name"));
		prestmt.setString(5, (String)hm.get("class_num"));
		int  result = prestmt.executeUpdate();
		DBConn.closeCon();
		if(result==1){
			return true;
		}
		
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	return false;
	
	public static void main(String[]args){
		InsertUser u = new InsertUser();
		if(u.insertUser())
		 System.out.println(x);
	}
}
