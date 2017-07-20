/**
 * 
 */
//var AjaxUtil = function() {
//	var str = "문자겠지";
//	this.str2 = "나도문잔데";
//
//	this.alertVar = function() {
//		alert(str);
//		alert(this.str2);
//	}
//	this.getStr = function() {
//		return this.str2;
//	}
//
//}
//var au = new AjaxUtil();
//alert(au.getStr());
var str = "name,id,pwd";
var strs = str.split(",");

for(var i=0;i<strs.length;i++){
	var value = document.getElementById(strs[i]).value;
	param += "&" + strs[i] + "=" + value;
}
var au = new AjaxUtil("/login.action","name,id,pwd");
var AjaxUtil = function(url,arrParams,method,aSync){
	this.fAction = url;
	var fMethod = method ? method :"get";
	var params = "?action =LOGIN&id=" + encodeURIComponent(userid);
	this.fASync = aSync ? aSync : true; 
	xmlHttpObj.onreadystatechange = function(){
		if(xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
			var result  = decodeURIComponent(xmlHttpObj.responseText);
			if(result == "success"){
				location.herf = "../user/welcome.jsp"
			}else{
				alert(result);
			}
		}
	}
	xmlHttpObj.open(method,url+params,sync);
	if(method=="post"){
		xmlHttpObj.setRequestHeader("content-type","application/x-www-form-urlencoded");
		
	}
	xmlHttpObj.send(params);
}