<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    <%
    String test1= request.getParameter("id");
    String test2= request.getParameter("name");
    String test3= request.getParameter("age");
    String test4= request.getParameter("address");
    String test5= request.getParameter("address2");
    String test6= request.getParameter("hp1");
    String test7= request.getParameter("hp2");
    String test8= request.getParameter("hp3");
    String test9= request.getParameter("zipcode");
    String test10= request.getParameter("password");
    
    Map<String,String[]> map = request.getParameterMap();
    Iterator<String> it = map.keySet().iterator();
    while(it.hasNext()){
    	String name = it.next();
		String value = request.getParameter(name); 
    	out.println("입력하신"+name+"의값은"+value+"입니다");
    }
    %>
