<<<<<<< HEAD
package report.umwoosung.r007;
=======
package report.umwoosung.r0007;
>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git

import java.util.Scanner;

public class Exam9 {
	private int a;
	private int b;
	private int result;
	Scanner scan;
	
	public Exam9(){ //생성자는 초기 값을 생성할 때 많이 사용한다.
		scan = new Scanner(System.in);
	}
	public void inputA(){
		System.out.print("초기 값을 입력해주세요. => ");
		this.a = Integer.parseInt(scan.nextLine());
	}
	public void inputB(){
		System.out.print("마지막 값을 입력해주세요. => ");
		this.b = Integer.parseInt(scan.nextLine());
	}
	
	public void result(){  //계산하는 함수.
		for(int i = a; i<=b; i++){
			result += i;
		}	
	}
	public int printResult(){ // 출력하는 함수.
		return result;
	}
// 계산과 출력하는 함수는 각각 만들어서 사용하기!!.

}
