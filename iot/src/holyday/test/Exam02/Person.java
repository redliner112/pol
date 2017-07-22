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
		System.out.println(name+ "님이" + job + "을 하고있습니다.");
	}
public static void main(String[]args) {
	Person p = new Person("홍길동","도적질");
	p.doJab();
	Person p1 = new Person("갈길동","난잡질");
	p1.doJab();
}
}
