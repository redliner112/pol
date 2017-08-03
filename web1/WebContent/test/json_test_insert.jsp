<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@page import = "com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
Gson g = new Gson();
HashMap<String,String>hm = g.fromJson(request.getReader(),HashMap.class);
String jnumStr = hm.get("jnum2");
int jnum = Integer.parseInt(jnumStr);
String jttext = hm.get("jttext");
int result =0;
Connection con= null;
PreparedStatement ps = null;
int insertResult = 0;
try{
	con = DBConn.getCon();
	String sql = "insert into json_test(jtnum,jttest) values(?,?)";
	ps = con.prepareStatement(sql);
	ps.setInt(1,jnum);
	ps.setString(2,jttext);
	insertResult = ps.executeUpdate();
	if(insertResult==1){
		con.commit();
	}
}catch(Exception e){
	out.println(e);
}finally{
	ps.close();
	DBConn.closeCon();
}
HashMap<String,Integer> resultMap = new HashMap<String,Integer>();
resultMap.put("result",result);
resultMap.put("insert",insertResult);
String json = g.toJson(resultMap);
System.out.println(json);
out.print(json);
%>