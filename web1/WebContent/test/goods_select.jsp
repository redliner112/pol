<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/header.jsp"%>

	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="giname"  class="text-center">제품이름</th>
					<th data-field="gidesc"  class="text-center">제품설명</th>
					<th data-field="vinum"  class="text-center">생산회사</th>
					<th data-field="gicredat"  class="text-center">데이터 생성일자</th>
					<th data-field="gicretim"  class="text-center">데이터 생성시간</th>
					<th data-field="viname"  class="text-center">회사이름</th>
					<th data-field="videsc"  class="text-center">회사설명</th>
					<th data-field="viaddress"  class="text-center">회사주소</th>
					<th data-field="viphone"  class="text-center">회사전화번호</th>
					<th data-field="vicredat"  class="text-center">데이터생성일자</th>
					<th data-field="vicretim"  class="text-center">데이터생성시간</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
<select id="s_vendor">
<option value="">회사선택</option>
</select> 
제품이름<input type = "text" id = "vinum"/>
<input type = "button" id = "getgoods" value = "검색"/>
<div id = "result_div" class = "container"></div>
<script>
$(document).ready(function(){
	$("#s_vendor").append("<option value='1'>현대자동차</option>");
})
$("#getgoods").click(function(){
	var vinum = $("#vinum").val();
	var param = {};
	param["vinum"] = vinum;
	param = JSON.stringify(param);
	alert(param);
	var a = {
			type	:"POST"
		,	url		:"/test/goods_select_ok.jsp"
		,dataType	:"json"
		,beforeSend:function(xhr){
			xhr.setRequestHeader("Accept","application/json");
			xhr.setRequestHeader("Content-Type","application/json");
		}
		,	data	:param
		,	success: function(result){
			$("#table").bootstrapTable({
				data:result
			});
		}
		,	error:function(xhr,status,e){
			alert("에러:" +e);
		},
		done:function(e){
			
		}
	};
	$.ajax(a);
});
</script>

