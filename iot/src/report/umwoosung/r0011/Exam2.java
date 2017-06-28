package report.umwoosung.r0011;

public class Exam2 {
	Exam e = new Exam();
	int a = 1;
	Exam2(){
		System.out.println("Exam2생성자 호출했네?");
	}
	public static void main(String[] args){
		Exam2 e2 = new Exam2();
		System.out.println(e2.a);
	}
}

/*e2.a는 1을 불러오게 했는데 어째서
 * 4 의 Exam e = new Exam();는 선언만 했을뿐인 e까지 같이
 * 호출되는것인가? 
 * 
 * 
 * 
 * 
*/
