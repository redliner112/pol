<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.User_Info"%>
	<div class = "contaner-view">
		<table id = "table" data-height = "460" class = "table table-bordered table-hover">
		<thead>
			<tr>
			<th colspan="3" class = "text-center"><h5 class="form-signin-heading">화사설명페이지</h5>
			</tr>
			<tr>
				<td class = "col-md-2">회사번호</td>
				<td class="col-md-4" colspan="2"><%=request.getParameter("viNum") %></td>
			</tr>
			<tr>
			<td>회사이름</td>
			<td colspan="2"><%=request.getParameter("viName") %></td>
			</tr>
			<tr>
			<td>회사설명</td>
			<td colspan="2"><%=request.getParameter("viDesc") %></td>
			</tr>
			<tr>
			<td>회사주소</td>
			<td colspan="2"><%=request.getParameter("viAddress") %></td>
			</tr>
			<tr>
			<td>회사전화번호</td>
			<td colspan="2"><%=request.getParameter("viPhone") %></td>
			</tr>
		</thead>
		</table>
	</div>
<body>
</body>
</html>