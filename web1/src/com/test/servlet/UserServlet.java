package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.UserService;

public class UserServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{		
		req.setCharacterEncoding("UTF-8");
		
		String name1 = req.getParameter("name");
		String pwd1 = req.getParameter("pass");
		String test = req.getParameter("text");
		System.out.println("input html에서 네가 던진값이=>"+name1 + pwd1 +test );
		
		String command = req.getParameter("command");
		if(command==null){
			return;
		}
		UserService us = new UserService();
		if(command.equals("SIGNIN")){
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String class_num = req.getParameter("class_num");
			String age = req.getParameter("age");
			
			System.out.println(id + ","+pwd + ","+name + ","+class_num + ","+age);
			HashMap hm =new HashMap();
			hm.put("id", id);
			hm.put("pwd", pwd);
			hm.put("name", name);
			hm.put("class_num", class_num);
			hm.put("age", age);
				if(us.InsertUser(hm)){
					doProcess(resq,"저장완료");
				}else{
					doProcess(resq,"값을 바르게 입력하세요");
				}
				
				
				
		}else if(command.equals("DELETE")){
			String user_num = req.getParameter("user_num");
			System.out.println("삭제할번호 : " +  user_num);
			
			
			
		}else if(command.equals("UPDATE")){
			String user_num = req.getParameter("user_num");
			System.out.println("업데이트할번호 : " + user_num);
			
			String name = req.getParameter("name");
			String class_num = req.getParameter("class_num");
			String age = req.getParameter("age");
			
			HashMap hm = new HashMap();
			hm.put("name", name);
			hm.put("class_num", class_num);
			hm.put("age", age);
			
			
			
		}else if(command.equals("SELECT")){
			String name = req.getParameter("name");
			System.out.println("이름 : " + name);
			HashMap hm = new HashMap();
			if(name!=null && !name.equals("")){
				hm.put("name", "%"+ name+"%");
			}
			List<Map> userList = us.selectUser(hm);
			String result = "";
			for(Map m : userList){
				result += m.toString();
			}
			doProcess(resq,result);
		}
		
	}	

	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException{
		
	}

	
	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
		
	}
}