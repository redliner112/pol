package report.umwoosung.r0006;

public class Son extends Father{
	int a;
	
	public static void main(String[] args){
		Son s = new Son();
		s.a =3;
		System.out.println(s.getAdress());
		System.out.println(s.getAge());
		System.out.println(s.getName());
		s.setName("박경훈");
		System.out.println(s.getName());
		
	}

}
