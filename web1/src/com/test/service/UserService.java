package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;

public class UserService {

	public boolean InsertUser(HashMap<String, String> hm)  {
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = DBConn.getCon();
			String sql = "insert into user_info(in, pwd,name,class_num,age)";
			sql+= "values(?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("age"));
			ps.setString(5, hm.get("class_num"));
			int result = ps.executeUpdate();
			if(result==1){
				con.commit();
				return true;
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
		
	}
	public List<Map> selectUser(HashMap<String,String>hm){
		Connection con = null;
		PreparedStatement ps = null;
		try{
			String sql = "select user_num, user_id,user_pwd,user_name,class_num form user_info";
			if(hm.get("name")!=null){
				sql +=" where user_name like ?";	
			}
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			if(hm.get("name")!=null){
				ps.setString(1, hm.get("name"));
			}
			ResultSet rs = ps.executeQuery();
			List userList = new ArrayList();
			while(rs.next()){
				HashMap hm1 = new HashMap();
				hm1.put("user_name", rs.getString("user_name"));
				userList.add(hm1);
			}
			return userList;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn.closeCon();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
}

