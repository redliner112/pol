package Exam03;

public class Son extends Father {
	
	String house = "������ ���̵�";

	public Son() {
		System.out.println("�Ƶ������ �ӽñ� ȣ��������");
	}

	public void printHouse() {
		System.out.println("�Ƶ���");
	}

	public static void main(String[] args) {
		Son s = new Son();
		s.doJob();
		s.printHouse();
		s.doSleep();
		System.out.println(s.house);
	}

}