package report.umwoosung.r0009;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ListExam extends HashMap {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int i = 4; i >= 0; i--) {
			arrList.add(((int) (Math.random() * 45) + 1));
		}
		Collections.sort(arrList);
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i));
		}
	}
}
