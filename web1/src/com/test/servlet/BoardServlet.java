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

import com.test.service.BoardService;

public class BoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap hm;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");

		String command = req.getParameter("command");
		BoardService bs = new BoardService();

		if (command.equals("SIGNIN")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			System.out.println(title + "," + content + "," + writer);
			hm = new HashMap();
			hm.put("title", title);
			hm.put("content", content);
			hm.put("writer", writer);
			if (bs.InsertBoard(hm)) {
				doProcess(resq, "저장완료");
			} else {
				doProcess(resq, "값을 바르게 입력하세요");
			}
			
			
//		}else if(command.equals("SELECT")){
//			String title = req.getParameter("title");
//			System.out.println("이름:" + title);
//			HashMap hm = new HashMap();
//			if(title!=null && !title.equals("")){
//				hm.put("name", "%"+title+"%");
//			}
//			List<Map> titleList = bs.selectBoard(hm);
//			String result = "";
//			for(Map m : titleList){
//				result+=m.toString();
//			}
//			doProcess(resq,result);
		}else if(command.equals("DELETE")){
			String num = req.getParameter("num");
			System.out.println("삭제할번호:" + num);
			
			HashMap hm = new HashMap();
			hm.put("num", num);
			System.out.println(num);
			
			if(bs.deleteBoard(hm)){
				doProcess(resq,"삭제	완료");
			}else{
				doProcess(resq,"삭제	실패");
			}
			
		}else if(command.equals("UPDATE")){
			String num = req.getParameter("num");
			System.out.println("업데이트할번호:"+num);
			 
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			
			HashMap hm = new HashMap();
			hm.put("title", title);
			hm.put("content", content);
			hm.put("writer", writer);
		
			if(bs.updateBoard(hm)){
				doProcess(resq,"수정	완료");
			}else{
				doProcess(resq,"수정	실패");
			}
			
		}else if(command.equals("SELECT")){
			String title = req.getParameter("title");
			System.out.println("제목:" + title);
			HashMap hm = new HashMap();
			if(title !=null && !title.equals("")){
				hm.put("title", "%"+ title +"%");
				
			}
			List<Map> boardList = bs.selectBoard(hm);
			String result = "<script>";
			
			result +="function deleteBoard(num){";
			result +="location.href='delete.board?command=DELETE&num=' + num;";
			result +="}";
			result +="</script>";
			result +="<form action ='*.board'>";
			result +="제목 : <input type = 'text' name = 'title' id = 'title'/><input type = 'submit' value='검색'/>";
			result +="<input type = 'hidden' name='command' value='SELECT'/>";
			result +="</form>";
			result +="<table border='1'";
			result +="<tr>";
			result +="<td>번호</td>";
			result +="<td>제목</td>";
			result +="<td>게시판내용</td>";
			result +="<td>유저명</td>";
			result +="<td>삭제버튼</td>";
			result +="</tr>";
			for(Map m : boardList){
				result +="<tr align = 'center'>";
				result +="<td>" + m.get("num") + "</td>";
				result +="<td>" + m.get("title") + "</td>";
				result +="<td>" + m.get("content") + "</td>";
				result +="<td>" + m.get("writer") + "</td>";
				result +="<td><input type = 'button' value='삭제' onclick='deleteBoard(" + m.get("num") + ")'/></td>";
				result +="</tr>";
			}
			result +="</table>";
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