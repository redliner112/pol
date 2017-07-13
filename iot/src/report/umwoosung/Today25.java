package report.umwoosung;
/*
 * frame
 *  한화면에서 여러개의 프래임을 만들어서 고정프레임과함께쓰는것.
 *  
 * iframe
 *  화면옆에 배너처럼 작게 띄워둔창

 * ajax 비동기?
 * 
 * location.href  -url이 가는방향만 지정해주는것.
 * 
 * web.xml
 * 
 */



<script>function deleteBoard(title){
	location.href='delete.board?command=DELETE&title=' + title;
	}
</script>
<form action ='/test_web/sign.board'>
제목 : <input type = 'text' name = 'title' id = 'title'/>
<input type = 'submit' value='검색'/>
<input type = 'hidden' name='command' value='SELECT'/>
</form><table border='1'
<tr>
<td>제목</td>
<td>게시판내용</td>
<td>유저명</td>
<td>삭제버튼</td>
</tr>

<tr align = 'center'><td>게시판제목2</td>
<td>게시판내용2</td>
<td>1</td>
<td><input type = 'button' value='삭제' onclick='deleteBoard(게시판제목2)'/></td>
</tr><tr align = 'center'>

<td>게시판제목5</td>
<td>게시판내용5</td>
<td>3</td>
<td><input type = 'button' value='삭제' onclick='deleteBoard(게시판제목5)'/></td>
</tr>

<tr align = 'center'>
<td>게시판제목5</td>
<td>게시판내용5</td>
<td>3</td>
<td><input type = 'button' value='삭제' onclick='deleteBoard(게시판제목5)'/></td>
</tr>
</table>