<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
session.invalidate();
%>
<script>
alert("로그아웃돼쪄")
location.href="<%=rootPath%>/main.jsp";
</script>