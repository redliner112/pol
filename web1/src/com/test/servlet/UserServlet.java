package com.test.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
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
		
		Map<String,String[]>reqMap = req.getParameterMap();
		System.out.println(reqMap);
		Iterator<String> it = reqMap.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
		}
		
		String command = req.getParameter("command");
		if(command==null){
			return;
		
		}
		UserService us = new UserService();
		if(command.equals("LOGIN"));{//1
			
			String userid = req.getParameter("userid");
			String userpwd = req.getParameter("userpwd");//2
			
			HashMap hm = new HashMap();
			hm.put("userid", userid);
			hm.put("userpwd", userpwd);//3
			
			String result = us.loginUser(hm);//4
			
			doProcess(resq,result);//5
			
		} if(command.equals("SIGNIN")){
			String userid = req.getParameter("userid");
			String userpwd = req.getParameter("userpwd");
			String username = req.getParameter("username");
			String address = req.getParameter("address");
			String age = req.getParameter("age");
			String hp1 = req.getParameter("hp1");
			String hp2 = req.getParameter("hp2");
			String hp3 = req.getParameter("hp3");
			
			
			
			HashMap hm =new HashMap();
			hm.put("userid", userid);
			hm.put("userpwd", userpwd);
			hm.put("username", username);
			hm.put("address", address);
			hm.put("age", age);
			hm.put("hp1", hp1);
			hm.put("hp2", hp2);
			hm.put("hp3", hp3);
				if(us.InsertUser(hm)){
					doProcess(resq,"저장완료");
				}else{
					doProcess(resq,"값을 바르게 입력하세요");
				}
				
				
				
		
			
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
			String name = req.getParameter("username");
			System.out.println("이름:"+name);
			HashMap hm = new HashMap();
			if(name !=null &&!name.equals("")){
				hm.put("name", "%" + name + "%");
			}
			List<Map> userList = us.selectUser(hm);
			String result = "번호{/}이름{/}아이디{/}나이{+}";
			for(Map m:userList){
				result +=m.get("usernum") +"{/}" + m.get("username")+"{/}" + m.get("userid") + "{/}"+ m.get("age") + "{+}"; 
			}
			result = result.substring(0,result.length()-3);
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