package Exam02;

public class StringArray2 {
	int  num;
	public void printStr() {
		num = 2;
		System.out.println(num);
		System.out.println("함수 : printStr을 호출하셨네요");
	}
	public static void main(String[]args) {
		StringArray2 st2 = new StringArray2();
		st2.printStr();
//		st2.printStr();
//		Person p = new Person();
//		p.name = "박경훈";
//		p.adress = "서울시 강서구";
//		p.job = "시간강사";
//		p.doJob();
	}

}
