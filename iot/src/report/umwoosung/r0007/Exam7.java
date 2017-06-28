<<<<<<< HEAD
package report.umwoosung.r007;
=======
package report.umwoosung.r0007;
>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git

// private 접근제어자를 사용하여 int a,bc 3개의 변수를 선언해주세요.
//Exam7 생성자에서 위의 3개의 변수의 값을 바꿔주세요
//a,b,c,의 값을 리턴하는 함수 3개를 만들어주세요.
//Exam8 클래스를 생성하여 Exam7에 선언된 a.b.c의 값을 받아 출력하는 예제를 작성해주세요
public class Exam7 {
	private int a ;
	private int b ;
	private int c ;

	public Exam7(int a,int b,int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;

	}

	public int getC() {
		return c;

	}

}
