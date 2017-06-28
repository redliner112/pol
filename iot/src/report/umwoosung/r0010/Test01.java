package home05;

import java.util.Scanner;

public class Test01 {
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		int result = 0;
		int [] num = new int [10];
		for(int i=0;i<num.length;i++){
			System.out.println((i+1) + "번째 학생의 점수를 입력해주세요");
			String Str = scan.nextLine();
			num[i] = Integer.parseInt(Str);
			result +=num[i];
			
		}
		System.out.println("점수의 총합은"+ result);
		System.out.println("평균=" + (result/num.length));
		
		for(int i = 0;i<num.length;i++){
			System.out.println(num[i]);
		}
	}
	
}//8 그냥 result가아니라  타입인 int 를 써워야한다.
//12 이것또한 그냥Str이 아니다. System.in에서 입력받는것이므로 String을 써줘야한다.
//입력한 숫자의 모든 결과값을 더한게 result이므로 result +=num[i];를써주자.
//for i값을 선언할때 타입을 잊지말자.

