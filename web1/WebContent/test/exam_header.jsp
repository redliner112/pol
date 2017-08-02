<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import = "java.util.Date" %>
  <%@page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<% 
String userId = (String)session.getAttribute("userid");
String userName = "";
int age = 0;
String address = "";
String hp1 = "";
String hp2 = "";
String hp3 = "";

boolean login = false;
if(userId!=null){
	userName = (String)session.getAttribute("username");
	age = (int) session.getAttribute("age");
	address = (String) session.getAttribute("address");
	hp1 = (String) session.getAttribute("hp1");
	hp2 = (String) session.getAttribute("hp2");
	hp3 = (String) session.getAttribute("hp3");
	login = true;
}
String rootPath = request.getContextPath();
Date toDate = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
String toDateStr = sdf.format(toDate);

String init = request.getParameter("init");
String defaultUrl ="";
if(init==null && !login){
	defaultUrl = rootPath + "/user/login.jsp?init=1"	;
	response.sendRedirect(defaultUrl);
}
String nowUrl = request.getRequestURI();
String loginStr = "로그인";
if(login){
	loginStr = "로그아웃";
}
%>
<script src ="<%=rootPath%>/js/jquery-3.2.1.js"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/common.css"/>
<script>
var rootPath = "<%=rootPath%>";
$(document).ready(function(){
	var nowUrl = "<%=nowUrl%>";
	var obj = $("a[href='" + nowUrl + "']").parent().attr("class","active");
})
function doMovePate(pageId){
	var url = "";
	if(pageId =="board"){
		url = rootPath + "/board/board_select.jsp"	;
	}else if(pageId =="main"){
		url = rootPath + "<%=rootPath%>/main.jsp";
	}else if(pageId=="insert"){
		url = rootPath + "/board/board+insert.jsp";
	}
	location.href = url;
}
</script>
<body>
<nav class = "navbar navbar-inverse navbar-fixed-top">
	<div class = "container">
	<div class = "navbar-header">
	<button type = "button" class = "navbar-toggle collapsed" data-toggle = "collapse" data-target = "#navbar" aria-expended = "false" aria-controls = "navbar">
	<span class = "sr-only">Toggle navigation</span>
	<span class = "icon-bar"></span>
	<span class = "icon-bar"></span>
	<span class = "icon-bar"></span>
	</button>
	<a class = "navbar -brand" href = "<%=rootPath %>/main.jsp">Home</a>
	</div>
	<div id = "navbar" class = "collapse navbar-collapse">
		<ul class = "nav navbar-nav">
		<li><a href = "/board/board_select.jsp">게시판가기</a></li>
		<li><a href = "/user/user_info.jsp">정보가기</a></li>
		<li><a href = "/role/role_slelect.jsp">권한정보가기</a></li>
		<li><a href = "/user/logout_ok.jsp"><%=loginStr %></a></li>
		
		</ul>	
	</div>
	</div>
</body>
</html>