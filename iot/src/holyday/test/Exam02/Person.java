package Exam02;

public class Person {
	String name;
	String address;
	String job;
	
	public Person(String name,String job) {
		this.name = name;
		this.job = job;
	}
	public void doJab() {
		System.out.println(name+ "����" + job + "�� �ϰ��ֽ��ϴ�.");
	}
public static void main(String[]args) {
	Person p = new Person("ȫ�浿","������");
	p.doJab();
	Person p1 = new Person("���浿","������");
	p1.doJab();
}
}
