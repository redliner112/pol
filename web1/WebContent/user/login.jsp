<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.User_Info"%>
<link rel="stylesheet"	href = "<%=rootPath %>/ui/signin.css"/>
<body>
 <jsp:include page="/common/top.jsp" flush="fasle">
 	<jsp:param name="login" value="<%=login %>"></jsp:param>
</jsp:include>
 <div class="container" >
<style>
body {
  background-image:url('http://cfile8.uf.tistory.com/image/136FC03E50D3961D1E9FDB');
}
</style>
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
    	$("button").click(function(){
    		alert(1);
    	});
    	$("#btn2").click(function(){
    		alert(2);
    	});
    </script>
</body>
</html>