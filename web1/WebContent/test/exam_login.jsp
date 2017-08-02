<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.User_Info"%>
<link rel = "stylesheet" href = "<%=rooPath%>/ui/signin.css"/>
<style>
body {
  background-image:url('http://www.asrgo.com/files/attach/images/8131/206/056/bg_blog.jpg');
}
</style>
<body>
	<div class = "container">
		<form class="form-signin" action="<%=rootPath %>/main.jsp">
			<h2 class = "form-signin-heading"> Please login</h2>
			<label for ="inputEmail" class = "sr-only">ID</label>
			<input type = "text" autofocus>
			<label for="inputPassword" class = "sr-only"> Password	</label>
			<input type = "password" name = "pwd" id = "pwd" class = "form-control" placeholder = "password" required>
			<div class = "checkbox">
				<label><input type = "checkbox" value = "remember-me">Remember me</label>
			</div>
			<button id = "btn2" class = "btn btn-lg btn-primary btn-block" type = "button">Login</button>
		</form>
	</div>
	<script>
	$("button.btn").click(function)(){
		var id = $("#id").val();
		var pwd = $("#pwd").val();
		var param = {};
		param["userId"]=id;
		param["userPwd"]=pwd;
		param=JSON.stringify(param);
		var a = {
				type	:"POST"
			,	url		:"/user/login_ok.jsp"
			,	dataType		:"json"
			,	beforeSend :function(xhr){
				xhr.setRequestHeader("Accept","application/json");
				xhr.setRequestHeader("Content-Type","application/json");
				
				}
			,	data	:param
			,	success:function(result){
				alert(result.msg);
				if(result.login=="ok"){
					location.href = "<%=rootPath%>/main.jsp";
				}else{
					$("#id").val("");
					$("#pwd").val("");
			}
			}
			,	error	: function(xhr,status,e)	{
				alert("에러" +e)
			},
			done : function(e){
				
			}
		};
		$.ajax(a);
	});
	</script>
	</html>
	<%@include file = "/common/bottom.jsp:"%>