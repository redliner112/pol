<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type = "button" id = "btn" value = "서블릿 이동"/>
<script>
$("#btn").click(function(){

	var params = {}; 
	params["num"] = "1";
	params["name"] = "홍길동";
	params["command"] = "test";
	params["struct"] = {"a":"1","b":"2"};
	params = JSON.stringify(params);
	$.ajax({ 
    		type     : "POST"
	    ,   url      : "/list.goods"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : params
	    ,   success : function(results){
		    	alert(result.struck.a);
	    	
	    }
	});
});
</script>
</body>
</html>