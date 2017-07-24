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
<body>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");//1 action 태그로  html창에서  name으로id,pwd의 value를받고 
		
String result="";//result 초기화.
if (id != null && pwd != null) {
	User_Info ui = new User_Info();//dto파일선언 
	ui.setUserId(id);
	ui.setUserPwd(pwd);//2 null값이 아니면dto에 ui.setUserId(id),ui.setUserPwd(pwd)로 User_Info에 넣은후

	Connection con = null;
	PreparedStatement ps = null;
	try {
		con = DBConn.getCon();
		String sql = "select username,age,address,hp1,hp2,hp3,userpwd from user_info where userid=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, ui.getUserId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String userPwd = rs.getString("userpwd");//3.rs.next를 userpwd로 돌려서 rs.getString으로 원하는 값을 불러온후
			String userName = rs.getString("userName");
			int age = rs.getInt("age");
			String address = rs.getString("address");
			String hp1 = rs.getString("hp1");
			String hp2 = rs.getString("hp2");
			String hp3 = rs.getString("hp3");
			if (userPwd.equals(ui.getUserPwd())) {//dto의 저장된 getUserPwd가 서버의 userpwd와 같으면 성공
				result = "로그인성공";
				session.setAttribute("userid",ui.getUserId());
				session.setAttribute("username",userName);
				session.setAttribute("age",age);
				session.setAttribute("address",address);
				session.setAttribute("hp1",hp1);
				session.setAttribute("hp2",hp2);
				session.setAttribute("hp3",hp3);
			} else {
				result = "비밀번호 틀렸어 임마!";//틀리면 실패
			}
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	if (result.equals("")) {//만약 공백이면 아이디 없잖아.
		result = "그딴아이디 없잖아";

	}
	out.println(result);
}else{
			//세션초기화
	session.invalidate();  //invalidate??
}
		
 %>
<script>
var result = "<%=result%>";
alert(result);
location.href = "/user/login.jsp"
</script>
</body>
</html>