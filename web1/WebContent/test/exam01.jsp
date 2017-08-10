 
  
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
	var params = JSON.stringify(pParams);
	$.ajax({ 
    		type     : "POST"
	    ,   url      : "/list.goods"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : 
	    var page = {};
		page["nowPage"] = "1";
		var params = {};
		params["page"] = page;
		params["command"] = "list";
		
	    ,   success : 
	    	var goodsList = results.list;
	    	var pageInfo = results.page;
	    	setPagination(pageInfo, "page");
	    	setEvent(pageInfo);
	        $('#table').bootstrapTable('destroy');
	        $('#table').bootstrapTable({
	            data: goodsList
	        });
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});

</script>
