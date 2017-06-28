<<<<<<< HEAD
package report.umwoosung.r007;
=======
package report.umwoosung.r0007;
>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git
//r0006패키지에 있는 RExam2의 변수값을 변환하고 출력해주세요.
//단 RExam2의 변수의 접근제어자를 바꾸시면 안됩니다.
//함수를 선언하여 해당문제를 풀어주시기 바랍니다.

import report.umwoosung.r0006.RExam2;

public class Exam3 {
	public static void main(String[]args){
		RExam2 re2 = new RExam2();
		System.out.println(re2.getA());
		System.out.println(re2.getB());
		//이뒤부터 설명필요.
		//void를 쓴것을 한번더 설명필요.
		re2.setA(3);
		re2.setB(4);
		System.out.println(re2.getA());
		System.out.println(re2.getB());		
		
		
	}

}
