<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.User_Info" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.*" %>
<%
/*
create table chat(
chatnum int auto_increment primary key,
name varchar(200) not null,
content varchar(4000) not null);

*/
HashMap<String,String> hm = null;
hm = new Gson().fromJson(request.getReader(),HashMap.class);//??????

String sql = "insert into chat(name,content)";
sql +=" values(?,?)";

Connection con = null;
PreparedStatement ps = null;
String result = "저장안되쪄";
int resultNum = 0;
try{
	con = DBConn.getCon();
	ps = con.prepareStatement(sql);
	ps.setString(1,hm.get("name"));
	ps.setString(2,hm.get("content"));
	resultNum = ps.executeUpdate();
	if(resultNum==1){
		result = "저장되쪄";
		con.commit();
	}
}catch(Exception e){
System.out.print(e);
}finally{
	if(ps!=null){
	ps.close();
	ps = null;
	}
	DBConn.closeCon();
}
String json = new Gson().toJson(hm);//Gson(). 변수.은 많이봤는데 함수.은 못봤다. 이거뭐인가? 그리고 toJson은 뭐지??
out.write(json);
%>