package report.umwoosung.r0008;

import java.util.Scanner;

public class Father0 {
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		
		String initNum = scan.nextLine();
		int num1 = Integer.parseInt(initNum);
		String maxNum = scan.nextLine();
		int num2 = Integer.parseInt(maxNum);
		
		String[] arrStr = new String[(num2-num1)+1];
		
		for (int i = 0;i<=(num2-num1);i++){
			arrStr[i]= scan.nextLine();
			
		}
		
		for(int i=0;i<arrStr.length;i++){
			System.out.print(arrStr[i] + ",");
		}
	}
	
}
