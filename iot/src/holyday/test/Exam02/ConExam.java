package Exam02;

public class ConExam {
	
	int age = 32;
	String name = "홍길동";
	
	//age의 값이 20보다 작다면 10대라고 출력
	//age의 값이 30보다 작다면 20대라고 출력
	//age의 값이 40보다 작다면 30대라고 출력
	//age의 값이 50보다 작다면 40대라고 출력
	//age의 값이 60보다 작다면 50대라고 출력
	//age의 값이 60이상 이라면 관짜주세요 대라고 출력
	public ConExam(int age,String name) {
		this.age = age;
		this.name = name;
		if(age<20) {
			System.out.println("10대");
		}else if(age<30) {
			System.out.println("20대");
		}else if(age<40) {
			System.out.println("30대");
		}else if(age<50) {
			System.out.println("40대");
		}else if(age<60) {
			System.out.println("50대");
		}else if(age>60) {
			System.out.println("관짜주세요");
		}
		System.out.println(age);
		System.out.println(name);
	}
	
	public static void main(String[]args) {
		ConExam ce = new ConExam(55,"야나두");
	}

}
