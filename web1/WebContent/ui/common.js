/**
 * 공통함수 javascript파일
 */
//Javascript Nuber객체 비교 프로토타입 함수 추가.
Number.prototype.equals = function(obj){
	if(obj instanceof Number){
		return this.toString() == obj.toString();
	}
	return this==obj;
}

//Ajax + Json 을 이용한 페이지 이동 공통 함수
function movePageWithAjax(pParams, pUrl, pCallBackFunc, pMethod){
	var params = JSON.stringify(pParams);
	$.ajax({ 
    		type     : pMethod ? pMethod:"POST"
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

//pagination 이벤트 적용 공통 함수
// * 단 ul태그 > li태그 > a태그 형식이여야하며
//    ul태그의 class명은 반드시 pagination이여야 함
function setEvent(pageInfo,params, pUrl){
	$("ul[class='pagination']>li:not([class='disabled'],[class='active'])>a").click(function(){
		var thisNowPage = pageInfo.nowPage;
		var goPageNum = new Number(this.innerHTML);
		if(isNaN(goPageNum)){
			if(this.innerHTML=="◀"){
				thisNowPage -= pageInfo.blockCnt;
			}else if(this.innerHTML=="◀◀"){
				thisNowPage = 1;
			}else if(this.innerHTML=="▶"){
				thisNowPage += pageInfo.blockCnt;
			}else if(this.innerHTML=="▶▶"){
				thisNowPage = pageInfo.totalPageCnt;
			}
			if(thisNowPage<=0){
				thisNowPage = 1;
			}else if(thisNowPage>pageInfo.totalPageCnt){
				thisNowPage = pageInfo.totalPageCnt;
			}
			goPageNum = thisNowPage;
		}

		var page = {};
		page["nowPage"] = "" + goPageNum;
		params["page"] = page;
		params["command"] = "list";
		movePageWithAjax(params, pUrl, callback);
	})
}

//하단페이지 블락을 자동으로 만들어주는 공통함수
//param : pageInfo =>페이지정보
//param : objId =>생성한 페이지 블락을 넣어줄 객체 아이디
function makePagination(pageInfo, objId){
	//objId는 page로 page DTO(페이지의 관한정보)
	var sNum = pageInfo.startBlock;
	//시작블락을 sNum으로 대입.(현재 57페이지를 볼떄 ((57-1)/10)*10+1하면 51이 시작블럭으로나옴 (가로안에 소수점은 없어짐)
	//결국 모두 11,21,31,41,51,....블럭으로 시작함.
	var eNum = pageInfo.endBlock;
	//endblock을 eNum에 대입. (11이 스타트 블럭일경우11+10-1=20 이나옴.
	//결국 모든 end블럭은 10,20,30,40...단위가됨.
	var nPage = pageInfo.nowPage;
	//nowpage는 nPage로. 
	var nTotal = pageInfo.totalPageCnt;
	//totalPageCnt는 nTotal로 대입. 전체 페이지 갯수.
	var pageStr = "";
	if(nPage==1){
		pageStr += "<li class='disabled'><a >◀◀</a></li>";
		pageStr += "<li class='disabled' ><a >◀</a></li>";
		//지금 페이지가 1페이지면 <<으로 블럭이동하는걸 disabled한다. 
	}else{ 
		pageStr += "<li><a>◀◀</a></li>";
		pageStr += "<li><a>◀</a></li>";
		//1페이지 넘어가면 활성화 시키고
	}
	for(var i=sNum, max=eNum;i<=max;i++){
		//i는 시작블럭이고,max는 end블럭일때 시작블럭이  end블럭보다 작거나같고 시작블럭은 ++될떄
		//시작블럭이 11이면 end까지가 20이고 결국 한블럭의 페이지 범위가 10개라는건가요??
		if(i==nPage){
			pageStr += "<li class='active'><a>" + i + "</a></li>";
		//만약 i가 지금 페이지면 active효과주는거고 
		}else{
			pageStr += "<li><a>" + i + "</a></li>";
		//다른곳은 그냥 그렇다고 
		}
	}
	if(nPage.equals(nTotal)){
		//만약 nowpage가 totalpage와 같다면 
		pageStr += "<li class='disabled'><a>▶</a></li>";
		pageStr += "<li class='disabled'><a>▶▶</a></li>";
		//>>에 disabled주는거고
	}else{ 
		pageStr += "<li><a>▶</a></li>";
		pageStr += "<li><a>▶▶</a></li>";
		//아님말고
	}
	$("#" + objId).html(pageStr);
	//$("#page").html(pageStr)을 대입하세요.
}
