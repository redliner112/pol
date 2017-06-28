package report.umwoosung.r0004;

import java.util.Scanner;

public class CarCalss2 {
	
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);//1
		int result = 0;//2
		int[] num = new int[5];//3
		for(int i=0;i<num.length;i++){
			System.out.println((i+1)+"번째 학생의 점수를 입력해주세요");//4
			String numStr = scan.nextLine();//5
			num[i] = Integer.parseInt(numStr);//6
			if(num[i] >100){
				System.out.println("이시꺄 니점수가 100점이 넘는다고? 다시 입력해 임마!!");
				i--;
			}else{
				result +=num[i];//7
			}
	
		}
		System.out.println("입력하신5명의 점수수의 총점은 ="+ (result));
		System.out.println("입력하신5명의 점수수의 평균은 ="+ (result/num.length));
		for(int i=0;i<num.length;i++){
			
			int temp;
			if(num[0]<num[0+1]){
				temp = num[0];
				num[0]=num[0+1];
				num[0+1] = temp;
			}
		}
		
	}
	

}//?? 100점중 으로 제한할려면?


//1 출력창에 입력가능하게함
//2 result의 값을 0으로 선언
//3 int[]num의 방이 5개 존제
//4 for반복문으로  i는 0 선언;i<5조건;i는 1씩증가
//5 numStr을 여러번쓸수있게 해주는 문구
//6 numStr의 값을 String에서 int[i]로 변환(num이 int num들어가야하지않나?)<=이미 int[]num = new int [5]로 선언이 되어있으므로 2개의 동일한 int 를 선언할수없으므로 num이라고 한다.
//7 int result = 값이 i로 증가하며 +=로 i<5 될때까지 반복
//생각의 과정이 