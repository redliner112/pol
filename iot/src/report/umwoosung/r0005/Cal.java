package report.umwoosung.r0005;

public class Cal {
	// 인트타입의 2개의 파라메터 변수를 받는 생성자를 하나만들어주세요
	// 클래스안에 인트타입의 변수2개를 선언해주시고(멤버변수)
	// 클래스안에있는 변수2개를 생성자에 받은 파라메터 변수값을 대입하여
	// printplus()를 함수에서 2개의 변수를 더한값을 출력해주세요

	int a;
	int b;
	
	public Cal(int a){
	this.a = a;
	
	}
	public Cal(int a, int b) {
		this.a = a;
		this.b = b;
	}

	void printPlus() {
		System.out.println(a + "더하기" + b + "=" + (a + b) + "입니다");
	}

	public static void main(String[] args) {
		Cal c = new Cal(1, 2);
		c.printPlus();

	}

}// 9,10은 자동으로 생성되는 생성자에 선언하고
	// 두번쨰 생성자를 만들어서 a,b를
	// 18은 프린트.this.으로 a,b는 첫생성자가 선언한 int a,와 int b라고 선언
	// 22 Cal을 c로 (int a,int b)값을 대입후 선언
	// 23. c(Car).printPlusO;를 불러온다.