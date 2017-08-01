<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.BoardInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
  background-image:url('http://www.asrgo.com/files/attach/images/8131/206/056/bg_blog.jpg');
}
</style>

<body>
<%
int pBinum = Integer.parseInt(request.getParameter("binum"));
Connection con = null;
PreparedStatement ps = null;
int binum=0;
String bititle = "";
String	bicontent = "";
String bipwd = "";
String creusr = "";
String credat = "";
try{
	con = DBConn.getCon();
	String sql = "select binum,bititle,bicontent,bipwd,creusr,credat from board_info where binum= ?";
	ps = con.prepareStatement(sql);
	ps.setInt(1,pBinum);
	ResultSet rs = ps.executeQuery();
	rs.last();
	int rowCnt = rs.getRow();
	if(rowCnt ==0){
		
%>
			<script>
				alert("<%=pBinum%>번 게시물은 이미 지워졌습니다.");
				history.back();
			</script>
<%
	}
	
	rs.beforeFirst();
	while(rs.next()){
		binum = rs.getInt("binum");
		bititle = rs.getString("bititle");
		bicontent = rs.getString("bicontent");
		creusr = rs.getString("creusr");
		credat = rs.getString("credat");
	}
}catch(Exception e){
	System.out.println(e);
}finally{
	if(ps!=null){
		ps.close();
		ps=null;
	}
	DBConn.closeCon();
}
%> 

 <div class="container">
      <div class="starter-template">
<table class='table table-bordered table-hover'>
<tr>
<td>번호 :</td>
<td><%=binum %></td>
</tr>
<tr>
<td>제목 :</td>
<td><%=bititle %></td>
</tr>
<tr>
<td>내용 :</td>
<td><%=bicontent %></td>
</tr>
<tr>
<td>글쓴이: </td>
<td><%=creusr %></td>
</tr>
<tr>
<td>생성일자 :</td>
<td><%=credat %></td>
</tr>
<tr>
<td>비밀번호 :</td>
<td><input type = "password" name = "bipwd" id = "bipwd"/></td>
</tr>
<tr>
<td colspan="2">
<input type = "button" value = "수정" onclick = "modifyBoard()"/>
<input type = "button" value = "삭제" onclick = "deleteBoard()"/>
<input type="button" value="게시판가기" onclick="doMovePage('board')"/>
</td>
</tr>
</table>
</div>
</div>
<script>
function modifyBoard(){
	var bipwd = document.getElementById("bipwd").value;
	location.href = "<%=rootPath%>/board/board_modify.jsp?binum=<%=binum%>&bipwd=" +bipwd;
}
function deleteBoard(){
	var bipwd = document.getElementById("bipwd").value;
	location.href="<%=rootPath%>/board/board_delete.jsp?binum=<%=binum%>&bipwd=" + bipwd; 
}	

</script>
</body>
</html>
<%@ include file="/common/bottom.jsp"%>