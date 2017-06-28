package report.umwoosung.r0009;

public class Exam {

	String[] str;
	
	Exam(){
		str[0] = "1";
	}
	
	Exam(int a){
		str = new String[3];
	}
	
	public static void main(String[] args){
		Exam e = new Exam();
		System.out.println(e.str[0]);
	}
}
