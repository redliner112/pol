<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.BoardInfo" %>

<%
String biTitile = request.getParameter("bititle");
String biContent = request.getParameter("bicontent");
String creUsr = request.getParameter("creusr");
String biPwd = request.getParameter("bipwd");//화면에있는 input들의 name으로 value를 받아옴.

String sql = "insert into board_info(bititle,bicontent,bipwd,creusr,credat)";
sql += "values(?,?,?,?,now())";

Connection con = null;
PreparedStatement ps = null;
String result = "저장 안된것같다";
	BoardInfo bi = new BoardInfo();
	int resultNum=0;
try{
	con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, biTitile);
			ps.setString(2, biContent);
			ps.setString(3, creUsr );
			ps.setString(4, biPwd);
			resultNum = ps.executeUpdate();
			if(resultNum==1){
				result = "정상적으로 저장되었습니다.";
				con.commit();
			}
			
}catch(Exception e){
	 System.out.println(e);
}finally{
	 if(ps!=null){
		 ps.close();
		 ps = null;
	 }
	 DBConn.closeCon();
}


%>
<script> 
alert("<%=result%>");
if(<%=resultNum%>==1){
	location.href="<%=rootPath%>/board/board_select.jsp";
}else{
	history.back();
}
</script>
<%@ include file="/common/bottom.jsp"%>