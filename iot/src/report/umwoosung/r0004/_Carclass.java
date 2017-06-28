package report.umwoosung.r0004;

import java.util.Scanner;

public class _Carclass {
	
	
	public static void main(String[]args){
		
		Scanner scan = new Scanner(System.in);
		int result = 0;
		int[]num = new int[5];
		for(int i=0;i<num.length;i++){
			System.out.println((i+1) + "번쨰 학생의 점수는");
			String numStr = scan.nextLine();
			num[i] = Integer.parseInt(numStr);
			result +=num[i];
		}
		System.out.println("입력하신 5명의 총합은=" + result);
	}

}
