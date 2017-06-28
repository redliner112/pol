package report.umwoosung.r0005;
//Robot클래스가 가지고있는 3가지 함수를 직접 호출해서 결과값을 출력해주세요.
//단 로봇의 이름은 지로봇,나이는 10살입니다.
//Cal10 클래스를 사용하여 더하기 빼기 곱하기 나누기 연산값을 출력해주세요.
//단 첫번쨰 변수는 10 두번째 변수는 2입니다.
public class Exam {
	
	
	
	public static void main(String[]args){
		Robot r = new Robot("또봇",10);
		r.doChange();
		r.dokick();
		r.doRun();
		Cal10 c = new Cal10(10, 2, "+");
		c.printCal10();
		c = new Cal10(10, 2, "-");
		c.printCal10();
		c = new Cal10(10, 2, "*");
		c.printCal10();
		c = new Cal10(10, 2, "/");
		c.printCal10();
		
		
	}

}
