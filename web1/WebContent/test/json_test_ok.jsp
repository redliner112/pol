<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@page import = "com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
Gson g = new Gson();
HashMap<String,String> hm = g.fromJson(request.getReader(),HashMap.class);
String jnum = "";
if(hm!=null){
	jnum = hm.get("jnum");
}
System.out.println(jnum);

Connection con = null;
PreparedStatement ps = null;
ArrayList<Map<String,String>> jsonList	 = new ArrayList<Map<String,String>>();
try{
	con = DBConn.getCon();
	String sql = "select jtnum,jttext from json_text where 1=1";
	
	if(jnum!=null &&!jnum.equals("")){
		sql +=" and jtnum = ?";
	}
	ps = con.prepareStatement(sql);
	if(jnum!=null && !jnum.equals("")){
		ps.setString(1,jnum);
	}
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		Map<String,String>rhm = new HashMap<String,String>();
		rhm.put("jnum", rs.getString("jtnum"));
		rhm.put("jttext",rs.getString("jttext"));
		jsonList.add(rhm);
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
String json = g.toJson(jsonList);
System.out.println(json);
out.print(json);
%>