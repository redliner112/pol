<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<table class = "table">
<tr>
<td>giname<input type="text" name="giname" id = "giname" /></td>
</tr>
<tr>
<td>gidesc<input type="text" name="gidesc" id = "gidesc" /></td>
</tr>
<tr>
<td>vinum<input type="text" name="vinum" id = "vinum" /></td>
</tr>
<tr>
<td>gicredat<input type="text" name="gicredat" id = "gicredat" /></td>
</tr>
<tr>
<td>gicretim<input type="text" name="gicretim" id = "gicretim" /></td>
</tr>

<td colspan="1">
<input type = "button" id = "insert" value = "입력하기"/>
</td>
</table>
<script>
$("#insert").click(function(){
	var giname = $("#giname").val();
	var gidesc =  $("#gidesc").val();
	var vinum =  $("#vinum").val();
	var gicredat =  $("#gicredat").val();
	var gicretim =  $("#gicretim").val();
	
	var param = {};
	param["giname"] = giname;
	param["gidesc"] = gidesc;
	param["vinum"] = vinum;
	param["gicredat"] = gicredat;
	param["gicretim"] = gicretim;
	param = JSON.stringify(param);
	var a = {
			type 	:"POST"
		,	url		:"/test/goods_insert.jsp"
		,dataType	:"Json"
		,beforeSend:function(xhr){
			xhr.setRequestHeader("Accept","application/json");
			xhr.setRequestHeader("Content-Type","application/json");
		}
		, data		:param
		, success	:function(result){
			$("#result").val(result.result);
		}
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		done : function(e) {
		}
		};
$.ajax(a);
alert("입력완료");
});

</script>
