package report.umwoosung.r0002;

public class ArrayExam {
	public void printmultipleTable(int[]a , int[]b){
//		for(int i = int[]a;i<=b.length;i++){
//			int a = 0;
//			for(a =  a.length; a<b.length;a++])
//				System.out.print(i + "X" + a + " = " + (i * a) + ",");//3
//		}
//		System.out.println(i + "X" + a + " = " + (i * a));//4
	}
	
	public static void main(String[]args){
		int[] a = {1,2,3,4,5,7,10};
		int[] b = {1,2,3,4,5,7,10};
		

		for(int i =0; i<b.length;i++){
		System.out.println("b의" + (i+1) + "번째 방의값 ="+b[i]);
		}
	}

}//a 의 배열변수를 4개로 만들어놨다고 선언한것.
//b 는 방크기와 숫자를 일일이 대입한것.
//(배열변수의)방숫자는 0부터 시작한다.