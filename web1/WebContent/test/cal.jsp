<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<input type="text" id="num1_1">
+
<input type="text" id="num1_2">
<input type="button" value="계산"  id="cal1">
<input type="text" id="result1">

<br/>

<input type="text" id="num2_1">
-
<input type="text" id="num2_2">
<input type="button" value="계산"  id="cal2">
<input type="text" id="result2">

<br/>

<input type="text" id="num3_1">
*
<input type="text" id="num3_2">
<input type="button" value="계산"  id="cal3">
<input type="text" id="result3">

<br/>
<input type="text" id="num4_1">
/
<input type="text" id="num4_2">
<input type="button" value="계산"  id="cal4">
<input type="text" id="result4">
연산자 : <input type = "text" id = "op"/>
<input type = "button" id = "getCal" value = "계산리스트호출"/>
<div id = "result_div" class = "container"></div>

<script>
var ops = ["","+","-","*","/"];//0번째 방부터 순서대로 배열로 집어넣는다.
$("#getCal").click(function(){//$은 셀렉터. ()의 것을 무조건 실행한다. #은 input태그의  아이디값가져오는거 맞남?
	var op = $("#op").val();
	
	var param = {};
	param["op"] = op;
	param = JSON.stringify(param);
	var a = {
			type	:"POST"
		,	url		:"/test/cal_select.jsp"
		,dataType	:"json"
		,beforeSend:function(xhr){
			xhr.setRequestHeader("Accept","application/json");
			xhr.setRequestHeader("Content-Type","application/json");
		}
		, data		: param
		, success : function(results){
			for(var i=0,max=results.length; i<max; i++){//조건이 2개가 될수있나?
				var result = results[i];
				//$("#result_div").innerHTML += "adsf";
				//$("#result_div").append("adsf");
				$("#result_div").append(result.calnum + "," + result.num1 + ","+ result.op + ","+ result.num2 + "<br/>");
			}//append가뭐였지?
		}
		,	error : function(xhr, status, e){
			alert("에러:" +e);
		},
		done :function(e){
			
		}
	};
	$.ajax(a);
});
$("input[id*='cal']").click(function(){//[id*='cal']뭐였지?
	var id = this.id;//this.이건뭘까??
	var idx = id.substring(id.length-1);//1_1,2_1로 바꿀려는건 이해했는데 읽을수가없다.
	var num1 = $("#num"+ idx + "_1").val();
	var num2 = $("#num"+ idx + "_2").val();

	var param = {};
	param["num1"] = num1;
	param["num2"] = num2;
	param["op"] = ops[idx];
	param = JSON.stringify(param);
	var a = { 
	        type     : "POST"
	    	    ,   url      : "/test/cal_ok.jsp"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : param
	    	    ,   success : function(result){ 
	    	    	$("#result" + idx).val(result.num);  
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