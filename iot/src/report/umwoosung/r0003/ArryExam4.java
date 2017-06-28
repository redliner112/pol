package report.umwoosung.r0003;

public class ArryExam4 {
	public static void main(String[] args) {
		int[] a = new int[10];
		
		for (int i = 1; i <= 10 ; i++) {
			a[10-i] = i * 2;
		}
		for (int i = 1; i <= 10; i++) {
			System.out.println(a[i-1]);
		}
	}
}
// 인트형 배열변수를 선언해주시고 자리수는 10개로 만들어주세요
// for문에서 각각의 index에 2의 배수의 값을 넣어주세요
//12345678910
