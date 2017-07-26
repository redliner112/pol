<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.BoardInfo" %>
<%@ page import="com.test.dto.User_Info" %>
<body>
<form action="<%=rootPath%>/board/board_insert_ok.jsp">
제목 : <input type="text" name="bititle"/><br/>
 내용: <textarea name="bicontent" ></textarea><br/>
 id : <input type="text" name="creusr"/><br/>
 비밀번호 : <input type="text" name="bipwd"/><br/>
	<input type="submit" value="작성완료"/>
	<input type="button" value="게시판가기" onclick="doMovePage('board')"/>
</form>
</body>
</html>