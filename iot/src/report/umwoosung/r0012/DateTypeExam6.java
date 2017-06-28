package report.umwoosung.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DateTypeExam6 extends DateTypeExam5  {
	
	public static void main(String[]args){
		ArrayList<HashMap> numList = new ArrayList<HashMap>();
		DateTypeExam6 dte5 = new DateTypeExam6();
		


		

		for (int i = 0; i < 2; i++) {
			numList.add(dte5.getHashMap());
		}

		for (int i = 0; i < numList.size(); i++) {
			HashMap resultHm = numList.get(i);
			System.out.print(resultHm.get("클래스") + ",");
			System.out.print(resultHm.get("이름") + ",");
			System.out.print(resultHm.get("나이") + ",");
			System.out.println(resultHm.get("성별"));

		}
	}
	}
	


