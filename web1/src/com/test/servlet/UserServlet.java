package com.test.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.UserService;

public class UserServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{		
		//HTML 화면에서 던진값을 각각String 변수로 받기시작
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String class_num = req.getParameter("class_num");
		
		//위에서 받은 String변수를 출력해줌(tomcat콘솔창에)
		System.out.println(id + "," + pwd + "," + name + "," + class_num + ", " + age);
		//해쉬맵생성
		HashMap hm = new HashMap();
		hm.put("id",id);
		hm.put("pwd",pwd);
		hm.put("name",name);
		hm.put("age",age);
		hm.put("class_num",class_num);
		//users
		if(command.equals("SIGNIG")){
		UserService us = new UserService();
		
		us.InsertUser(hm);
		us.deleteUser(hm);
		
		if(us.InsertUser(hm)){
			doProcess(resq,"저장잘됬꾸만");
		}else{
			doProcess(resq,"값똑바로 입력해");
		}
		}else if(command.equals("DELETE")){
			String user_num= req.getParameter("user_num");
			System.out.println("삭제할 번호:"+ user_num);
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