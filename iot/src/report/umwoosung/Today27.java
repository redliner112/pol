
/*
 * 자바는 class 기반 자바 
 * 스크립트는 function 기반.
 * 
 * form태그 lord구조에서 아래의 정보를 찾을수있다는건 위의 정보도 찾을수있다.
 * 아래로 내려갈때의 명령어
 * 위로 올라갈때의 명령어
 * 
 * 자바스크립트의 단어 틀린 에러잡는법.
 * (function 안에서 써야함. 스크립트만됨. html은 안됨)
 * 		try {
 * 
 * 			} catch (e) {
				alert(e)
				throw e;
			}
 * 
 * 
 * 자바스크립트에서 parseInt()와 Number()의 차이.
 * 
 * var strNum = "1";
console.log("parseInt : " + parseInt(strNum));
console.log("Number : " + Number(strNum));
둘다 동일한 숫자를 출력해줌.

var strNum = "2016년도";
console.log("parseInt : " + parseInt(strNum));
console.log("Number : " + Number(strNum));
parseInt() 는 숫자만 출력해주지만 Number()는 NaN값을 출력한다.

isNaN은 숫자일시 true값을 준다.

var Ajax = function(num){
	this.num = num;
	자바스크립트에서 클래스에 대입해서 쓸수있다.
	
	클래스 내에서 
	var num3=10;을 대입한순간 그클래스 내에서만 쓸수있는 private가되버린다.
	그래서 그 클래스밖에서 쓰고싶으면 private형식이 아니게되는 this num3=10을
	써줘야한다.
	그래야 하는 이유.
	-오버라이딩만 있어서 여러사람이 일할경우 다른사람의 함수명이 오버라이딩
		되기때문에 오버라이딩이 안되는걸로 쓰기위해서.
	
	
	클래스 밖에서는 그의미는 없다.
	
	ex)
function makeThing(btnObj){
	var fObj = btnObj.form;

		<form>
생성갯수 : <input type="text" name="makeNum"/>
<input type="button" value="생성!!!" onclick="makeThing(this)"/>
<div id="r_div"></div>
</form>
</body>

	form태그에서 var 변수 = this가 선언된 input 태그의 변수.form; 인경우
	from태그의 전체의 정보를 읽어들여서 변수에 대입한다.
	
	form태그에서 변수.elements[]는 폼태그의 배열변수를 의미.
		
		var elObjs = ducument.getElementsByName("txt"); - Elements에 주의.
		var elObjs = ducument.getElementById("txt");	-
		
		id는 하나의 Element만 가지고올수있고, 
		name은 여러가지의 Elements를 가지고 올수있따.
			조건1. name이 동일해야한다.
		
 */
