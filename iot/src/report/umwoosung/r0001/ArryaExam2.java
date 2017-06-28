package report.umwoosung.r0001;

public class ArryaExam2 {
	public static void main(String[]args){
		int[]a = new int [6];
		for(int i = 0;i<a.length;i++){
			
			a[i] = (i+1);
		}
		a[0] =1;
		System.out.println("a의 첫번째값:" + a[0]);
		System.out.println("a의 마지막값:" + a[a.length-1]);
	}

}//파라매터란? 값을 넘겨받는 함수 ex) int a, int b
//호출하라란? 이클립스 창에쓴후 출력창에 출력하라는뜻