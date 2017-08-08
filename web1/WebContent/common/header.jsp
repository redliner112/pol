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
<%!
public void printStr(String str){
	System.out.println("adfad");
}
%>
<%
String userId = (String)session.getAttribute("userid");	
String userName = "";
int age = 0;
String address = "";
String hp1 ="";
String hp2 = "";
String hp3 = "";

boolean login = false;
if(userId!=null){
	 userName = (String) session.getAttribute("username");//(String)왜붙였지?
	 age = (int) session.getAttribute("age");
	 address = (String) session.getAttribute("address");
	 hp1 = (String) session.getAttribute("hp1");
	 hp2 = (String) session.getAttribute("hp2");
	 hp3 = (String) session.getAttribute("hp3");
	login = true;
}
String rootPath = request.getContextPath();//request.getContextPath();뭐였지?
Date toDate = new Date();//뭐였지??
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
String toDateStr = sdf.format(toDate);

String init = request.getParameter("init");
String defaultUrl = "";
if(init==null && !login){
	defaultUrl = rootPath + "/user/login.jsp?init=1";
	response.sendRedirect(defaultUrl);//로그인 페이지로이동하라는뜻.인데 init=1왜붙였지?
}
String nowUrl = request.getRequestURI();
String loginStr = "로그인";
if(login){
	loginStr = "로그아웃";
}
String version = "1.3.3";
%>
<script src="<%=rootPath%>/js/jquery-3.2.1.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap.min.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap-table.js?version=<%=version%>"></script>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-theme.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-table.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/common.css?version=<%=version%>"/>
<script>
		//1 79번째 라인까지 실행했을떄 data까지 ajax를통해서 그려지는 것인가?
var sBlockStr = "<li><a>◀◀</a></li>";
sBlockStr += "<li><a>◀</a></li>";
var eBlockStr = "<li><a>▶</a></li>";
eBlockStr += "<li><a>▶▶</a></li>";
function setPagination(sNum, eNum, nPage, objId){
	var pageStr = sBlockStr;
	for(var i=sNum, max=eNum;i<=max;i++){
		if(i==nPage){
			pageStr += "<li class='active'><a>" + i + "</a></li>";
		}else{
			pageStr += "<li><a>" + i + "</a></li>";
		}
	}
	pageStr += eBlockStr;
	$("#" + objId).html(pageStr);//		1. 이건왜 HTML로 넘기는것일까? 그려지는곳이 id가 page인 html태그쪽이라서?
}
//cal에있는 id가 page인것을 찾아서 그곳에 그려진다. 
//startBlock, endBlock,pageInfo.nowPage를가져온상태.(결국 data는 이따는거네)
var rootPath ="<%=rootPath%>";
$(document).ready(function(){
	var nowUrl = "<%=nowUrl%>";
	var obj = $("a[href='" + nowUrl +"']").parent().attr("class","active");//a[href=""]가 뭐하란거였지?<<""로 이동.
})
//$a[href='nowUrl'].parent().attr("class","active");//	1설명필요.
function doMovePage(pageId){
	var url="";
	if(pageId == "board"){
		url =rootPath +  "/board/board_select.jsp";
	}else if(pageId=="main"){
		url = rootPath + "<%=rootPath%>/main.jsp";
	}else if(pageId=="insert"){
		url =rootPath +  "/board/board_insert.jsp";
	}
	location.href = url;
}

function goPage(pParams, pUrl, pCallBackFunc){//ajax를 header로 빼놓은것.
	var params = JSON.stringify(pParams);
	$.ajax({ 
    		type     : "POST"
	    ,   url      : pUrl//"/test/vendor_select.jsp"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : params
	    ,   success : pCallBackFunc//cal의 3번단 실행.
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
}

</script>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=rootPath%>/main.jsp">HOME</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/board/board_select.jsp">게시판가기</a></li>
            <li><a href="/user/user_info.jsp">유저정보가기</a></li>
            <li><a href="/role/role_select.jsp">권한정보가기</a></li>
            <li><a href="/user/logout_ok.jsp"><%=loginStr %></a></li>
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
    </nav>