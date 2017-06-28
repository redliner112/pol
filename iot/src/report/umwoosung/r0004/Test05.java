package report.umwoosung.r0004;

public class Test05 {
	int a = 0;
	int b = 0;

	public Test05() {

	}

	public Test05(int a) {
		this.a = a;

	}

	public void printA(int b, char a) {

	}

	public void printA(char a,int b) {

	}

	public static void main(String[] args) {
		Test05 e = new Test05(1);
		System.out.println(e.a);

	}

}//생성자.

//오버로딩의 조
//1.파라메터가 달라야하는데 데이터 타입이 달라야한다.
//2,갯수가 달라도 성립된다
//3. 순서가 달라도 성립된다
