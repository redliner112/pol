<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.BoardInfo" %>
<%@ page import="com.test.dto.User_Info" %>
<style>
body {
  background-image:url('http://www.asrgo.com/files/attach/images/8131/206/056/bg_blog.jpg');
}
</style>
<body>
<jsp:include page="/common/top.jsp" flush="fasle">
 	<jsp:param name="login" value="<%=login %>"></jsp:param>
</jsp:include>


<form action="<%=rootPath%>/board/board_insert_ok.jsp">
    <div class="container">
      <div class="starter-template">
<table class = "table">
<tr>
<td>제목 :</td>
<td><input type="text" name="bititle"/></td>
</tr>
<tr>
<td> 내용: </td>
<td><textarea name="bicontent" /></textarea></td>
</tr>
<tr>
<td>  id : </td>
<td><input type="text" name="creusr"/></td>
</tr>
<tr>
<td>  비밀번호 : </td>
<td><input type="text" name="bipwd"/></td>
</tr>
<tr>
<td colspan="2">
	<input type="submit" value="작성완료"/>
	<input type="button" value="게시판가기" onclick="doMovePage('board')"/>
</td>
	</table>
	</div>
</div>
</form>
</body>
</html>