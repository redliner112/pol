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
	<div class="container">
		<form class="form-signin" action="<%=rootPath%>/main.jsp">
			<h2 class="form-signin-heading">Please login</h2>
			<label for="inputEmail" class="sr-only">ID</label> <input type="text"
				id="id" name="id" class="form-control" placeholder="ID" required
				autofocus> <label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="pwd" id="pwd" class="form-control"
				placeholder="Password" required><!--placeholder="Password" required?  -->
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button id="btn2" class="btn btn-lg btn-primary btn-block"
				type="button">Login</button>
		</form>

	</div>
	<!-- /container -->
    <script>
    $("button.btn").click(function(){//button.앞에 아무것도없으면 button태그를 의미. 의 .btn이면 class의 btn태그가 무조건 클릭되면 실행한다는것.
    	var id = $("#id").val(); //$바로뒤는 jquery이다.(이게뭘어쩌잔거지?) #바로뒤는 input 태그의 id를 말한다. .val는 값을 가져오는것.
    	var pwd = $("#pwd").val();
    	var param={};//도대체 이게무슨소린지 이해가안됨.<<초기화하는것과 비슷하다.
    	param["userId"]=id;//param["userId"]=id 라는건 인풋태그의 id 어찌변한다는거지?<<User_Info id,pwd가 set되는곳과 똑같이 이름을 userId,userPwd
    			//마추고난뒤 param에 id와 pwd의 값을 집어넣고 아래에서 
    	param["userPwd"]=pwd;
    	param=JSON.stringify(param);//.stringify(param)은 뭘하는거신가?<<prram을 JSON구조로 만들어서 다시 param에 집어넣는다.(pram이 바뀜.)
    	var a = {
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
	    	if(result.login=="ok"){
	    		location.href = "<%=rootPath%>/main.jsp";
	    	}else{
	    		$("#id").val("");
	    		$("#pwd").val("");
	    	}
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		done : function(e) {
		}
    	};
    	
    	$.ajax(a);
    });
    </script>
</body>
</html>
<%@ include file="/common/bottom.jsp"%>