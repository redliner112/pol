<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class = "contaner-view">
		<table id = "table" data-height = "460" class = "table table-bordered table-hover">
		<thead>
			<tr>
			<th colspan="2" class = "text-center"><h5 class="form-signin-heading">회사수정페이지</h5>
			</tr>
			<tr>
				<td class="col-md-2">회사이름</td>
				<td class="col-md-4"><input type ="text" name = "viName" id ="viName"></td>
			</tr>
			<tr>
				<td class="col-md-2">회사설명</td>
				<td class="col-md-4"><input type ="text" name = "viDesc" id = "viDesc"></td>
			</tr>
			<tr>
				<td class="col-md-2">회사주소</td>
				<td class="col-md-4"><input type ="text" name = "viAddress" id = "viAddress"></td>
			</tr>
			<tr>
				<td class="col-md-2">회사전화번호</td>
				<td class="col-md-4"><input type ="text" name = "viPhone" id = "viPhone" ></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button id = "btnInsert" class = "btn btn-primary " type = "button">작성완료</button>
					<button id = "goList" class = "btn"type = "button">취소</button>
				</td>
			</tr>
		</thead>
		</table>
	</div>
<body>
<script>
$("#btnInsert").click(function(){
	var params={};
	params["command"] = "insert";
	params["viName"] = $("#viName").val();
	params["viDesc"] = $("#viDesc").val();
	params["viAddress"] = $("#viAddress").val();
	params["viPhone"] = $("#viPhone").val();
	movePageWithAjax(params,"/liest.vendr",callbackInsert);
})
function callbackInsert(result){
	alert(result.msg);
	location.href = result.url;
	
}
	

</script>
</body>
</html>