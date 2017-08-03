<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="calnum"  class="text-center">번호</th>
					<th data-field="num1"  class="text-center">숫자1</th>
					<th data-field="num2"  class="text-center">숫자2</th>
					<th data-field="op"  class="text-center">연산자</th>
					<th data-field="result"  class="text-center">결과값</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
연산자 : <input type = "text" id = "op"/>
<input type = "button" id = "getCal" value = "계산리스트호출"/>
<div id = "result_div" class = "container"></div>

<script>
var ops = ["","+","-","*","/"];//0번째 방부터 순서대로 배열로 집어넣는다.
$("#getCal").click(function(){//$은 셀렉터. ()의 것을 무조건 실행한다. #은 input태그의  ID가져오는거 맞아.
	var op = $("#op").val();
	
	var param = {};
	param["op"] = op;
	param = JSON.stringify(param);
	//a.type="POST"가 되는것이고, a.url="/test/cal_select.jsp"되는 구조체를 만드는것.
	var a = {
			type	:"POST"
		,	url		:"/test/cal_select.jsp"
		,dataType	:"json"
		,beforeSend:function(xhr){
			xhr.setRequestHeader("Accept","application/json");
			xhr.setRequestHeader("Content-Type","application/json");
		}
		, data		: param
		, success : function(result){
	        $('#table').bootstrapTable({
	            data: result
	        });
				//$("#result_div").innerHTML += "adsf";
				//$("#result_div").append("adsf");
				//$("#result_div").append(result.calnum + "," + result.num1 + ","+ result.op + ","+ result.num2 + "<br/>");
				//append가뭐였지? innerHTML +=을 자동으로 해주는것.
		}
		,	error : function(xhr, status, e){
			alert("에러:" +e);
		},
		done :function(e){//complete 성공과 실패의 상관없이 실행한다.
			
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