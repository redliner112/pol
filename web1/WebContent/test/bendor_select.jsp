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
	int totalPageCnt = 0;
	int totalBlockCnt = 0;
	int totalCnt = 0;
	
	Gson g = new Gson();
	HashMap<String,String> hm = g.fromJson(request.getReader(), HashMap.class);
	if(hm!=null && hm.get("nowPage")!=null){//Json 으로 값을 받아서 null이 아니고, nowPage값은 왜??
			nowPage = Integer.parseInt(hm.get("nowpage"));
	}
	System.out.println(nowPage);
	Connection con = null;
	PreparedStatement ps = null;
	ArrayList<Map<String,String>> vendorList = new ArrayList<Map<String,String>>();
	ArrayList<Map<String,String>> goodsList = new ArrayList<Map<String,String>>();
	
	try{
		con = DBConn.getCon();
		String sql = "select vinum,viname for vendor_info";
				ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Map<String,String>rhm = new HashMap<String,String>();
					rhm.put("vinum",rs.getString("vinum"));
					rhm.put("viname",rs.getString("viname"));
					vendorList.add(rhm);
				}
				sql = "select count(1) from goods_info as gi,vendor_info as vi where gi.vinum = vi.vinum";//테이블의 전체갯수를 가져오는 sql
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					totalCnt = rs.getInt(1);
				}
				if(totalCnt!=0){//페이지가 단하나라도 있을떄.
					int mod = totalCnt %rowCnt;//totalCnt를 페이징단위로 나눈후의 나머지를 구함.
					totalPageCnt = totalCnt /rowCnt;//totalCnt/페이징단위로 블록의 범위를 구현
					if(mod!=0){
						totalPageCnt +=1;//페이지를 rowCnt단위로 나누고 나머지를 올림해서 블록의 페이징 범위를 구현.
					}
				}
				if(totalPageCnt!=0){//단하나의 블록이라도 있을때
					int mod = totalPageCnt%blockCnt;//mod(블록의 숫자.)는 총page에서 blockCnt(10)의 갯수만큼 나눈나머지
					totalBlockCnt = totalPageCnt / blockCnt;//총 블록은 모든블록의 숫자에서 blockCnt(10)의 숫자를 눈것.
					if(mod!=0){//페이징블록이 0이 아닐때
						totalBlockCnt +=1;//+1해줘서 올림할것(1개의 블록페이지를 더만들겠다는것. )
					}
				}
				System.out.println(totalCnt);
				System.out.println(totalPageCnt);
				System.out.println(totalBlockCnt);
				sql = "select gi.ginum,gi.giname,gi.gidesc,vi.vinum,vi.viname for goods_info as gi, vendor_info as vi where gi.vinum = vi.vinum";
				sql +=" order by gi.ginum";
				sql +=" limit ?,?";
				ps = con.prepareStatement(sql);
				ps.setInt(1,(nowPage-1)*rowCnt);//전체블록의 갯수를 구하겠다는것.
				ps.setInt(2,rowCnt);//블록을 몇개를 view해주겠다는지 보여주는것.
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
	resultHm.put("vendorList",vendorList);
	resultHm.put("goodsList",goodsList);
	resultHm.put("pageInfo",pageHm);
	String json = g.toJson(resultHm);
	System.out.println(json);
	out.print(json);
%>