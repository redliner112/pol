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
    $("button.btn").click(function(){
    	//셀렉터로 button의 class가btn찾은후 click하면 function()실행되고
    	var id = $("#id").val(); 
    	//셀렉터로 id가 id인것을 찾아서 value를 변수 id에 대입.
    	var pwd = $("#pwd").val();
    	//마찬가지로 id가 pwd인것을 찾은후 value를 pwd변수에 대입
    	var param={};
    	//{}란 param 구조체 틀에
    	param["userId"]=id;
    	// key:userId, value:id(정확하겐 id의 value)
    	param["userPwd"]=pwd;
    	// key:userPwd, value:pwd(정확하겐 pwd의 value)
    	param=JSON.stringify(param);
    	//userId,userPwd두개의 키값을 가진 params배열을 JSON구조로 파싱해서 param변수에 대입한후 
    	//id와 pwd의 value가 3일때 param은 {userId:3 , userPwd:3}의 구조채로 파씽되는게 맞는건가요?
    	var a = {
	        type     : "POST"
	        //POST타입으로 
	    ,   dataType : "json" 
	    //넘기는 데이터 타입은 json이고
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }//모릅니다.
	    ,   data     : param
	    //data는 param=>이런 구조체를{userId:3 , userPwd:3}
	    ,   url      : "/user/login_ok.jsp"
	    //url이 login_ok.jsp에 넘기고
	    
	    ,   success : function(result){
	    	//json구조체로 왔을때 
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