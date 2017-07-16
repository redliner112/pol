package Exam03;

public class Method {
	int [] num1 = new int[10];
	
	public void setNum1(int num1) {
		System.out.println(num1);
	}
public int [] getNum1() {
	return num1;
}
public static void main(String[]args) {
	Method method = new Method();
	method.setNum1(3);
	int[] a = method.getNum1();
	System.out.println(a);
	String str = "주소값이 나올까?";
	String str2 = new String("보기싫다고");
	
	System.out.println(str);
	System.out.println(method);
}
}//멤버변수와 참조변수의 차이.(레퍼런스변수=참조변수)
