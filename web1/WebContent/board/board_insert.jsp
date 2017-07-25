<%@ include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 입력</title>
</head>
<script>
function checkValue(){
	var titleObj = document.getElementById("title");
	if(titleObj.value.trim()==""){
		alert("제목 입력안해!! 죽어!!")
		return false;
	}
	var contentObj = document.getElementById("content");
	if(contentObj.value.trim()==""){
		alert("내용 입력안해!! 죽어!!")
		return false;
	}
	var userNumObj = document.getElementById("user_num");
	var userNum = parseInt(userNumObj.value);
	if(isNaN(userNum)){
		alert("숫자 입력하라고!!!!");
		return false;
	}
	return true; 
}
</script>
<body>
<form method="get" action="*.board" onsubmit="return checkValue()">
제목 : <input type="text" name="title" id="title"/><br/>
내용 : <textarea name="content" id="content"></textarea><br/>
글쓴이 : <input type="text" name="user_num" id="user_num"/><br/>
<input type="submit" value="글쓰기"/>
</form>
</body>
</html>