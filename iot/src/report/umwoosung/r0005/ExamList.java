package report.umwoosung.r0005;

import java.util.ArrayList;
import java.util.List;

public class ExamList {
	public static void main(String[]args){
		ArrayList<Cal> list = new ArrayList<Cal>();
		for(int i=0;i<3;i++){
		Cal c = new Cal(i);
		list.add(c);
		}
		
		for(int i=0;i<3;i++){
			Cal c = list.get(i);
			System.out.println(c.a);
		}
		
		
	}//get 은 꺼낸다는의미
//add는 넣는다는 의미
}
// 8 list변수를 선언 <Cal>데이터타입만 입력할 수 있다고 선언,
// 9 for(선언;조건;변수)
// 10 c는 Cal(0),Cal(1),Cal(2)
// 11. list.add(c)=>함수로 풀어쓰면 c[0],c[1],c[2]
//14for(선언;조건;변수)
//15