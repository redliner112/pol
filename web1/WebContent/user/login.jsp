<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.User_Info"%>
<script>
var seObj;
var loopCnt = 0;
function doLogout(){
	location.href = rootPath + "/user/login_ok.jsp"
}

</script>
<body>
	<%
if(login){
	out.println("현재시간 : " + toDateStr);
	out.println("<br/>");
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
	out.println("<input type = 'button' value = '게시판가기' onclick = 'doMovePage(\"board\")'/>");
}else{
		
 %>
<form action="<%=rootPath %>/user/login_ok.jsp"> 
ID:<input type="text" name="id" /><br /> 
PWD:<input type="text"name="pwd" /><br /> 
<input type="submit" value="로그인" /><!-- action 태그로 form value를 user/login_ok.jsp에 전송.-->
</form>
<%
}
%>
</body>
</html>