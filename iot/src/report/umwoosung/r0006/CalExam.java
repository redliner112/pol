package report.umwoosung.r0006;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//반복문을 사용하여 scanner클래스를 이용해
//총10명의 학생점수를 받아주세요
//10명의 학생의 총점과 평균을 구해주세요
public class CalExam {	
	public static void main(String[]args){
	Set<String>movie = new HashSet<String>();
	
	movie.add("대부");
	movie.add("소부");
	movie.add("광부");
	movie.add("파부");
	movie.add("포부");
	
	Iterator<String> itr = movie.iterator();
	while(itr.hasNext()){
		String s = itr.next();
		System.out.println(s);
	}
}
	
}
