<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.User_Info"%>
<link rel="stylesheet"	href = "<%=rootPath %>/ui/signin.css"/>
<style>
body {
  background-image:url('http://www.asrgo.com/files/attach/images/8131/206/056/bg_blog.jpg');
}
</style>
<body>
 <jsp:include page="/common/top.jsp" flush="fasle">
 	<jsp:param name="login" value="<%=login %>"></jsp:param>
</jsp:include>
 <div class="container" >

      <form action="<%=rootPath %>/user/login_ok.jsp" class="form-signin">
        <h2 class="form-signin-heading">Please login</h2>
        <label for="inputEmail" class="sr-only">ID</label>
        
        <input type="text" name="id" id = "id"class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
     
        <input type="password" name="pwd" id = "pwd"class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button">Login in</button>
      </form>

    </div> <!-- /container -->
    <script>
    $("button.btn").click(function(){
    	var id = $("#id").val();
    	var pwd = $("pwd").val();
    	var param;
    	param["id"]=id;
    	param["pwd"]=id;
    	param=JSON.stringify(param);
    	$.ajax({ 
	        type     : "POST"
	    ,   url      : "/user/login_ok.jsp"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : param
	    ,   success : function(result){
	    	alert(result.msg);
	    	alert(result.login);
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		done : function(e) {
		}
		});
    });
    </script>
</body>
</html>