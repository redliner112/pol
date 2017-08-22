package com.test.servlet.dummy;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Vendor;
import com.test.service.VendorServiceImpl;

public class VendorServlet1 extends HttpServlet{
	//text타입으로만 넘긴것.
	
	private static final long serialVersionUID = 1L;
	private VendorServiceImpl vs = new VendorServiceImpl();
	//VendorService()함수를 vs에 대입
	private Gson g = new Gson();	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		request.setCharacterEncoding("UTF-8");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		
	    String command = request.getParameter("command");
	    //화면단에서 받은 params의 key가 command 이면 command변수에 대입후
	    System.out.println(command);
	    //command key값 출력.
	    String result = "";
	    //result 초기화후
	    if(command.equals("list")){
	    	//만약 command의 value가 list라면
	    	String viName = request.getParameter("viName");
	    	//params에서 받은 key값이 viName인것을 viName에 대입
	    	List<Vendor> vendorList = vs.selectVendorsList(viName);
	    	//vs함수의 selectVendorList함수에 파라메터를(viName)로넣고  리턴받은 값을 vendorList에 대입한후
	    	for(Vendor v : vendorList){
	    		//each대입으로 Vendor타입변수v에 리턴받은 vendorList를 하나씩 넣어준다.
	    		result += "<tr>";
	    		//빈문자열인 result에<tr>찍고
	    		result += "<td>" + v.getViNum() + "</td>";
	    		//+=<td>v.getViNum()</td> v.getViNum()함수로 Key값이 viNum인것의 value를 가져오고 아래4개마찬가지.
	    		result += "<td>" + v.getViName() + "</td>";
	    		result += "<td>" + v.getViDesc() + "</td>";
	    		result += "<td>" + v.getViAddress() + "</td>";
	    		result += "<td>" + v.getViPhone() + "</td>";
	    		result += "</tr>";
	    	}
	    }else if(command.equals("view")){
	    }else if(command.equals("delete")){
	    }else if(command.equals("insert")){
	    }else if(command.equals("update")){
	    }
	    doProcess(response, result);
	    //합쳐진 result의 value들을 화면단(success)으로 보냄.
	}
	
	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}
