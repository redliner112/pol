<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="container" style="text-align: center; padding-top: 20px;padding-bottom: 20px;">
		<label>회사이름 : </label> 
		<input type="text" id="viName" /> 
		<input type="button" id="searchVendor" value="검색" />
	</div>
	
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="giNum" class="text-center">회사번호</th>
				<th data-field="giName" class="text-center">회사이름</th>
				<th data-field="giDesc" class="text-center">회사설명</th>
				<th data-field="viNum" class="text-center">회사주소</th>
				<th data-field="viName" class="text-center">회사전화번호</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
		</tbody>
	</table>
	<button id = "btnInsert" class ="btn btn-primary" type = "button">상품등록</button>
</div>

<div class="jb-center" style="text-align: center">
	<ul class="pagination" id="page">
	</ul>
</div>

<script>

$("#btnInsert").click(function(){
	location.href="/goods/goods_insert.jsp";
})
$("#searchVendor").click(function() {
	var viName = $("#viName").val().trim();
	if(viName==""){
		alert("회사명을 입력해주세요.");
		return;
	}
	var params = "command=list&viName=" + viName;
	$.ajax({ 
    		type     : "POST"
	    ,   url      : "/list.vendor"
	    ,   dataType : "json" 
	    ,   data     : params
	    
	    ,   success : function(result){
	    	$('#table').bootstrapTable('destroy');
			var resultStr = "";
			for(var i=0, max=result.length;i<max;i++){
				var vendor = result[i];
				resultStr += "<tr data-view='" + vendor.viNum + "'>";
				resultStr +="<td class='text-center'>" + vendor.viNum + "</td>";
				resultStr +="<td class='text-center'>" + vendor.viName + "</td>";
				resultStr +="<td class='text-center'>" + vendor.viDesc + "</td>";
				resultStr +="<td class='text-center'>" + vendor.viAddress + "</td>";
				resultStr +="<td class='text-center'>" + vendor.viPhone + "</td>";
				resultStr +="</tr>";
			}
	    	$("#result_tbody").html(resultStr);
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
});

$(document).ready(function(){
		var params = "command=list&viNum=" +viNum;
	$.ajax({
			type	:"POST"
		,	dataType : "json"
		,	data	:params
		,	url		:"/list.vendor"
		
		,	success	:function(result){
			$("#table").bootstrapTable('destroy');
			var resultStr = "";
			for(var i=0,max=result.length;i<max;i++){
				var vendor = result[i];
				resultStr +="<tr data-view='" + vendor.viNum + "'>";
				resultStr +="<td class = 'text-center'>" + vendor.viNum + "</td>";
				resultStr +="<td class='text-center'>" + vendor.viName + "</td>";
				resultStr +="<td class='text-center'>" + vendor.viDesc + "</td>";
				resultStr +="<td class='text-center'>" + vendor.viAddress + "</td>";
				resultStr +="<td class='text-center'>" + vendor.viPhone + "</td>";
				resultStr +="</tr>";
			}
			$("#result_tbody").html(resultStr);
		}
		 ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
});

$("tbody[id='result_tbody']>tr[data-view]").click(function(){
	var params = "command=view";
	$.ajax({ 
		type     : "POST"
    ,   url      : "/list.vendor"
    ,   dataType : "json" 
    ,   data     : params
    
    ,   success : function(result){
    	$('#table').bootstrapTable('destroy');
		var resultStr = "";
		for(var i=0, max=result.length;i<max;i++){
			var vendor = result[i];
			resultStr += "<tr data-view='" + vendor.viNum + "'>";
			resultStr +="<td class='text-center'>" + vendor.viNum + "</td>";
			resultStr +="<td class='text-center'>" + vendor.viName + "</td>";
			resultStr +="<td class='text-center'>" + vendor.viDesc + "</td>";
			resultStr +="<td class='text-center'>" + vendor.viAddress + "</td>";
			resultStr +="<td class='text-center'>" + vendor.viPhone + "</td>";
			resultStr +="</tr>";
		}
    	$("#result_tbody").html(resultStr);
    }
    ,   error : function(xhr, status, e) {
	    	alert("에러 : "+e);
	},
	complete  : function() {
	}
});
});

</script>
</body>
</html>