package report.umwoosung.r0006;

public class NewExam {
	public static void main(String[]args){
	String str1 = "a";
	String str2 = "a";
	System.out.println(str1 == str2);
	str1 = new String("b");
	str2 = str1;
	
	System.out.println(str1 ==str2);
	}


}//new 를 해야지만 새로운 주소값이 생성된다.
