package report.umwoosung.r0005;
//int 형변수 2개를 멤버변수로(클래스안에서 생성해야함)

//스트링형 변수 1개를 생성해주세요
//인트형 변수 num1,num2, 스트링형변수 operator
//printPlus(), PrintMinus(),PrintMultiple(),printDivision()
//cal2(int num1,int num2,String operator)생성자를 선언하여
//각각의 멤버변수에 대입해주세요
//그리고 위의 함수를 호출했을떄 원하는 결과값을 출력해주세요

public class Cal2 {
	int num1,num2;
	String operator;

	Cal2(int num1, int num2, String operator) {
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}

	void printCal2() {
		if (operator.equals("+")) {
			System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
		} else if (operator.equals("-")) {
			System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
		} else if (operator.equals("*")) {
			System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
		} else if (operator.equals("/")) {
			System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
		} else {
			System.out.println("연산자가 틀렸어요");
		}
	}

	public static void main(String[] args) {

		Cal2[] arrC = new Cal2[4];
		
		Cal2 c = new Cal2(8, 2, "+");
		c.printCal2();

		Cal2 c1 = new Cal2(8, 2, "-");
		c1.printCal2();

		Cal2 c2 = new Cal2(8, 2, "*");
		c2.printCal2();

		Cal2 c3 = new Cal2(8, 2, "/");
		c3.printCal2();

		arrC[0] = c;
		arrC[1] = c1;
		arrC[2] = c2;
		arrC[3] = c3;
	}

}
