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
			String sql = "insert into user_info(userid, userpwd,username,address,age,hp1,hp2,hp3)";
			sql+= "values(?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("userid"));
			ps.setString(2, hm.get("userpwd"));
			ps.setString(3, hm.get("username"));
			ps.setString(4, hm.get("address"));
			ps.setString(5, hm.get("age"));
			ps.setString(6, hm.get("hp1"));
			ps.setString(7, hm.get("hp2"));
			ps.setString(8, hm.get("hp3"));
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
	public String checkPwd(String pwd1,String pwd2){
		if(pwd1.equals(pwd2)){
			return"로그인성공";
		}
		return"비밀번호 틀렸어 임마!";
	}
	public String loginUser(HashMap<String,String>hm){
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = DBConn.getCon();//1
			
			String sql = "select userpwd form user_info where userid=?";
			ps = con.prepareStatement(sql);//2
			
			ps.setString(1, hm.get("userid"));
			ResultSet rs = ps.executeQuery();//3
			
			while(rs.next()){
				String userpwd = rs.getString("userpwd");
				return checkPwd(userpwd,hm.get("userpwd"));//4
			}
		}catch(Exception e){//5 
			//없는 이유가 데이터 타입이 없어서?
		}
		return "그딴아이디 없잖아";
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

