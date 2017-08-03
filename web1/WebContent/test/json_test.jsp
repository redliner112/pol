<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
번호<input type = "text" id = "jnum2"/>
내용<input type = "text" id = "jttext"/>
<input type = "button" id = "insertjson" value = "삽입하기"/>

<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="jnum"  class="text-center">번호</th>
					<th data-field="jttext"  class="text-center">내용</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
	번호 : <input type = "text" id = "jnum"/>
<input type = "button" id = "getjson" value = "넘버값호출"/>
<div id = "result_div" class = "container"></div>
<script>
$("#getjson").click(function(){
	var jnum = $("#jnum").val();
	var param = {};
	param["jnum"]=jnum;
	param = JSON.stringify(param);
	var a = {
			type	: "POST"
		,	url		:"/test/json_test_ok.jsp"
		,dataType	:"json"
		,beforeSend:function(xhr){
			xhr.setRequestHeader("Accept","application/json");
			xhr.setRequestHeader("Content-Type","application/json");
		}
		,data	: param
		,success: function(result){
			$('#table').bootstrapTable({
				data:result
			});
		}
		,error:function(xhr,status,e){
			alert("에러:"+e);
		},
		done : function(e){
			
		}
	};
	$.ajax(a);
});
$("#insertjson").click(funcktion{
	var param = {};
	param["jnum2"] = jnum2;
	param["jttext"] = jttext;
	param = JSON.stringify(param);
	var a = {
			type	:"POST"
			,	url		:"/json_test_insert.jsp"
			,	dataType		:"json"
			,	beforeSend : function(xhr){
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type","application/json");
			}
			,	data		:param
			,	success 	:function(result){
				$("#result").var(result.result);
			}
			,	error : function(xhr,status,e){
					alert("에러:" +e);
			},
			done :function(e){
				
			}
	};
	$.ajax(a);
});
</script>
</body>
</html>
	