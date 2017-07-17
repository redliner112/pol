/**
 * 
 */

function checkValue(fObj){
	var maxNum = fObj.elements.length;
	
	var result = "";
	for(var i = 0;i<maxNum;i++){
		var eObj = fObj.elements[i];
		if(i%2 ==1 && i!= maxNum-1){
			try{
				if(inNaN(checkNum)){
					alert("숫자라고");
					eObj.value = "";
					eObj.focus();
					return false;
				}
				
			}catch(e){
				alert(e);
			}
		}
		if(eObj.value !="전송"){
			result +=eObj.value;
		}
		if(i== maxNum -1){
			eObj.value = result;
		}
		
	}
//	var eObj1 = fObj.elements[0];
//	var eObj1 = fObj.elements[1];
//	var eObj1 = fObj.elements[3];
//	eObj3.value = eObj1.value + eObj2.value;
//	return false;
}