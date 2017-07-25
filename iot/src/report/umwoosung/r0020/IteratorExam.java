package report.umwoosung.r0020;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorExam {

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
