package report.umwoosung.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAO {

	public List<HashMap> doSelect(String sql) throws Exception{
		List<HashMap> userlist = new ArrayList<HashMap>();
		
		try{
			Connection con = DBConn.getCon();
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();//컬럼정보를 가져온다.

			while (rs.next()){//컬럼정볼를 가장먼저 읽는다.(rs.next()로우가 하나씩 지나간다) <=이게 컬럼넘버
				HashMap hm = new HashMap();
		
				int colCount = rsmd.getColumnCount();//getColumnCount로 순서대 숫자를 매긴다.
				for(int i=1;i<=colCount;i++){
					String colName = rsmd.getColumnName(i);
					hm.put(colName,rs.getString(colName));
				}
				userlist.add(hm);
			}
			DBConn.closeCon();
			return userlist;
			
		}catch(SQLException |ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean doInsert(String sql,HashMap<String,String>hm) throws Exception{
		try{
			Connection con = DBConn.getCon();
			String[] keys = hm.keySet().toArray(new String[hm.size()]);
			for(int i=0;i<keys.length;i++){
				sql +=keys[i] + ",";
			}
			sql = sql.substring(0,sql.length()-1);
			sql +=") values(";
			
			for(int i=0;i<keys.length;i++){
				sql +="?,";
			}
			sql = sql.substring(0,sql.length()-1);
			sql +=")";
			PreparedStatement prestmt = con.prepareStatement(sql);
			for(int i=0;i<keys.length;i++){
				prestmt.setString(i+1, hm.get(keys[i]));
			}
			int result = prestmt.executeUpdate();
			DBConn.closeCon();
			if(result ==1){
				return true;
			}
		}catch(SQLException |ClassNotFoundException e){
				e.printStackTrace();
			}
			return false;
		}
	
	public static void main(String[]args) throws Exception{
		UserDAO ud = new UserDAO();
		
//		String sql = "select ui.num,ui.name,ui.id,ui.age,ci.class_name,ci.class_num from user_info as ui,class_info as ci where ui.class_num=ci.class_num ";
//		List<HashMap>userList = ud.doSelect(sql);
//		System.out.println("유저리스트->");
//		for(HashMap hm :userList){
//			System.out.println(hm);
		HashMap<String,String>hm = new HashMap<String,String>();
		hm.put("id", "green");
		hm.put("pwd","green");
		hm.put("name", "녹길동");
		hm.put("age", "21");
		hm.put("class_num", "3");
		
		String sql = "insert into class_info(";
		hm = new HashMap<String,String>();
		hm.put("class_name", "미술반");
		ud.doInsert(sql,hm);
		}
		
		
		
//		sql = "select ui.num,ui.name,ui.id,ui.age,ci.class_name,ci.class_num from user_info as ui,class_info";
//		userList = ud.doSelect(sql);
//		System.out.println("유저인포리스트->" +userList);
//    		
	//}

}
