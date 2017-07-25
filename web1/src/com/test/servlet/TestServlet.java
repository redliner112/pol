package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.User_Info;
import com.test.service.UserService;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
	
		Map<String,String[]> reqMap = req.getParameterMap();
		System.out.println(reqMap);
		Iterator<String> it = reqMap.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
		}
		String userNum = req.getParameter("usernum");
		String userId = req.getParameter("userid");
		String userPwd = req.getParameter("userpwd");
		String userName = req.getParameter("username");
		String address = req.getParameter("address");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");// 2
		String age = req.getParameter("age");
		User_Info ui = new User_Info();
		if(userNum != null){
			ui.setUserNum(Integer.parseInt(userNum));
		}
		ui.setUserId(userId);
		ui.setUserPwd(userPwd);
		ui.setUserName(userName);
		ui.setAddress(address);
		ui.setHp1(hp1);
		ui.setHp2(hp2);
		ui.setHp3(hp3);// 3
		if(age !=null	){
			ui.setAge(Integer.parseInt(age));//문자값이 들어가면 넘버가 null이 되기떄문에?
		}
		String command = req.getParameter("command");
		if(command == null){
			return;
		}
		UserService us = new UserService();
		if(command.equals("LOGIN")){
			String result = us.loginUser(ui);
			doProcess(resq,result);
			
		}
	}

	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);

	}
}