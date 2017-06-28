package report.umwoosung.r0006;

import java.util.Scanner;

//반복문을 사용하여 scanner클래스를 이용해
//총10명의 학생점수를 받아주세요
//10명의 학생의 총점과 평균을 구해주세요
public class CalExam {

	public static void main(String[]args){
		
		Scanner scan = new Scanner(System.in);
		int result = 0;
		int[] a = new int[10];
			for(int i = 0;i<a.length;i++){
				System.out.print((i+1) +"번째학생의 점수를 입력해주세요.");
				a[i] = Integer.parseInt(scan.nextLine());
				result +=a[i];
				}
			System.out.print("입력하신 "+ a.length +"명의 점수총합은"+ result+"이고 평균은"+ (result/a.length) +"입니다");

		
	
		}
	
}
