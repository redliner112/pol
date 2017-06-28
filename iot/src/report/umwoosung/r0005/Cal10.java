package report.umwoosung.r0005;

//클래스안에 스트링타입의 연산자를 저장하는 변수를 선언
//생성자에 연산자를 저장하는 로직을 만들고
//printcal10()이라는 함수를 만들어 해당함수를 호출하였을때 알맞는 연산이 되는지 프로그램을 만들어주세요
public class Cal10 {
	int a;
	int b;
	String operator;
	Cal10(){
		
	}
	Cal10(int a){
		System.out.println(a + "인트형변수 파라메터를 한개 가진 생성자를 호출하셨습니다");
		this.a = a;
	}
	
	Cal10(int a, int b, String operator) {
		this.a = a;
		this.b = b;
		this.operator = operator;
	}

	void printCal10() {
		if (operator.equals("+")) {
			System.out.println(a +"+"+ b+ "="  + (a + b));
		} else if (operator.equals("-")) {
			System.out.println("a - b = " + (a - b));
		} else if (operator.equals("*")) {
			System.out.println("a * b = " + (a * b));
		} else if (operator.equals("/")) {
			System.out.println("a / b = " + (a / b));
		} else {
			System.out.println("연산자가 틀렸어요");
		}
	}
	
	

	public static void main(String[] args) {
		Cal10 c = new Cal10(8,2 , "-");
		c.printCal10();

	}

}// 9,10은 자동으로 생성되는 생성자에 선언하고
	// 두번쨰 생성자를 만들어서 a,b를
	// 18은 프린트.this.으로 a,b는 첫생성자가 선언한 int a,와 int b라고 선언
	// 22 Cal을 c로 (int a,int b)값을 대입후 선언
	// 23. c(Car).printPlusO;를 불러온다.
