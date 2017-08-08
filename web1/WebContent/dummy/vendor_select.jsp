<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.test.dto.Cal"%>

<%
	int rowCnt = 10;
	int nowPage = 1; 
	int blockCnt = 10;
	int totalPageCnt =0;
	int totalBlockCnt=0;
	int totalCnt = 0;
	
	Gson g = new Gson();
	HashMap<String,String> hm = g.fromJson(request.getReader(), HashMap.class);
	if(hm!=null && hm.get("nowPage")!=null){
		//
		nowPage = Integer.parseInt(hm.get("nowPage"));
	}
	System.out.println(nowPage);
	Connection con = null;
	PreparedStatement ps = null;
	ArrayList<Map<String, String>> vendorList = new ArrayList<Map<String, String>>();
	ArrayList<Map<String, String>>goodsList = new ArrayList<Map<String, String>>();

	try{
		con = DBConn.getCon();
		String sql = "select vinum, viname from VENDOR_INFO;";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Map<String, String>rhm = new HashMap<String, String>();
			rhm.put("vinum", rs.getString("vinum"));
			rhm.put("viname", rs.getString("viname"));
			vendorList.add(rhm);
		}
		sql = "select count(1) from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			totalCnt = rs.getInt(1);
		}
		if(totalCnt!=0){
			int mod = totalCnt %rowCnt;
			totalPageCnt = totalCnt / rowCnt;
			if(mod!=0){
				totalPageCnt +=1;
			}
		}
		if(totalPageCnt!=0){//단하나의 블록이라도 있을때
			int mod = totalPageCnt%blockCnt;//mod(블록의 숫자.)는 총page에서 blockCnt(10)의 갯수만큼 나눈나머지
			totalBlockCnt = totalPageCnt / blockCnt;//총 블록은 모든페이지의 숫자에서 blockCnt(10)의 숫자를 나눈것.
			if(mod!=0){//블록이 0이 아닐때
				totalBlockCnt +=1;//+1해줘서 올림할것(1개의 블록페이지를 더만들겠다는것. )
			}
		}
		System.out.println(totalCnt);
		System.out.println(totalPageCnt);
		System.out.println(totalBlockCnt);
		sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum";
		sql +=" order by gi.ginum ";
		sql +=" limit ?,?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, (nowPage-1)*rowCnt);
		ps.setInt(2, rowCnt);
		rs = ps.executeQuery();
		while(rs.next()){
			Map<String, String>rhm = new HashMap<String, String>();
			rhm.put("ginum", rs.getString("ginum"));
			rhm.put("giname", rs.getString("giname"));
			rhm.put("gidesc", rs.getString("gidesc"));
			rhm.put("vinum", rs.getString("vinum"));
			rhm.put("viname", rs.getString("viname"));
			goodsList.add(rhm);
		}
	}catch(Exception e){
		System.out.println(e);
	}finally{
		if(ps!=null){
			ps.close();
			ps = null;
		}
		DBConn.closeCon();
	}
HashMap<String,Integer> pageHm = new HashMap<String,Integer>();
pageHm.put("nowPage",nowPage);
pageHm.put("totalPageCnt",totalPageCnt);
pageHm.put("totalBlockCnt",totalBlockCnt);
pageHm.put("blockCnt",blockCnt);
pageHm.put("totalCnt",totalCnt);


HashMap resultHm = new HashMap();
//5.	2차원배열과 3차원배열을 섞어넣을떄 주의할점 같은것은?
//DTO방식으로 넣을때 HashMap형태와 DTO방식을 섞어넣어도 문제는 없는것인가?		
resultHm.put("vendorList", vendorList);
resultHm.put("goodsList", goodsList);
resultHm.put("pageInfo",pageHm);
String json = g.toJson(resultHm);
System.out.println(json);
out.print(json);
%>