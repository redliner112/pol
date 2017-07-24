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
	String str = "<table border = '1'>";
	for(int i =1;i<10;i++){
		str += "<tr>";
		for(int n=1;n<10;n++){
			str +="<td>" + i + "x" + n+"="+(i*n) + "</td>";
		}
		str +="</tr>";
	}
	str +="</table>";
	out.print(str);
%>
</body>
</html>