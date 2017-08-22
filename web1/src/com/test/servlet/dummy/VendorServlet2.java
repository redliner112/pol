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

public class VendorServlet2 extends HttpServlet{
	
	
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
	    	result = g.toJson(vendorList);
	    	//return받은 vendorList를 toJson으로 json형태로 변환후  result에 대입.
	    	//인데 g.toJson은 DTO가 가지고있는 get함수를 자기가 돌려서 json형태로 만들어서 보내줌.
	    	//그래서 화면단에서 get함수를 쓰지않고 vendor.viNum으로 뽑아낼수있는거임.
	    }else if(command.equals("view")){
	    }else if(command.equals("delete")){
	    }else if(command.equals("insert")){
	    }else if(command.equals("update")){
	    }
	    doProcess(response, result);
	    //result의 value들을 화면단(success)으로 보냄.
	}
	
	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}
