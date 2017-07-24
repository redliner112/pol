<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.User_Info"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function doLogout(){
	location.href = "/user/login_ok.jsp"
}
</script>
<script>
function doSelect(){
	location.href = "/user/select.jsp"
}
</script>
<body>
	<%
String userId = (String)session.getAttribute("userid");
if(userId!=null){
	String userName = (String) session.getAttribute("username");
	int age = (int) session.getAttribute("age");
	String address = (String) session.getAttribute("address");
	String hp1 = (String) session.getAttribute("hp1");
	String hp2 = (String) session.getAttribute("hp2");
	String hp3 = (String) session.getAttribute("hp3");
	out.println(userId + "님 환영합니다.");
	out.println("<br/>");
	out.println("=="+userId + "님 의정보==");
	out.println("<br/>");
	out.println("성명:" + userName);
	out.println("<br/>");
	out.println("나이:" + age);
	out.println("<br/>");
	out.println("주소:" + address);
	out.println("<br/>");
	out.println("전화번호:" + hp1 + hp2 + hp3);
	out.println("<br/>");
	out.println("<input type = 'button' value = '로그아웃' onclick = 'doLogout()'/>");
	out.println("<input type = 'button' value = 'select' onclick = 'doSelect()'>");
}else{
		
 %>
<form action="/user/login_ok.jsp"> 
ID:<input type="text" name="id" /><br /> 
PWD:<input type="text"name="pwd" /><br /> 
<input type="submit" value="로그인" /><!-- action 태그로 form value를 user/login_ok.jsp에 전송.-->
</form>
<%
}
%>
</body>
</html>