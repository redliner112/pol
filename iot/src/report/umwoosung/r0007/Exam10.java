<<<<<<< HEAD
package report.umwoosung.r007;
=======
package report.umwoosung.r0007;
>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git
//!!Exam9에 private int a,b reslut를 선언해주세요
//Exam9 생성자에서 a값과 b값을 Scanner클래스의
//nextLine()함수를 사용하여 대입해주세요

import report.parkjonghun.r0007.Exam9;

//i가 a부터 b까지 도는 반복문을 작성한뒤
//result의 i를 반복문만큼 더하는 함수를 작성해주세요
//result의 값을 출력하는 함수를 작성해서 Exam10에서 출력해주시기 바랍니다.
public class Exam10 {public static void main(String[] args){
	Exam9 e9 = new Exam9();
	e9.inputA();
	e9.inputB();
	e9.result();  // 계산하는 함수 불러오기!
	System.out.println(e9.printResult()); // 출력하기.
}
}