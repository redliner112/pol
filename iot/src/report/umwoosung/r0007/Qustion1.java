<<<<<<< HEAD
package report.umwoosung.r007;
=======
package report.umwoosung.r0007;
>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git

import java.util.Scanner;

public class Qustion1 {public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	
	String initNum = scan.nextLine();
	int num1 = Integer.parseInt(initNum);
	String MaxNum = scan.nextLine();
	int num2 = Integer.parseInt(MaxNum);
	
	String[] arrStr = new String[(num2-num1)+1];
	
	for(int i=0;i<=(num2-num1);i++){
		arrStr[i] = scan.nextLine();
	}
	
	for(int i=0;i<arrStr.length;i++){  //arrStr.length 방의 개수!
		System.out.print(arrStr[i] + ",");
	}
	
}
}
//1.String 배열을 선언하는곳부터 할수가없었다. 마땅한 해결방한이 있는것인가?
//2.new String [(b-a)+1]인곳이 String 이지만 int 인 a,b,가 들어갈수있는 이유는 
//배열의 방값을 정해주는수가 정수이기때문에 문제가 없는것인가?
