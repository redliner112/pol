package Exam03;

public class Father {

	int money = 10000;
	String car = "YF�ҳ�Ÿ";
	String house = "���� Ÿ���縮��";
	String who = "�ƺ�";
	
	public Father() {
		System.out.println("�ƺ������� �ӽñ� ȣ��������");
	}
	public void printHouse() {
		System.out.println(house);
	}

	public void doJob() {
		System.out.println(who + " �ƺ� �����ּ���");
	}

	public void doSleep() {
		System.out.println(who  + " �ƺ��� ��ϴ�");
	}
}
