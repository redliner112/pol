package Exam02;

public class Exam01 {
	int num1 = 10;
	int num2 = 5;
	public void print1()	{
		
		System.out.println(num1);
	}
	public void print2()	{
		num1=5;
		System.out.println(num1);
	}
	public int printNum1() {
		return num1=10;
	}
	public String printStr() {
		return "" +num1;
	}
	
	public static void main(String[]args) {
		Exam01 e = new Exam01();
		e.print1();
		e.print2();
		int a = e.printNum1();
		System.out.println(a);
		String str = e.printStr();
		System.out.println(str);
	}
}
//�ڵ����� �����ϴ°͵� ������?
//������ �ǰ� �ȵǰ� ������ٸ� ���������ʴ� �Լ��� �����ϴ� ������? 