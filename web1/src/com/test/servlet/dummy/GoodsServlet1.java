package com.test.servlet.dummy;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.GoodsService;

public class GoodsServlet1 extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private GoodsService gs = new GoodsService();
    private Gson g = new Gson();	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		request.setCharacterEncoding("UTF-8");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
	    
	    Goods goods = g.fromJson(request.getReader(), Goods.class);
	    //Goods DTO를 request.getReader()로 읽어서 g.fromJson()에 파라메터로 넣은후 json형태고 바꾸고 Goods타입의 goods변수에 대입. 
	    //DTO에 DB에 있는 데이터가 들어가는건 service에서 처리해준뒤라고 이해하고있는데 그럼 지금 request.getReader()가 json으로 변환하고있는건 무엇인가요?
	    //import com.test.dto.Goods;을 받았기떄문에 그냥 가능한건가요??
	    //1번
	    
	    String command = goods.getCommand();
	    //goods DTO에서 getcommand()를 가져와서 command에 대입.
    	Page page = goods.getPage();
    	//goodsDOT에서 getPage()함수를 가져와서 Page타입의 page함수에 대입.
    	
	    if(command.equals("list")){
	    	//command가 list일떄
	    	int totalCnt = gs.getTotalCount(goods);
	    	//getTotalCount()의 goods를 리턴받아 totalCnt에 대입.<<service로 ㄱㄱ
	    	page.setTotalCnt(totalCnt);
	    	//page에있는 setTotalCnt()에 service에서 받은 페이징계산한것을 넣고,
	    	List<Goods> list = gs.selectGoodsList(goods);
	    	//gs.selectGoodsList()에서 goods받아서 Goods로 되있는 List타입 list에 대입. selectGoodsList() ㄱㄱ0과 10나옴.
	    	List<Vendor> vendorList = gs.selectVendorsList();
	    	//selectVendorListㄱㄱ.. <<viname,vinum가지고있음
	    	HashMap resultMap = new HashMap();
	    	//resultMap변수로 HashMap생성.
	    	resultMap.put("page", page);
	    	//page:page <<page정보들
	    	resultMap.put("list", list);
	    	//list:list<< 한페이지(10로우)의 value들??
	    	resultMap.put("search", goods);
	    	//search:goods <<goods DTO??
	    	//9번 Goods goods = g.fromJson(request.getReader(), Goods.class); 에서 이미 goodsDTO의 value를 읽어들인거라 DTO의 value를 가져올수있는건가요?
	    	//>>정확하겐 화면단에서 servlet로params로 page와 command를 던진것을 set해주는것.
	    	
	    	resultMap.put("vendorList", vendorList);
	    	//vendorList:vendorList<<vendor_info의 vinum과 viname넘김 
	    	String jsonStr = g.toJson(resultMap);
	    	//이정보들을 g.toJson()로 json형태로 바꿔서  jsonStr에 대입하고
	    	doProcess(response, jsonStr);
	    	//떠나자 화면단으로 success만나로
	    	
	    }else if(command.equals("view")){
	    	Goods resultGoods = gs.selectGoods(goods);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("goods", resultGoods);
	    	resultMap.put("url", "/goods/goods_view.jsp");
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    	
	    }else if(command.equals("delete")){
	    	int result = gs.deleteGoods(goods);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("page", page);
	    	resultMap.put("msg", "삭제가 완료 되었습니다.");
	    	resultMap.put("url", "/goods/goods_list.jsp");
	    	if(result!=1){
		    	resultMap.put("msg", "삭제가 실패하였습니다.");
		    	resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
	    	
	    }else if(command.equals("vendorlist")){
	    	List<Vendor> vendorList = gs.selectVendorsList();
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("vendorList", vendorList);
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response,jsonStr);
	    	
	    }else if(command.equals("insert")){
	    	int  result = gs.insertGoods(goods);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("mag", "저장이 완료되쪄");
	    	resultMap.put("url", "/goods/goods_List.jsp");
	    	if(result!=1){
	    		resultMap.put("msg", "저장이 실패해쪄");
	    		resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response,jsonStr);
	    }else if(command.equals("update")){
	    	int result = gs.updateGoods(goods);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("msg", "수정이 완료되쪄");
	    	resultMap.put("url", "/goods/goods_list.jsp");
	    	if(result!=1){
	    		resultMap.put("msg", "수정이 실패해쪄");
	    		resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response,jsonStr);
	    }
	}
	
	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}