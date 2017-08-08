<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

<div class = "container">
	<table id = "table" data-height = "460"
	class = "table table-boardered table-hover">
		<thead>
			<tr>
				<th data-field = "ginum" class = "text-center"> 상품번호</th>
				<th data-field = "giname" class = "text-center"> 상품이름</th>
				<th data-field = "gidesc" class = "text-center"> 상품설명</th>
				<th data-field = "vinum" class = "text-center"> 생산자번호</th>
				<th data-field = "viname" class = "text-center"> 생산자이름</th>
			</tr>
		</thead>
		<tbody id = "result_tbody">
		</tbody>
	</table>
</div>
<div class = "jb-center" style = "text-align:center">
	<ui class = "pagination" id = "page">
	</ui>
</div>
<select id = "s_vendor">
<option value = "">회사선택</option> <!--옵션쪽 value를 비워놓은 이유. -->
</select>
연산자:
<input type = "text" id = "op"/>
<input  type = "button" id = "getCal" value = "계산리스트 호출"/>
<div id = "result_div" class = "container"></div>
<script>
$(document).ready(function(){
	var params = {};
	params["nowPage"] = "1";
	params = JSON.stringify(params);
	var a = {
			type	:"POST"
		,	url		:"/test/bendor_select.jsp"
		,	dataType	:"json"
		,	beforeSend: function(xhr){
			 xhr.setRequestHeader("Accept", "application/json");
		     xhr.setRequestHeader("Content-Type", "application/json");
		}
		,	data	:params
		,	success:function(results){
			var vendorList = results.vendorList;
			var goodsList = results.goodsList;
			var pageInfo = results.pageInfo;
			
			var pageStr = "<li><a>◀◀</a></li>";
			pageStr +="<li><a>◀</a></li>";
			var blockCnt = new Number(pageInfo.blockCnt);
			var nowPage = new Number(pageInfo.nowPage);
			var startBlock = math.floor((nowPage-1)/blockCnt)*10+1;
			var endBlock = startBlock + blockCnt-1;
			var  totalPageCnt = new Number(pageInfo.totalPageCnt);
			if(endBlock>totalPageCnt){//블럭의 마지막단위가 10으로 안끝나도 한블럭을 만듬.
				endBlock = totalPageCnt;
			}
			for(var i=startBlock,max=endBlock;i<max;i++){
				if(i==pageInfo.newPage){
					pageStr +="<li class = 'active'><a>"+i+"</a><li>";
				}else{
					pageStr +="<li><a>"+i+"</a><li>";
				}
			}
			
			pageStr +="<li><a>▶</a></li>";
			pageStr +="<li><a>▶▶</a></li>";
			
			$("#page").html(pageStr);
			for(var i=0,max=vendorList.length;i<max;i++){
				$("#s_vendor").append("<option value='" + vendorList[i].vinum + "'>" + vendorList[i].viname + "</optoin>")
			}
			$("#table")bootstrapTable({
				data : goodsList
			});
		}
		,	error: function(xhr,status,e){
			alert("에러:" +e);
		},
		complete		:function(){
			
		}
	};
	$.ajax(a);
});
</script>