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
	    ,   dataType : "text" 
	    ,   data     : params
	    
	    ,   success : function(result){
	    	$("#result_tbody").html(result);
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
});

$(document).ready(function(){
	//vendor_list.jsp가 실행되면 바로 function()을 실행
	var params = "command=list";
	//key가 command이고 value가 list인것을 params에 대입.
	$.ajax({
	//ajax 함수로 구조체를 만들고 
			type	:"POST"
			//type은 POST로
		,	url		:"/list.vendor"
		//url은 /list.vendor로보내고 (결국 .vendor는 vendor서블릿으로 가게되어있음.)
		,	dataType : "text"
		//dataType은 text
		,	data	:params
		//data는 params(key:command,value:list)로 보낸다.
		
		,	success	:function(result){
			//보낸값이 result가 ajax구조체로 제대로 왔을때 function에 result파라메터를 넣어서
			$("#result_tbody").html(result);
			//셀렉터로 아이디가id가 result_tbody인 html안에 value를 삽입.
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