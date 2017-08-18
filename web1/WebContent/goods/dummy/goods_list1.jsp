<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="container" style="text-align: center; padding-top: 20px;padding-bottom: 20px;">
		<select id="s_vendor" class="selectpicker">
		</select> 
		<label>상품이름 : </label> <input type="text" id="giName" /> 
		<input type="button" id="searchGoods" value="검색" />
	</div>
	
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="giNum" class="text-center">상품번호</th>
				<th data-field="giName" class="text-center">상품이름</th>
				<th data-field="giDesc" class="text-center">상품설명</th>
				<th data-field="viNum" class="text-center">생산자번호</th>
				<th data-field="viName" class="text-center">생산자이름</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
		</tbody>
	</table>
</div>

<div class="jb-center" style="text-align: center">
	<ul class="pagination" id="page">
	</ul>
</div>

<script>
	var pageInfo = {};
	var nowPage = "<%=request.getParameter("nowPage")%>";
	
	if(nowPage=="null"){
		nowPage = "1";
	}
	$("#searchGoods").click(function() {
		var giName = $("#giName").val().trim();
		var viNum = $("#s_vendor").val().trim();
		if(giName=="" && viNum==""){
			alert("회사 선택이나 제품명을 입력해주세요.");
			return;
		}
		var params = {};
		if(giName!=""){
			params["giName"] = giName;
		}
		if(viNum!=""){
			params["viNum"] = viNum;
		}
		params["command"] = "list";
		var page = {};
		page["nowPage"] = nowPage;
		params["page"] = page;
		movePageWithAjax(params, "/list.goods", callback);
	});
	
	function callback(results) {
		//result에 넘어온 value는 
		//page:page <<page정보
		//list:list<< 한페이지(10로우)의 value들??
	    //search:goods <<goods DTO??
	   	//vendorList:vendorList<<vendor_info의 vinum과 viname넘김 
		var goodsList = results.list;
		//list는 goodsList에 대입.<<한페이지(10로우)의 value들
		pageInfo = results.page;
		//page는 pageInfo에 대입.<<페이지 계싼한것.
		var vendorList = results.vendorList;
		//vendorList는 vendorList에 대입.<<vendor_info의 모든 vinum과 viname의 value들
		var search = results.search;
		//search는 search에 대입<<goods의 DTO라고 생각하고있는데 맞는건가요?
		//8번
	
		var selStr = "<option value=''>회사선택</option>";
		//<option value=''>회사선택</option>을 selStr에 대입.
		for (var i = 0, max = vendorList.length; i < max; i++) {
			var vendor = vendorList[i];
			var selectStr = "";
			if(search.viNum==vendor.viNum){
				selectStr = "selected";
			}
			//goods DTO의 viNum과 vendor.viNum이 같다면 selected를 selectStr에 대입.
			selStr += "<option value='" + vendor.viNum + "' " + selectStr + ">" + vendor.viName
					+ "</option>";
		}
		//<optoin value='3'"selected">현대자동차</option> 
		//옵션검색후 남아있게 할려는걸로 알고있는데 저런식으로 들어가는게 맞는건가요??
		//5번
		
		$("#s_vendor").html(selStr);
		//s_vendor아이디가진 html에 selStr을 삽입.
		var params = {};
		if(search.viNum!=0){
			params["viNum"] = search.viNum;
		}
		//만약 goods의 DTO value인 viNum이 하나라도 있을때 params viNum을 넣고
		if(search.giName){
			params["giName"] = search.giName;
		}
		//조건도 없는데 이게왜 if조건문이 왜걸리나요??
		//6번
		
		makePagination(pageInfo,"page");
		// 총로우갯수들고 공통함수로가자 common.js 
		//만약다른사람이 짠걸 읽을때  공통함수가 있다는걸 모른다면 이걸어떻게 찾아야하나요??
		//7번 
		
		//					여기서부터 이어서 하면됨. 
		setEvent(pageInfo,params , "/list.goods");
		$('#table').bootstrapTable('destroy');
		var resultStr = "";
		for(var i=0, max=goodsList.length;i<max;i++){
			var goods = goodsList[i];
			resultStr += "<tr data-view='" + goods.giNum + "'>";
			resultStr +="<td class='text-center'>" + goods.giNum + "</td>";
			resultStr +="<td class='text-center'>" + goods.giName + "</td>";
			resultStr +="<td class='text-center'>" + goods.giDesc + "</td>";
			resultStr +="<td class='text-center'>" + goods.viNum + "</td>";
			resultStr +="<td class='text-center'>" + goods.viName + "</td>";
			resultStr +="</tr>";
		}
			
		$('#result_tbody').html(resultStr);
		$("tbody[id='result_tbody']>tr[data-view]").click(function(){
			var params = {};
			params["giNum"] = this.getAttribute("data-view");
			params["command"] = "view";
			var page = {};
			page["nowPage"] = pageInfo.nowPage;
			params["page"] = page;
			movePageWithAjax(params, "/list.goods", callBackView);
		})
	}
	function callBackView(result){
		var url = result.url + "?nowPage=" + result.page.nowPage + "&giNum=" + result.goods.giNum;
		url += "&giName=" + result.goods.giName;
		url += "&giDesc=" + result.goods.giDesc;
		url += "&viNum=" + result.goods.viNum;
		url += "&viName=" + result.goods.viName;
		location.href=url;
	}
	
	$(document).ready(function() {
		//페이지 시작시 무조건 실행.
		var page = {};
		//page를 json 구조로 마추기위해서 {}삽입. (json구조는 {}나 []구조체가 아니면 에러난다.)
		page["nowPage"] = nowPage;
		//{nowpage:nowpage}로 key:velue   <<<page는 movePageWithAjax에 포함되어 이동하지않는데 어떤 역활을 하는것인

		var params = {};
		//마찬가지로 params를 json구조로 마추기위해 {}삽입.
		params["page"] = page;
		//{page:page} key:value생성.
		params["command"] = "list";
		//{command:list} key:value생성.
		//parmas엔 결국 {page:page,command:list}구조로되서 movePageWithAjax로 이동.
		movePageWithAjax(params, "/list.goods", callback);
		//공통으로 빼놓은 ajax로 params,url,callback(success)를 보냄
		//callback을 정의만 해놓는다고 했는데 그럼 처음코드를 읽었을떄 이걸 정의만 해놨다고 알아볼수있는 구조는? 힌트나 그런것들이라도?			
		//4번 
		
	});
</script>
</body>
</html>