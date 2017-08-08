 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<script src="/js/jquery-3.2.1.js?version=1.3.3"></script>
<script src="/ui/btsp3.7.7/js/bootstrap.min.js?version=1.3.3"></script>
<script src="/ui/btsp3.7.7/js/bootstrap-table.js?version=1.3.3"></script>
<link rel="stylesheet" href="/ui/btsp3.7.7/css/bootstrap-theme.min.css?version=1.3.3"/>
<link rel="stylesheet" href="/ui/btsp3.7.7/css/bootstrap.min.css?version=1.3.3"/>
<link rel="stylesheet" href="/ui/btsp3.7.7/css/bootstrap-table.css?version=1.3.3"/>
<link rel="stylesheet" href="/ui/common.css?version=1.3.3"/>
<script>
var sBlockStr = "<li><a>◀◀</a></li>";
sBlockStr += "<li><a>◀</a></li>";
var eBlockStr = "<li><a>▶</a></li>";
eBlockStr += "<li><a>▶▶</a></li>";

function setPagination(sNum, eNum, nPage, objId){
	var pageStr = sBlockStr;
	for(var i=sNum, max=eNum;i<=max;i++){
		if(i==nPage){
			pageStr += "<li class='active'><a>" + i + "</a></li>";
		}else{
			pageStr += "<li><a>" + i + "</a></li>";
		}
	}
	pageStr += eBlockStr;
	$("#" + objId).html(pageStr);
}

var rootPath ="";
$(document).ready(function(){
	var nowUrl = "/test/cal.jsp";
	var obj = $("a[href='" + nowUrl +"']").parent().attr("class","active");//a[href=""]가 뭐하란거였지?<<""로 이동.
})
function doMovePage(pageId){
	var url="";
	if(pageId == "board"){
		url =rootPath +  "/board/board_select.jsp";
	}else if(pageId=="main"){
		url = rootPath + "/main.jsp";
	}else if(pageId=="insert"){
		url =rootPath +  "/board/board_insert.jsp";
	}
	location.href = url;
}
function goPage(pParams, pUrl, pCallBackFunc){
	var params = JSON.stringify(pParams);
	$.ajax({ 
    		type     : "POST"
	    ,   url      : pUrl
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : params
	    ,   success : pCallBackFunc
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
}
</script>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/main.jsp">HOME</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/board/board_select.jsp">게시판가기</a></li>
            <li><a href="/user/user_info.jsp">유저정보가기</a></li>
            <li><a href="/role/role_select.jsp">권한정보가기</a></li>
            <li><a href="/user/logout_ok.jsp">로그아웃</a></li>
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
    </nav>

<div class="container">
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="ginum" class="text-center">상품번호</th>
				<th data-field="giname" class="text-center">상품이름</th>
				<th data-field="gidesc" class="text-center">상품설명</th>
				<th data-field="vinum" class="text-center">생산자번호</th>
				<th data-field="viname" class="text-center">생산자이름</th>
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
<select id="s_vendor">
<option value="">회사선택</option>
</select> 
연산자 :
<input type="text" id="op" />
<input type="button" id="getCal" value="계산리스트호출" />
<div id="result_div" class="container"></div>
<script>
var thisBlockCnt = 0;
var thisNowPage = 0;
var thisTotalPage = 0;
function callback(results){
	var vendorList = results.vendorList;
	var goodsList = results.goodsList;
	var pageInfo = results.pageInfo;
	
	
	var blockCnt = new Number(pageInfo.blockCnt);
	thisBlockCnt = blockCnt;
	var nowPage= new Number(pageInfo.nowPage);
	thisNowPage = nowPage;
	var startBlock = Math.floor((nowPage-1)/blockCnt) * 10+1;
	var endBlock = startBlock+blockCnt-1;
	var totalPageCnt = new Number(pageInfo.totalPageCnt);
	thisTotalPage = totalPageCnt;
	if(endBlock>totalPageCnt){
		endBlock = totalPageCnt;
	}
	
	setPagination(startBlock, endBlock, pageInfo.nowPage,"page");
	
	for(var i=0, max=vendorList.length;i<max;i++){
		$("#s_vendor").append("<option value='" + vendorList[i].vinum + "'>"+vendorList[i].viname +"</option>")
	}
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable({
        data: goodsList
    });
    setEvent();
}
$(document).ready(function(){
	var params = {};
	params["nowPage"] = "1";
	goPage(params, "/test/vendor_select.jsp", callback);
});
function setEvent(){
	$("ul[class='pagination']>li>a").click(function(){
		var goPageNum = new Number(this.innerHTML);
		if(isNaN(goPageNum)){
			if(this.innerHTML=="◀"){
				thisNowPage -= thisBlockCnt;
			}else if(this.innerHTML=="◀◀"){
				thisNowPage = 1;
			}else if(this.innerHTML=="▶"){
				thisNowPage += thisBlockCnt;
			}else if(this.innerHTML=="▶▶"){
				thisNowPage = thisTotalPage;
			}
			if(thisNowPage<=0){
				thisNowPage = 1;
			}else if(thisNowPage>thisTotalPage){
				thisNowPage = thisTotalPage;
			}
			goPageNum = thisNowPage;
		}
		var params = {};
		params["nowPage"] = "" + goPageNum;
		goPage(params, "/test/vendor_select.jsp", callback);
	})
}
</script>
</body>
</html>