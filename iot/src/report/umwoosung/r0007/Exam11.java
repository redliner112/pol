<<<<<<< HEAD
package report.umwoosung.r007;
=======
package report.umwoosung.r0007;
>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git
//a와 b값을 초기화하는 Exam11생성자를 만들어주세요
//a와 b값을 더하기,빼기,나누기,곱하기 하는 함수를 각각4개 작성해주세요
///해당연산결과는 printResult()라는 함수를 호출했을때 나오게 프로그램을 작성해주시면됩니다.abstract

public class Exam11 {
	 protected int a; // protected 상속받기  Exam12에서 상속받기 위해서 선언해준거.
	 protected int b;
	int result;
	// a와 b를 초기화하는 Exam11생성자를 만들어주세요.
	// a와 b값을 더하기, 빼기, 나누기, 곱하기 하는 함수를 각각 4개 작성해주시고
	// 해당 연산결과는 printResult()라는 함수를 호출했을때 나오게 프로그램을 작성해주시면 됩니다.
	// 호출은 Exam12라는 클래스를 만들어서 그 안에서 해주시기 바랍니다.
	
	public Exam11(){}  //빈생성자 관련은 내일 설명. 빈생성자를 만들어 주어야 Exam12(int a, int b)가 에러가 안생김.
	public Exam11(int a, int b){ // 이게 a,b를 초기화하는 생성자.
		this.a = a;
		this.b = b;
		
	}
	
	
	protected void plusLoop(){
		result = a + b;
	}
	protected void mainusLoop(){
		result = a - b;
	}
	protected void multipleLoop(){
		result = a * b;
	}
	protected void divisionLoop(){
		result = a / b;
	}
	
	protected void printResult(){
		System.out.println(result);
				
	}

}
