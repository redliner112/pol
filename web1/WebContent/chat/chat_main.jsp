<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<textarea id = "chat" rows =20 cols=60 style="resize:none"></textarea><br/><br/>
<input type = "text" name = "name" id = "name"/>
<input type = "text" name = "content" id = "content"/>
<input type = "hidden" name = "chatnum" id = "chatnum" value="0"/>
<input type = "button" value = "전송" onclick="doInsertChat()"/>
<script>
$(document).ready(function(){
	setInterval(doGetChat,1000);//1초마다 한번씩 새로고침.
})
function doGetChat(){
	var au = new AjaxUtil("chat_select.jsp","it_chatnum");
	au.setCallbackSuccess(callbackChat);
	au.send();
}
var callbackChat = function (list){
	for(var i=0,max=list.length;i<max;i++){//2222222for문에 조건이 2개달릴수있음?
		var chat = list[i];
		var str = chat.name + ":" + chat.content;
		$("#chatnum").val(chat.chatnum);//$이랑 #가 뭐였더라? val은??
				//>>#바로뒤는 ID다.$뒤면 무조건 jquery라고 알고있는데 어쩌란거지?
		$("#chat").append(str + "\n\r");//append는또뭐야?
	}
}
function doInsertChat(){
	var au = new AjaxUtil("chat_insert_ok.jsp","it_name,it_content");//""내에 ,로 두개나눌수있음? 효과는?
	au.send();
}
var AjaxUtil = function (url,params,type,dataType){
	if(!url){
		alert("url정보가 없습니다.");
		return null;
	}
	this.url = url;//this는 내자신인데 .url로 this를 먹인 이유가?
			//<<<펑션안의 this.은 public으로 되기때무네 그런거시여따
	var initData = {}
	initData["projectName"]="spring4";
	
	this.param = JSON.stringify(initData);//JSON.stringify가 뭐였지?
	if(params){
		var paramArr = params.split(",");
		
		var data={};//{}를 변수명에 대입하는 이유는 {}안에있는것들을 변수화 시키기위해서? 그렇다면 {}범위는 어디부터인가?
		for(var i=0,max=paramArr.length;i<max;i++){
			var objType = paramArr[i].split("_")[0];
			var objName = paramArr[i].split("_")[1];
			
			if(objType=="it"){
			data[objName] = $("input[name=" + objName + "]").val();
			}else if (objType=="s"){
				data[objName] = $("select[name=" + objName + "]").val();
			}
		}
		this.param = JSON.stringiry(data);
		
		
	}
	this.type = type?type:"POST";
	this.dataType = dataType?dataType:"json";//????
	this.callbackSuccess = function(json){
		var rul = json.url;//json.url은 어디서 급나온것인지??
		var data = json.data;
		var msg = json.msg;
		if(msg){
			alert(msg);
		}
		if(url){
			pageMove(url);
		}
	}
	this.setCallbackSuccess = function(callback){
		this.callbackSuccess = callback;
	}
	this.send = function(){//그냥 해쉬맵형태로 send해준다고 생각합니다. 
		$.ajax({
			type 	:this.type
		,	url		:this.url
		,	dataType : this.dataType
		,	data	:this.param
		,	success	:this.callbackSuccess
		,	error	:function(xhr,status,e){//근데 xhr,status,e는 모르겠다.
			alert("에러:" +e);
		},
		done :function(e){
		}
		})
	}
}
</script>
</body>
</html>