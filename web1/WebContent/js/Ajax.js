/**
 * 
 */

var AjaxUtil = function(params) {
	this.params = params;

	getHttpXmlObj = function() {
		if (window.XMLHttpRequest) {// 크롬일때
			return new XMLHttpRequest();
		} else if (window.ActiveXObjec) {
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
		alert("해당 브라우저가 ajaxt를 지원하지 않습니다.");
	}
	this.xhr = getHttpXmlObj();
		var method = "get";
		var url = "test.user";
		var aSync = true;
		
		this.xhr.onreadystatechange=function(){
			if(this.readyState==4){
				if(this.status==200){
					var result = decodeURIComponent(this.responseText);
					alert(result);
				}
			}
		}
		this.changeCallBack = function(func){
			this.xhr.onreadystatechang = func;
		}
		this.xhr.open(method,url + params,aSync);
		this.send= function (){
			this.xhr.sendarguments = this;
			this.xhr.send();
		}
}