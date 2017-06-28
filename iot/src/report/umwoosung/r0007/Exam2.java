<<<<<<< HEAD
package report.umwoosung.r007;
=======
package report.umwoosung.r0007;
>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git

import report.umwoosung.r0006.RExam4;

public class Exam2 {
	public static void main(String[]args){
		Exam1 e1 = new Exam1();
		System.out.println(e1.a);
		System.out.println(e1.b);

		Exam1 e2 = new Exam1();
		e1.a = 4;
		System.out.println(e2.a);
		System.out.println(e2.b);
		RExam4 e4 = new RExam4();
		System.out.println(e4.a);
		System.out.println(e4.b);
		
	}//퍼블릭 어디서든지 끌어올수있다.
	//디폴트 그 클래스 내에서만 쓸수있다.
	//프라이페티드 어디서든지 쓸수없다..

}
