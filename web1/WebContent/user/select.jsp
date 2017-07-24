<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String result = "";
if(id!=null ){
	User_Info ui  = new User_Info();
	ui.setUserId(id);
	
	Connection con = null;
	preparedStatement ps = null;
	try{
		con = DBConn.getCon();
		String sql = "select usernum,userid,username,age,address,hp1,hp2,hp3,userpwd form user_info";
				sql+=" where userid like ?";
				
	}catch(Exception e){
		System.out.println(e);
	}
	if(result.equals("")){
		result = "그런아이디 없잖아";
	}
	out.println(result);
}
%>

</body>
</html>