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
				<td class="col-md-2">회사번호</td>
				<td class="col-md-4"><input type ="text" name = "viNum" id = "viNum"></td>
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
					<button id = "btnUpdate" class = "btn btn-primary " type = "button">수정</button>
					<button id = "goList" class = "btn"type = "button">취소</button>
				</td>
			</tr>
		</thead>
		</table>
	</div>
<body>
<script>
$(document).ready(function(){
	var params = {};
	params["command"] = "vendorlist";
	movePageWithAjax(params,"/list.vendor",callback);
})
function callback(result){
	var params={};
	params["command"] = "view";
	params["viNum"] = "<%=request.getParameter("viNum")%>";
	var page={};
	page["nowPage"] = "<%=request.getParameter("nowPage")%>";
	params["page"] = page;
	movePageWithAjax(params,"/list.goods",callback2);
}
function callback2(result){
	$("#viNum").val(result.vendor.viNum);
	$("#viName").val(result.vendor.viName);
	$("#viDesc").val(result.vendor.viDesc);
	$("#viAddress").val(result.vendor.viAddress);
	$("#viPhone").val(result.vendor.viPhone);
	
}
</script>
</body>
</html>