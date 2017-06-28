package report.umwoosung.r0012;

import java.util.Scanner;

import report.umwoosung.r0011.ExceptionExam2;

public class FunctionExam {

	int[] arrNum = new int[4];
	Scanner scan = new Scanner(System.in);
	int num = 0;
	
	
	

	int getNumberFormString() {

		try {
			System.out.println((num+=1) +"번째 숫자를 넣어주세요");
			
			return Integer.parseInt(scan.nextLine());
			
		} catch (Exception e) {
			num--;
			System.out.println("누가문자넣으래");
			return getNumberFormString();
		}
	}

	public static void main(String[] args) {

		FunctionExam ee2 = new FunctionExam();

		for (int i = 0; i < ee2.arrNum.length; i++) {

			ee2.arrNum[i] = ee2.getNumberFormString();

		}
		for (int i = 0; i < ee2.arrNum.length; i++) {

			System.out.println(ee2.arrNum[i]);
	}
}
}