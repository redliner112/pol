package report.umwoosung.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DateTypeExam2 {

	public static void main(String[] args) {
		ArrayList<HashMap> numList = new ArrayList<HashMap>();
		HashMap hm1 = new HashMap();
		hm1.put("번호", "1");
		hm1.put("제목", "게시물1");
		hm1.put("작성자", "홍길동");
		numList.add(hm1);

		HashMap hm2 = new HashMap();
		hm2.put("번호", "2");
		hm2.put("제목", "게시물2");
		hm2.put("작성자", "롱롱이");
		numList.add(hm2);
		
		HashMap hm3 = new HashMap();
		hm3.put("번호", "3");
		hm3.put("제목", "게시물3");
		hm3.put("작성자", "낭낭이");
		numList.add(hm3);
		
		HashMap hm4 = new HashMap();
		hm4.put("번호", "4");
		hm4.put("제목", "게시물4");
		hm4.put("작성자", "홍홍이");
		numList.add(hm4);
		
		for(int i=0;i<numList.size();i++){
		HashMap resultHm = numList.get(i);	
		System.out.print(resultHm.get("번호")+",");
		System.out.print(resultHm.get("제목")+",");
		System.out.println(resultHm.get("작성자"));
		}
	}

}
