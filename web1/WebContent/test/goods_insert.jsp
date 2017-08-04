<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@page import = "com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
Gson g = new Gson();
HashMap<String,String>hm = g.fromJson(request.getReader(),HashMap.class);
String giname = hm.get("giname");
String gidesc = hm.get("gidesc");
String vinumStr = hm.get("vinum");
int vinum = Integer.parseInt(vinumStr);
String gicredat = hm.get("gicredat");
String gicretim = hm.get("gicretim");

int result=0;
Connection con = null;
PreparedStatement ps =null;
int  insertResult = 0;
try{
	con = DBConn.getCon();
	String sql = "insert into goods_info(giname,gidesc,vinum,gicredat,gicretim)";
			sql+="values(?,?,?,?,?)";
	ps = con.prepareStatement(sql);
	ps.setString(1,giname);
	ps.setString(2,gidesc);
	ps.setInt(3,vinum);
	ps.setString(4,gicredat);
	ps.setString(5,gicretim);
	insertResult = ps.executeUpdate();
	if(insertResult==1){
		con.commit();
	}
}catch(Exception e){
	out.println(e);
}finally{
	if(ps!=null){
		ps.close();
		ps = null;
	}
	DBConn.closeCon();
}
HashMap<String,Integer> resultMap = new HashMap<String,Integer>();
resultMap.put("result",result);
resultMap.put("insert",insertResult);
String json = g.toJson(resultMap);
System.out.println(json);
out.print(json);
%>
