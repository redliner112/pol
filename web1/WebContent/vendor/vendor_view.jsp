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
			<th colspan="3" class = "text-center"><h5 class="form-signin-heading">회사설명페이지</h5>
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
			<tr>
				<td>
					<button id = "btnUpdate" class = "btn btn-md-2 btn-primary btn-block" type = "button">수정</button>
				</td>
				<td>
					<button id = "buttonDelete" class = "btn btn-md-2 btn-primary btn-block"type = "button">삭제</butoon>
				</td>
				<td>
					<button id = "btnGoList" class = "btn btn-md-2 btn-primary btn-block" type = "button">목록으로</button>
				</td>
			</tr>
		</thead>
		</table>
	</div>
<body>
<script>
$("#buttonDelete").click(function(){
	var isDelete = confirm("해당상품을 삭제할꺼얌?");
	if(isDelete){
		var params = {};
		params["viNum"] = "<%=request.getParameter("viNum")%>";
		params["command"] = "delete";
		var page = {};
		page["nowPage"] = "<%=request.getParameter("nowPage")%>";
		params["page"] = page;
		movePageWithAjax(params,"/list.vendor",callBackView);
	}
})

function callBackView(result){
	alert(result.msg);
	if(result.url!=""){
		
		location.href = result.url + "?nowPage=" + result.page.nowPage;
	}
}
$("#btnGoList").click(function(){
	location.href="/vendor/vendor_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
});
$("#btnUpdate").click(function(){
	location.href="/vendor/vendor_update.jsp?nowPage=" + <%=request.getParameter("nowPage")%> + "&viNum=" + <%=request.getParameter("viNum")%>
});

</script>
</body>
</html>