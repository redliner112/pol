<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@page import = "com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<%
Gson g = new Gson();
String vinum = "";
HashMap<String,String>hm  =g.fromJson(request.getReader(),HashMap.class);

if(hm!=null){
	vinum = hm.get("vinum");
}
Connection con = null;
PreparedStatement ps = null;
ArrayList<Map<String,String>> vdList = new ArrayList<Map<String,String>>();
try{
	con = DBConn.getCon();
	String sql = "select gi.ginum, gi.giname, gi.gidesc, gi.vinum,gi.gicredat, gi.gicretim, vi.viname, vi.videsc, vi.viaddress, vi.viphone,vicredat,vicretim ";
			sql+="from GOODS_INFO gi, vendor_info vi where gi.vinum= vi.vinum ";
			
	
	if(vinum!=null && !vinum.equals("")){
		sql+=" and gi.vinum=?";
	}
	ps = con.prepareStatement(sql);
	if(vinum!=null && !vinum.equals("")){
		ps.setString(1,vinum);
		
	}
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		Map<String,String> rhm = new HashMap<String,String>();
		rhm.put("ginum", rs.getString("ginum"));
		rhm.put("giname", rs.getString("giname"));
		rhm.put("gidesc", rs.getString("gidesc"));
		rhm.put("vinum", rs.getString("vinum"));
		rhm.put("gicredat", rs.getString("gicredat"));
		rhm.put("gicretim", rs.getString("gicretim"));
		rhm.put("viname", rs.getString("viname"));
		rhm.put("videsc", rs.getString("videsc"));
		rhm.put("viaddress", rs.getString("viaddress"));
		rhm.put("viphone", rs.getString("viphone"));
		rhm.put("vicredat", rs.getString("vicredat"));
		rhm.put("vicretim", rs.getString("vicretim"));
		vdList.add(rhm);
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
String json = g.toJson(vdList);
System.out.println(json);
out.print(json);
	%>

