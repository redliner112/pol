<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.User_Info" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.io.*" %>

<%
String id = null;
String pwd = null;
User_Info ui = null;
// id,pwd,User_Info ui 초기화.
Gson g = new Gson();
//Gson함수를 g에 대입후
ui = g.fromJson(request.getReader(), User_Info.class);
//User_Info.class(DTO)를 request.getReader()함수로 json구조체로 바꾼다고만 생각하고있는데 맞는건가요?
//넘어온 param구조체를 key와 value값으로 get해서  User_Info(DTO)인스턴스 변수들에 key와 value를 set하는작업 맞나요?  
String result = "";
//result가 빈문자열이고
String login = "false";
//login이 false면??(login.jsp 에서 true false가 넘어오는게 안보엿는데 어디서 넘어온건가요?)
if(ui!=null){
	//json구조체가 key value가 있을때
	
	Connection con = null;
	//서버에 접속안된상태이고
	PreparedStatement ps = null;
	//sql입력창이 빈창일때
	try{
		con = DBConn.getCon();
		//접속후 con에 대입.
		String sql = "select username, age, address, hp1, hp2, hp3, userpwd from user_info where userid=?";
		//userid=?로   user_info 의username,age,address,hp1,hp2,hp3,userpwd를 찾겠다는걸 sql을
		ps = con.prepareStatement(sql);
		//써놓은 상태 그걸 ps에 대입.
		ps.setString(1, ui.getUserId());
		// ui(DTO)에 넣어놨던 UserId()를 get해서 value를 첫번쨰 ?에 바인딩한후
		ResultSet rs = ps.executeQuery();
		//이거 다시 설명좀해주세요. 
		//select sql할떄는 executeQuery쓴다고 알고있는긴한데 정확하게 어떤식으로 동작하는건지 알고싶네요. 
		
		while(rs.next()){
			//while()함수로 false가 나올떄까지 rs.next()함수를 돌려서 DTO의 각각의 key들의 value를 get한후 userPwd,userName,age,address,hp1,hp2,hp3에 대입후
			
			String userPwd = rs.getString("userpwd");
			String userName = rs.getString("username");
			int age = rs.getInt("age");
			String address = rs.getString("address");
			String hp1 = rs.getString("hp1");
			String hp2 = rs.getString("hp2");
			String hp3 = rs.getString("hp3");
			if(userPwd.equals(ui.getUserPwd())){
				// userid로 찾은 sql문의 userPwd와 구조체되어있는 ui의 userPwd를 get해서 같은지 비교후 true면 아래함수 실행
				result =  "로그인 성공";
				//result 로그인성공대입
				login="ok";
				//login에 ok대입
				session.setAttribute("userid",ui.getUserId());
				//session이라는 데이터(객체)들을 공유할수있는 속성을 가진 객체의 setAttribute함수를 사용해서 지금사용하는 브라우저 내에서 (key:userid , value:ui.getUserId)로 공유하겠다는것맞나요?
				session.setAttribute("username",userName);
				session.setAttribute("age",age);
				session.setAttribute("address",address);
				session.setAttribute("hp1",hp1);
				session.setAttribute("hp2",hp2);
				session.setAttribute("hp3",hp3);
			}else{
				result =  "비밀번호 틀렸어 임마!";
				//아닐때는 비밀번호 틀렸다는거고
			}
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
	if(result.equals("")){
		result =  "그런 아이디 없다잖아!!";
		//빈문자열일떄는 아이디없잖아 를 result에 대입하는거고 
	}
}else{
	// ui가 null일떄(아무값도 없을떄)세션 초기화
	result = "로그아웃 되셨습니다.";
	session.invalidate();
}
HashMap hm = new HashMap();
//해쉬맵 hm생성후 
hm.put("login","ok");
//로그인이 되면 key:"login", value:"ok"
hm.put("msg",result);
//key:"msg",value: result(로그인성공)

String json = g.toJson(hm);//
//으로 Json구조체로 hm을 변환해서 json에 대입후
System.out.println(json);
out.write(json);
//out.write(json)대충 이해하면 login.jsp로 리턴하는걸로 생각했는데 검색해보니 모니터로 출력한다는데 맞나요?
%>