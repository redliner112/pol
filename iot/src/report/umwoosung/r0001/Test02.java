package report.umwoosung.r0001;

import java.util.Scanner;

public class Test02 {
	

	public void printMultipleTable(int initNum, int maxNum){
		for (int i =  initNum; i <= maxNum; i++) {//1
			int a = 1;
			for (a =  initNum; a < maxNum; a++) {//2
				System.out.print(i + "X" + a + " = " + (i * a) + ",");//3
			}
			System.out.println(i + "X" + a + " = " + (i * a));//4
		}
			
		}

	public static void main(String[] args) {
		Test02 t = new Test02();
		t.printMultipleTable(5,7);

	}//for안의for문은 1,2,3,을 maxNum을 2의 조건에 맞게 반복후
	//2의 조건이 3으로 안맞을시 4로 진행 다시 1로 돌아와서
	//1의 반복문이 적용되서 +1이되고 다시 2의 조건을마춰서 돌아가는
	//구조의 반복문이다.
}//호출을 한다는것은 Test02 t = new Test02();
//                          t.printMultipleTable(5,7); 의구조