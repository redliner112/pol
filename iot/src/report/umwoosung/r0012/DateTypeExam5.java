package report.umwoosung.r0012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DateTypeExam5 {
	Scanner scan = new Scanner(System.in);

	public HashMap getHashMap() {
		HashMap hm = new HashMap();
		System.out.println("클래스를 입력해주세요");
		hm.put("클래스", scan.nextLine());
		System.out.println("이름를 입력해주세요");
		hm.put("이름", scan.nextLine());
		System.out.println("나이를 입력해주세요");
		hm.put("나이", scan.nextLine());
		System.out.println("성별를 입력해주세요");
		hm.put("성별", scan.nextLine());
		return hm;
	}
	
	

	public static void main(String[] args) {

		ArrayList<HashMap> numList = new ArrayList<HashMap>();

		DateTypeExam5 dte5 = new DateTypeExam5();
		for (int i = 0; i < 2; i++) {
			numList.add(dte5.getHashMap());
		}
		//DateTypeExam5 dte5 = new DateTypeExam5();
		//for (int i = 0; i < 2; i++) {
		//	numList.add(dte5.getHashMap());
		//이형태를 기억하자.

		for (int i = 0; i < numList.size(); i++) {
			HashMap resultHm = numList.get(i);
			System.out.print(resultHm.get("클래스") + ",");
			System.out.print(resultHm.get("이름") + ",");
			System.out.print(resultHm.get("나이") + ",");
			System.out.println(resultHm.get("성별"));

		}
	}

}
