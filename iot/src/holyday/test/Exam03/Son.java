package Exam03;

public class Son extends Father {
	
	String house = "강서구 등촌동";

	public Son() {
		System.out.println("아들생성자 머시기 호에에에엥");
	}

	public void printHouse() {
		System.out.println("아들집");
	}

	public static void main(String[] args) {
		Son s = new Son();
		s.doJob();
		s.printHouse();
		s.doSleep();
		System.out.println(s.house);
	}

}
