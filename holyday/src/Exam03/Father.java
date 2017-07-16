package Exam03;

public class Father {

	int money = 10000;
	String car = "YF소나타";
	String house = "강남 타워펠리스";
	String who = "아빠";
	
	public Father() {
		System.out.println("아빠생성자 머시기 호에에에엥");
	}
	public void printHouse() {
		System.out.println(house);
	}

	public void doJob() {
		System.out.println(who + " 아빠 일해주세요");
	}

	public void doSleep() {
		System.out.println(who  + " 아빠는 잡니다");
	}
}
